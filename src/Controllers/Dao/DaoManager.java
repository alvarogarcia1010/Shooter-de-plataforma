/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 * @param <T>
 */
public abstract class DaoManager<T> implements DaoManagementInterface<T> {
    protected TableData infoTabla;

    
    public DaoManager(){

    }
    public DaoManager(TableData table) {
        this.infoTabla = table;
    }
    
    abstract T mapToObject(ResultSet resultado);
    
    abstract PreparedStatement getSelectStatement (Connection con, T find, String by);
    
    abstract PreparedStatement getInsertStatement (Connection con, T _new);
    
    abstract PreparedStatement getDeleteStatement (Connection con, T deleteObject);
    
    abstract PreparedStatement getUpdateStatement (Connection con, T updateObject);
    
    @Override
    public List<T> findAll(){
        Connection con = null;
        ArrayList<T> listObject = new ArrayList<>();
        try{
            con = this.con.getConnection();
            Statement query = con.createStatement();
            ResultSet resultado = query.executeQuery("SELECT * FROM " + infoTabla.TABLE_NAME);
            
            while(resultado.next()){
                T row = mapToObject(resultado);
                listObject.add(row);
            }
            
            resultado.close();
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(con);
        }
        
        return listObject;
    }
    
    public List<T> findBy(T find, String by){
        Connection con = null;
        ArrayList<T> listObject = new ArrayList<>();
        try{
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getSelectStatement(con,find,by);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                T row = mapToObject(resultSet);
                listObject.add(row);
                
            resultSet.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(con);
        }
        
        
        return listObject;
    }
    
    @Override
    public boolean insert(T insertObject){
      Connection con = null;
      boolean inserted = false;
      try{
          con = this.con.getConnection();
          PreparedStatement preparedStatement = getInsertStatement(con,insertObject);
          inserted = preparedStatement.execute();
          
          preparedStatement.close();
          
      }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);          
      }finally{
          close(con);
      }
          
      return inserted;
    }
    
    public boolean delete(T deleteObject){
        Connection con = null;
        boolean deleted = false;
        try{
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getDeleteStatement(con, deleteObject);
            if(preparedStatement.executeUpdate()>0){
                deleted = true;
            }
            
            preparedStatement.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);          
        }finally{
            close(con);
        }
        return deleted;
    }
    
    public boolean update(T updateObject){
        Connection con = null;
        boolean updated = false;
        
        try{
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getUpdateStatement(con,updateObject);
            if(preparedStatement.executeUpdate()>0){
                updated = true;
            }
            preparedStatement.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);                      
        }finally{
            close(con);
        }
        
        return updated;
    }
    
    public List<T> top10(){
        Connection con = null;
        ArrayList<T> listObject = new ArrayList<>();
        try{
            con = this.con.getConnection();
            Statement query = con.createStatement();
            ResultSet resultado = query.executeQuery("SELECT * " +
                                        "FROM partidas AS pa JOIN jugador AS j ON pa.fkIdJugador = j.id " +
                                        "JOIN personaje AS p ON pa.fkIdPersonaje = p.id " +
                                        "ORDER BY pa.puntaje DESC LIMIT 10");
            
            while(resultado.next()){
                T row = mapToObject(resultado);
                listObject.add(row);
            }
            
            resultado.close();
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(con);
        }
        
        return listObject;
    }
    
    public int registros(){
        Connection con = null;
        int registros = 0;
        try{
            con = this.con.getConnection();
            Statement query = con.createStatement();
            ResultSet resultado = query.executeQuery("SELECT * FROM " + infoTabla.TABLE_NAME);
            
            while(resultado.next()){
                registros++;
            }
            resultado.close();
        }catch(Exception ex){
            
        }
        return registros;
    }
    
    private void close(Connection con){
        try{
            con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se puede cerrar la conexion correctamente", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    class TableData{
        final String TABLE_NAME;
        final String PRIMARY_KEY;
        final String fields[];

        public TableData(String TABLE_NAME, String PRIMARY_KEY, String[] fields) {
            this.TABLE_NAME = TABLE_NAME;
            this.PRIMARY_KEY = PRIMARY_KEY;
            this.fields = fields;
        }
      
        
        
    }
}

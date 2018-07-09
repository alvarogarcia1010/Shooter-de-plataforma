/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;

import Modelo.Jugador.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class JugadorDao extends DaoManager<Jugador>{

    
    public JugadorDao(){
        infoTabla = new TableData(
                        "jugador",
                        "id",
                        new String[]{"nombre"});
    }
    
    @Override
    Jugador mapToObject(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Jugador find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Jugador _new) {
        PreparedStatement preparedStatement= null;
        try{
            preparedStatement = con.prepareStatement("INSERT INTO " + infoTabla.TABLE_NAME + " (" + infoTabla.fields[0]+") VALUES (?)");
            
            preparedStatement.setString(1,_new.getNombre());
        }catch(Exception ex){
            System.out.println("No se pudo insertar");
        }
        
        
        return preparedStatement;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Jugador deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Jugador updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

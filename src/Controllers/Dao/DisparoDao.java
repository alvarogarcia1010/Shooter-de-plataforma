/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;

import Modelo.Disparos.DisparosManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class DisparoDao extends DaoManager<DisparosManager> {

    public DisparoDao() {
        infoTabla = new TableData(
                    "disparo",
                    "id",
                new String[]{"nombre","damage"}
                
        );
        
    }

    @Override
    DisparosManager mapToObject(ResultSet resultado) {
        DisparosManager personaje = new DisparosManager();
        try{
            personaje.setId(resultado.getInt(infoTabla.PRIMARY_KEY));
            personaje.setNombre(resultado.getString(infoTabla.fields[0]));
            personaje.setDanio(resultado.getInt(infoTabla.fields[1]));


        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);         
        }
        return personaje;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, DisparosManager find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, DisparosManager _new) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, DisparosManager deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, DisparosManager updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

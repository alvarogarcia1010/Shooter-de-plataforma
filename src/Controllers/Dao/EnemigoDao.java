/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;

import Modelo.Enemigo.EnemigoManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class EnemigoDao extends DaoManager<EnemigoManager> {

    public EnemigoDao() {
        infoTabla = new TableData(
                    "enemigo",
                    "id",
                new String[]{"nombre","bonus","vida","posX", "posY"}
                
        );
        
    }

    @Override
    EnemigoManager mapToObject(ResultSet resultado) {
        EnemigoManager personaje = new EnemigoManager();
        try{
            personaje.setId(resultado.getInt(infoTabla.PRIMARY_KEY));
            personaje.setNombre(resultado.getString(infoTabla.fields[0]));
            personaje.setDanio(resultado.getInt(infoTabla.fields[1]));
            personaje.setVida(resultado.getInt(infoTabla.fields[2]));
            personaje.setPosicionActualX(resultado.getInt(infoTabla.fields[3]));
            personaje.setPosicionActualY(resultado.getInt(infoTabla.fields[4]));

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);         
        }
        return personaje;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, EnemigoManager find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, EnemigoManager _new) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, EnemigoManager deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, EnemigoManager updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

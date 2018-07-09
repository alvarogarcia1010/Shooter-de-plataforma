/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;

import Modelo.PlayerCharacter.CharacterManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class PersonajeDao extends DaoManager<CharacterManager> {

    public PersonajeDao() {
        infoTabla = new TableData(
                    "personaje",
                    "id",
                new String[]{"nombre","vida","posX", "posY"}
                
        );
        
    }

    @Override
    CharacterManager mapToObject(ResultSet resultado) {
        CharacterManager personaje = new CharacterManager();
        try{
            personaje.setId(resultado.getInt(infoTabla.PRIMARY_KEY));
            personaje.setNombre(resultado.getString(infoTabla.fields[0]));
            personaje.setVida(resultado.getInt(infoTabla.fields[1]));
            personaje.setPosicionActualX(resultado.getInt(infoTabla.fields[2]));
            personaje.setPosicionActualY(resultado.getInt(infoTabla.fields[3]));
            personaje.setDeltaX(0);
            personaje.setDeltaY(0);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el registro", "Error!!!", JOptionPane.ERROR_MESSAGE);         
        }
        return personaje;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, CharacterManager find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, CharacterManager _new) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, CharacterManager deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, CharacterManager updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Dao;

import Modelo.Jugador.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class PartidasDao extends DaoManager<Partida>{

    private final String insert = "INSERT INTO " + infoTabla.TABLE_NAME + " (" + infoTabla.fields[0]+", " 
                                                                               + infoTabla.fields[0]+", "
                                                                               + infoTabla.fields[0]+", "
                                                                               + infoTabla.fields[0]+") VALUES (?.?,?,?)";
    public static final String top10 = "SELECT * " +
                                        "FROM partidas AS pa JOIN jugador AS j ON pa.fkIdJugador = j.id " +
                                        "JOIN personaje AS p ON pa.fkIdPersonaje = p.id " +
                                        "ORDER BY pa.puntaje DESC LIMIT 10";
    public PartidasDao(){
        infoTabla = new TableData(
                        "partidas",
                        "id",
                        new String[]{"fkIdPartida","fkIdPersonaje", "puntaje","tiempo"});
    }
    
    @Override
    Partida mapToObject(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Partida find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Partida _new) {
        PreparedStatement preparedStatement= null;
        try{
            preparedStatement = con.prepareStatement(insert);
            
            preparedStatement.setInt(1,_new.getJugador());
            preparedStatement.setInt(2,_new.getPersonaje());
            preparedStatement.setInt(3,_new.getPuntaje());
            preparedStatement.setString(4,_new.getTiempo());
        }catch(Exception ex){
            System.out.println("No se pudo insertar");
        }
        
        
        return preparedStatement;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Partida deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Partida updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

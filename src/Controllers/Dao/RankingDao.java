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
public class RankingDao extends DaoManager<Ranking>{

    public RankingDao(){
        infoTabla = new TableData(
                        "partidas",
                        "id",
                        new String[]{"fkIdJugador","fkIdPersonaje", "puntaje","tiempo"});
    }
    
    @Override
    Ranking mapToObject(ResultSet resultado) {
        Ranking r = new Ranking();
        try{
            r.setJugador(resultado.getString("jugador"));
            r.setPersonaje(resultado.getString("personaje"));
            r.setPuntuacion(resultado.getInt("puntaje"));
            r.setTiempo(resultado.getString("tiempo"));
            
        }catch(Exception ex){
            
        }
        
        return r;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Ranking find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Ranking _new) {
        PreparedStatement preparedStatement= null;
        
        return preparedStatement;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Ranking deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Ranking updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

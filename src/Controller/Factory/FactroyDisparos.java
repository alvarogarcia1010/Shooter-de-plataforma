/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Disparos.DisparosManager;
import Modelo.Disparos.Tipo_1;
import Modelo.Enemigo.EnemigoManager;
import Modelo.PlayerCharacter.CharacterManager;

/**
 *
 * @author ryane
 */
public class FactroyDisparos implements AbstractFactory{

    @Override
    public CharacterManager getCharacter(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EnemigoManager getEnemigo(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DisparosManager getDisparos(String type) {
        switch(type){
            case "Mitch Smith":
                
        }
        return null;
        }

    }
    


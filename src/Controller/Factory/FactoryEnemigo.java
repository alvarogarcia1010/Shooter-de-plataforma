/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Disparos.DisparosManager;
import Modelo.Enemigo.EnemigoManager;
import Modelo.Enemigo.Nazi;
import Modelo.PlayerCharacter.CharacterManager;

/**
 *
 * @author ryane
 */
public class FactoryEnemigo implements AbstractFactory{

    @Override
    public CharacterManager getCharacter(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public EnemigoManager getEnemigo(String type) {
        switch(type){
            case "Mitch Smith":
                return new Nazi();
        }
        return null;
        }

    @Override
    public DisparosManager getDisparos(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    


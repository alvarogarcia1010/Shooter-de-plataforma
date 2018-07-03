/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Disparos.DisparosManager;
import Modelo.Enemigo.EnemigoManager;
import Modelo.PlayerCharacter.CharacterManager;


/**                         
 *
 * @author ryane
 */
public interface AbstractFactory {
    CharacterManager getCharacter(String type);
    EnemigoManager getEnemigo(String type);
    DisparosManager getDisparos(String type);                                                                 
}

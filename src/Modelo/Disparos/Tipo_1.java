/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Disparos;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author ryane
 */
public class Tipo_1 extends DisparosManager {

    public Tipo_1(String Nombre, int Danio, ArrayList<String> Posiciones, int PosicionActualX, int PosicionActualY, JLabel bullet) {
        super(Nombre, Danio, PosicionActualX, PosicionActualY, bullet);
    }
    
    
}

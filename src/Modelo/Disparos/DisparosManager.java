/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Disparos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author ryane
 */
public class DisparosManager extends Thread{
    protected String Nombre;
    protected int Danio;
    protected JLabel bullet;
    protected int PosicionActualX;
    protected int PosicionActualY;

    public DisparosManager(String Nombre, int Danio, int PosicionActualX, int PosicionActualY, JLabel bullet) {
        this.Nombre = Nombre;
        this.Danio = Danio;
        this.PosicionActualX = PosicionActualX;
        this.PosicionActualY = PosicionActualY;
        this.bullet = bullet;
    }

    public DisparosManager() {
    }

    public String getNombre() {
        return Nombre;
    }

    public int getDanio() {
        return Danio;
    }


    public int getPosicionActualX() {
        return PosicionActualX;
    }

    public int getPosicionActualY() {
        return PosicionActualY;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDanio(int Danio) {
        this.Danio = Danio;
    }

    public void setPosicionActualX(int PosicionActualX) {
        this.PosicionActualX = PosicionActualX;
    }

    public void setPosicionActualY(int PosicionActualY) {
        this.PosicionActualY = PosicionActualY;
    }
    
    @Override
    public void run(){
        for(int i = PosicionActualX; i<500 ; i+=10){
            System.out.println(this.Nombre + "avanza");
            this.bullet.setLocation(i, PosicionActualY);
            try{
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}

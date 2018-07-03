/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Disparos;

import java.util.ArrayList;

/**
 *
 * @author ryane
 */
public class DisparosManager {
    protected String Nombre;
    protected int Danio;
    protected ArrayList<String> Posiciones;
    protected int PosicionActualX;
    protected int PosicionActualY;

    public DisparosManager(String Nombre, int Danio, ArrayList<String> Posiciones, int PosicionActualX, int PosicionActualY) {
        this.Nombre = Nombre;
        this.Danio = Danio;
        this.Posiciones = Posiciones;
        this.PosicionActualX = PosicionActualX;
        this.PosicionActualY = PosicionActualY;
    }

    public DisparosManager() {
    }

    public String getNombre() {
        return Nombre;
    }

    public int getDanio() {
        return Danio;
    }

    public ArrayList<String> getPosiciones() {
        return Posiciones;
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

    public void setPosiciones(ArrayList<String> Posiciones) {
        this.Posiciones = Posiciones;
    }

    public void setPosicionActualX(int PosicionActualX) {
        this.PosicionActualX = PosicionActualX;
    }

    public void setPosicionActualY(int PosicionActualY) {
        this.PosicionActualY = PosicionActualY;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Enemigo;

import java.util.ArrayList;

/**
 *
 * @author ryane
 */
public class EnemigoManager extends Thread{
    protected String Nombre;
    protected int vida;
    protected int Danio;
    protected ArrayList<String> Posiciones;
    protected int PosicionActualX;
    protected int PosicionActualY;

    public EnemigoManager(String Nombre, int vida, int Danio, ArrayList<String> Posiciones, int PosicionActualX, int PosicionActualY) {
        this.Nombre = Nombre;
        this.vida = vida;
        this.Danio = Danio;
        this.Posiciones = Posiciones;
        this.PosicionActualX = PosicionActualX;
        this.PosicionActualY = PosicionActualY;
    }

    public EnemigoManager() {
    }

    public String getNombre() {
        return Nombre;
    }

    public int getVida() {
        return vida;
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

    public void setVida(int vida) {
        this.vida = vida;
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

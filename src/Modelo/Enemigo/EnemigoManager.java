/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Enemigo;

import PlataformShooter.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ryane
 */
public class EnemigoManager{
    protected int id;
    protected String Nombre;
    protected int vida;
    protected int Danio;
    protected HashMap<Type,String> img;
    protected int PosicionActualX;
    protected int PosicionActualY;

    public EnemigoManager(String Nombre, int vida, int Danio, int PosicionActualX, int PosicionActualY) {
        this.Nombre = Nombre;
        this.vida = vida;
        this.Danio = Danio;

        this.PosicionActualX = PosicionActualX;
        this.PosicionActualY = PosicionActualY;
        this.img = new HashMap<>();
    }

    public EnemigoManager() {
        this.img = new HashMap<>();
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

    public void setPosicionActualX(int PosicionActualX) {
        this.PosicionActualX = PosicionActualX;
    }

    public void setPosicionActualY(int PosicionActualY) {
        this.PosicionActualY = PosicionActualY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Type, String> getImg() {
        return img;
    }

    public void setImg(HashMap<Type, String> img) {
        this.img = img;
    }
    
    
    
    
}

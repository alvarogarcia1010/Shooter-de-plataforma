/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Disparos;

import PlataformShooter.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author ryane
 */
public class DisparosManager{
    
    protected int id;
    protected String Nombre;
    protected int Danio;
    protected HashMap<Type,String> img;

    public DisparosManager() {
        this.img = new HashMap<>();
    }

    public HashMap<Type, String> getImg() {
        return img;
    }

    public void setImg(HashMap<Type, String> img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return Nombre;
    }

    public int getDanio() {
        return Danio;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDanio(int Danio) {
        this.Danio = Danio;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Jugador;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Partida {
    protected int id;
    protected int personaje;
    protected int jugador;
    protected int puntaje;
    protected String tiempo;

    public Partida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonaje() {
        return personaje;
    }

    public void setPersonaje(int personaje) {
        this.personaje = personaje;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
}

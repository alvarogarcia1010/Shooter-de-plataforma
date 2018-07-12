/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Components;

import Controllers.Dao.JugadorDao;
import Controllers.Dao.PartidasDao;

import Modelo.Jugador.Partida;

import View.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Puntaje {

    public void initPuntajeComponents() {

        //Etiqueta nombre
        Play.nombreJugador = new JLabel(Bienvenida.usuario);
        Play.nombreJugador.setFont(Play.fuenteSecundaria);
        Play.nombreJugador.setForeground(Color.WHITE);
//        Play.labelTimer.setOpaque(true);
//        Play.labelTimer.setBackground(Color.WHITE);
        Play.nombreJugador.setHorizontalAlignment(JLabel.CENTER);
        Play.nombreJugador.setVerticalAlignment(JLabel.CENTER);
        Play.nombreJugador.setBounds(800, 10, 150, 30);

        //Etiqueta Vida
        Play.etiquetaVida = new JLabel("Vida: ");
        Play.etiquetaVida.setFont(Play.fuenteSecundaria);
        Play.etiquetaVida.setForeground(Color.WHITE);
//        Play.vida.setOpaque(true);
//        Play.vida.setBackground(Color.WHITE);
        Play.etiquetaVida.setHorizontalAlignment(JLabel.LEFT);
        Play.etiquetaVida.setVerticalAlignment(JLabel.CENTER);
        Play.etiquetaVida.setBounds(800, 40, 150, 30);

        //Vida
        Play.vida = new JLabel("100");
        Play.vida.setFont(Play.fuenteSecundaria);
        Play.vida.setForeground(Color.WHITE);
//        Play.vida.setOpaque(true);
//        Play.vida.setBackground(Color.WHITE);
        Play.vida.setHorizontalAlignment(JLabel.LEFT);
        Play.vida.setVerticalAlignment(JLabel.CENTER);
        Play.vida.setBounds(890, 40, 100, 30);

        //Etiqueta Puntaje
        Play.etiquetaPuntaje = new JLabel("Puntuacion");
        Play.etiquetaPuntaje.setFont(Play.fuenteSecundaria);
        Play.etiquetaPuntaje.setForeground(Color.WHITE);
//        Play.etiquetaPuntaje.setOpaque(true);
//        Play.etiquetaPuntaje.setBackground(Color.WHITE);
        Play.etiquetaPuntaje.setHorizontalAlignment(JLabel.CENTER);
        Play.etiquetaPuntaje.setVerticalAlignment(JLabel.CENTER);
        Play.etiquetaPuntaje.setBounds(5, 10, 200, 30);

        //Puntaje
        Play.puntaje = new JLabel("0000");
        Play.puntaje.setFont(Play.fuente);
        Play.puntaje.setForeground(Color.WHITE);
//        Play.puntaje.setOpaque(true);
//        Play.puntaje.setBackground(Color.WHITE);
        Play.puntaje.setHorizontalAlignment(JLabel.CENTER);
        Play.puntaje.setVerticalAlignment(JLabel.CENTER);
        Play.puntaje.setBounds(5, 40, 200, 30);
    }

    public void sumarPuntos() {
        int temp = Integer.parseInt(Play.puntaje.getText());
        if (!Play.gameOver) {
            temp += 5;
            Play.puntaje.setText("" + temp);
        }
    }

    public void restarVida() {
        String msj = "Juego Terminado \nPuntuación: " + Play.puntaje.getText() + "\nTiempo: " + Play.labelTimer.getText();
        try {
            int temp = Integer.parseInt(Play.vida.getText());
            verificarVida(temp, msj);

            if (temp >= 1) {
                temp -= 5;
                Play.vida.setText("" + temp);
            }
            if (temp < 1) {
                Play.cronometro.initTimer();
            }
            verificarVida(temp, msj);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msj);
        }
    }

    public void verificarVida(int temp, String msj) {
        if (temp < 1) {
            
            Play.c.imgMorir();
            JOptionPane.showMessageDialog(null, msj);
            PartidasDao partidaDao = new PartidasDao();
            Partida partida = new Partida();
            JugadorDao jugador = new JugadorDao();


            partida.setJugador(jugador.findByNombre(Bienvenida.jugadorActual).get(0).getId());
            partida.setPersonaje(Play.personaje);
            partida.setPuntaje(Integer.parseInt(Play.puntaje.getText()));
            partida.setTiempo(Play.labelTimer.getText());

            partidaDao.insert(partida);

        }
    }
}

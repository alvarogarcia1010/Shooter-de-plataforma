/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Components;

import View.Play;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Puntaje {
    
    
    public void initPuntajeComponents(){
        //Etiqueta nombre
        Play.nombreJugador = new JLabel("Alvarito");
        Play.nombreJugador.setFont(Play.fuente);
        Play.nombreJugador.setForeground(Color.BLACK);
//        Play.labelTimer.setOpaque(true);
//        Play.labelTimer.setBackground(Color.WHITE);
        Play.nombreJugador.setHorizontalAlignment(JLabel.LEFT);
        Play.nombreJugador.setVerticalAlignment(JLabel.CENTER);
        Play.nombreJugador.setBounds(25, 600, 250, 50);
        //Etiqueta Puntaje
        Play.etiquetaPuntaje = new JLabel("Puntuacion");
        Play.etiquetaPuntaje.setFont(Play.fuente);
        Play.etiquetaPuntaje.setForeground(Color.BLACK);
//        Play.etiquetaPuntaje.setOpaque(true);
//        Play.etiquetaPuntaje.setBackground(Color.WHITE);
        Play.etiquetaPuntaje.setHorizontalAlignment(JLabel.CENTER);
        Play.etiquetaPuntaje.setVerticalAlignment(JLabel.CENTER);
        Play.etiquetaPuntaje.setBounds(10, 10, 250, 50);
        
        //Puntaje
        Play.puntaje = new JLabel("0000");
        Play.puntaje.setFont(Play.fuente);
        Play.puntaje.setForeground(Color.BLACK);
//        Play.puntaje.setOpaque(true);
//        Play.puntaje.setBackground(Color.WHITE);
        Play.puntaje.setHorizontalAlignment(JLabel.CENTER);
        Play.puntaje.setVerticalAlignment(JLabel.CENTER);
        Play.puntaje.setBounds(10, 60, 250, 50);
    }
}

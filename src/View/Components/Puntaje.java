/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Components;

import View.Play;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Puntaje {
    
    
    public void initPuntajeComponents(){
        //Etiqueta nombre
        Play.nombreJugador = new JLabel("Alvarito");
        Play.nombreJugador.setFont(Play.fuenteSecundaria);
        Play.nombreJugador.setForeground(Color.BLACK);
//        Play.labelTimer.setOpaque(true);
//        Play.labelTimer.setBackground(Color.WHITE);
        Play.nombreJugador.setHorizontalAlignment(JLabel.LEFT);
        Play.nombreJugador.setVerticalAlignment(JLabel.CENTER);
        Play.nombreJugador.setBounds(25, 600, 250, 50);
        
        //Vida
        Play.vida = new JLabel("100");
        Play.vida.setFont(Play.fuenteSecundaria);
        Play.vida.setForeground(Color.BLACK);
//        Play.vida.setOpaque(true);
//        Play.vida.setBackground(Color.WHITE);
        Play.vida.setHorizontalAlignment(JLabel.LEFT);
        Play.vida.setVerticalAlignment(JLabel.CENTER);
        Play.vida.setBounds(300, 600, 250, 50);
        
        //Etiqueta Puntaje
        Play.etiquetaPuntaje = new JLabel("Puntuacion");
        Play.etiquetaPuntaje.setFont(Play.fuenteSecundaria);
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
    
    public void sumarPuntos(){
        int temp = Integer.parseInt(Play.puntaje.getText());
        if(!Play.gameOver){
            temp+=10;
            Play.puntaje.setText(""+ temp);
        }
    }
    
    public void restarVida(){
        String msj = "Juego Terminado";
        try{
            int temp = Integer.parseInt(Play.vida.getText());
            if(temp<1){
                JOptionPane.showMessageDialog(null,msj);

            }else{
                temp-=10;
                Play.vida.setText(""+ temp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,msj);
        }
    }
}

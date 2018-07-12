/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Components;

import Controllers.Temporizador;
import View.Play;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class Tiempo{
    
    public static int hora = 0, minuto = 0, segundo = 0;
    public static boolean iniciaTiempo = true, corriendo = false;
       
    private void start(){
        if(iniciaTiempo){
            System.out.println("Start");
            Temporizador t = new Temporizador(Play.labelTimer);
            t.start();
        }
    }
    
    public void initlabelTimer(){

        //Etiqueta Cronometro
        Play.labelTimer = new JLabel("00:00:00");
        Play.labelTimer.setFont(Play.fuente);
        Play.labelTimer.setForeground(Color.WHITE);
//        Play.labelTimer.setOpaque(true);
//        Play.labelTimer.setBackground(Color.WHITE);
        Play.labelTimer.setHorizontalAlignment(JLabel.CENTER);
        Play.labelTimer.setVerticalAlignment(JLabel.CENTER);
        Play.labelTimer.setBounds(425, 10, 150, 50);
        
       
        
//       // Boton Pausa
//        Play.btnPause = new JButton("SUMAR PUNTAJE");
//        Play.btnPause.setFont(Play.fuente);
//        Play.btnPause.setForeground(Color.BLUE);
//        Play.btnPause.setBounds(820, 50,150,30);
    }
    
    public void initTimer(){
        if(!corriendo){
            iniciaTiempo = true;
            corriendo = true;
            start();
        }else{
            iniciaTiempo = false;
            corriendo = false;
        }
    }
}

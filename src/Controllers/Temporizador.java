/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import View.Components.Tiempo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author garcia
 */
public class Temporizador extends Thread{
    JLabel etiquetaTiempo;
    int x = 0;
    
    public Temporizador(JLabel timer) {
        etiquetaTiempo = timer;
    }
    
    @Override
    public void run(){
        try{
            while(Tiempo.iniciaTiempo){
                Thread.sleep(1000);
                ejecutarHilo(x);
                x++;
            }
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Algunos compomentes del juego dejaron de funcionar \n ¡Por favor reinicie la aplicación!", "Error al inicializar componentes", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void ejecutarHilo(int segundo){
        String tiempoActual, txtMin = "", txtSeg = "", txtHora="";
        Tiempo.segundo++;
        
        if(Tiempo.segundo>59){
            Tiempo.segundo = 0;
            Tiempo.minuto++;
            
            if(Tiempo.minuto>59){
                Tiempo.minuto = 0;
                Tiempo.hora++;
            }
            
        }
        
        if(Tiempo.segundo<10){
            txtSeg = "0"+Tiempo.segundo;
        }else{
            txtSeg ="" + Tiempo.segundo;
        }

        if(Tiempo.minuto<10){
            txtMin = "0"+Tiempo.minuto;
        }else{
            txtMin ="" + Tiempo.minuto;
        }

        if(Tiempo.hora<10){
            txtHora = "0"+Tiempo.hora;
        }else{
            txtHora ="" + Tiempo.hora;
        }
        
        tiempoActual = txtHora+":"+txtMin+":"+txtSeg;
        etiquetaTiempo.setText(tiempoActual);
    }
}


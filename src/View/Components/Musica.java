/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Components;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Musica {
    public static AudioStream audio1;
    
        
    public void musica(){
    
        try{
            String sonido1 = "./src/Music/Music.wav";
            InputStream in = new FileInputStream(sonido1);
            audio1 = new AudioStream(in);
            AudioPlayer.player.start(audio1);
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*public  void stop(){
        try{
            AudioPlayer.player.stop(audio1);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }*/
    
    
}

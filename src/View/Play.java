
package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Play extends JFrame{

      public static int height = 700;
      public static int width = 1000;
      private JButton encender, apagar, inv;
      public AudioStream audio1;
		
 
      
    public Play(){
        super("Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
        musica();
        stop();
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Play p = new Play();
                p.setVisible(true);

            }
            
        });

    }  
    
    public void initialComponent(){
        encender = new JButton(new ImageIcon("encendido.png"));
        encender.setBounds(820, 20, 50, 50);
        apagar = new JButton(new ImageIcon("apagar.png"));
        apagar.setBounds(880,20,50,50);
        inv = new JButton("Inventario armas");
        inv.setBounds(50, 20, 100, 50);
        
        Container container = getContentPane();
        container.add(encender);
        container.add(apagar);
        container.add(inv);
        
        
        encender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                musica();
            }

        });
        
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                stop();
            }

        });
        
                  
        inv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Inventario i = new Inventario();
                i.setVisible(true);
                //dispose();  
            }

        });
        
        
        
        
    }
    
    private void musica(){
    
        try{
            String sonido1 = "Music\\\\\\\\Solarstone & Clare Stagg - Jewel (Pure Mix) [Music Video] [HD].wav";
            InputStream in = new FileInputStream(sonido1);
            audio1 = new AudioStream(in);
            AudioPlayer.player.start(audio1);
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void stop(){
        try{
            AudioPlayer.player.stop(audio1);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
   
}

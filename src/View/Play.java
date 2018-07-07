package View;

import View.Components.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Play extends JFrame {

    public static Font fuente = new Font("Comic Sans MS", 3, 30);
    public static int height = 700;
    public static int width = 1000;
    public static JButton encender, apagar, inventario;
    //public AudioStream audio1;

    //Controladores de los componentes
    public static Tiempo cronometro = new Tiempo();
    public static Puntaje puntuacion = new Puntaje();

    //Componentes de la ventana
    public static JLabel etiquetaPuntaje, nombreJugador, puntaje;
    public static JLabel labelTimer;
    public static JButton btnPause;

    public Play() {
        super("Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        initialComponent();
        initGame();

        eventos();
        setSize(width, height);
        setLocationRelativeTo(null);
        //musica();
        //stop();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Play p = new Play();
                p.setVisible(true);

            }

        });

    }

    public void initialComponent() {
//        encender = new JButton(new ImageIcon("encendido.png"));
//        encender.setBounds(820, 500, 50, 50);
//        apagar = new JButton(new ImageIcon("apagar.png"));
//        apagar.setBounds(880,500,50,50);

        this.cronometro.initlabelTimer();
        this.puntuacion.initPuntajeComponents();

        Container container = getContentPane();
//        container.add(encender);
//        container.add(apagar);
        container.add(this.inventario);
        container.add(this.labelTimer);
        container.add(this.etiquetaPuntaje);
        container.add(this.nombreJugador);
        container.add(this.puntaje);
//        container.add(this.btnPause);

    }

    public void initGame() {
        cronometro.initTimer();
    }

    public void eventos() {

//        btnPause.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                
//            }
//        });
//        encender.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                //musica();
//            }
//
//        });
//        
//        apagar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                //stop();
//            }
//
//        });
//        
        inventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Inventario i = new Inventario();
                i.setVisible(true);

            }

        });
    }
    /*private void musica(){
    
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
    }*/

}

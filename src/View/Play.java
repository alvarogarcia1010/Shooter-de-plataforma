package View;

import Modelo.PlayerCharacter.CharacterManager;
import View.Components.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import View.Game.Character;
import View.Game.Enemy;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Play extends JFrame {
    public int x;
    public static Font fuente = new Font("Comic Sans MS", 3, 30);
    public static Font fuenteSecundaria = new Font("Comic Sans MS", 3, 20);
    public static int height = 837; //700
    public static int width = 1000; //1000

    public static Character c;

    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static Enemy e,e1;
    public static Musica m = new Musica();


    public static JButton encender, apagar, inventario;

    //Controladores de los componentes
    public static Tiempo cronometro = new Tiempo();
    public static Puntaje puntuacion = new Puntaje();
    public static boolean gameOver = false;

    //Componentes de la ventana
    public static JLabel etiquetaPuntaje, nombreJugador, puntaje, etiquetaVida,vida;
    public static JLabel labelTimer;
    public static JButton btnPause;


    public Play() {
        super("Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialComponent();
        initGame();
        eventos();
        setSize(width, height);
        setLocationRelativeTo(null);
        ScrollingBackground back = new ScrollingBackground();
        back.setFocusable(true);
        add(back);
        
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //m.musica();
                Play p = new Play();
                p.setVisible(true);
            }

        });

    }

    public void initialComponent() {
        c = new Character();
        e = new Enemy();
        e1 = new Enemy();
        enemies.add(e);
        enemies.add(e1);
        this.cronometro.initlabelTimer();
        this.puntuacion.initPuntajeComponents();
        Container container = getContentPane();
        container.add(this.inventario);
        container.add(this.labelTimer);
        container.add(this.etiquetaPuntaje);
        container.add(this.nombreJugador);
        container.add(this.puntaje);
        container.add(this.vida);
        container.add(this.etiquetaVida);
        container.add(this.btnPause);
        container.add(c);
        container.add(e);
        container.add(e1);
    }

    public void initGame() {
        cronometro.initTimer();
    }

    public void eventos() {

        btnPause.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
//                puntuacion.sumarPuntos();
                  puntuacion.restarVida();
            }
        });
        
        inventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Inventario i = new Inventario();
                i.setVisible(true);

            }

        });
    }
    
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    
    public class ScrollingBackground extends JPanel implements Runnable{
            private Background backOne;
            private Background backTwo;
            private BufferedImage back;
            
            public ScrollingBackground() {
                backOne = new Background();
                backTwo = new Background(backOne.getImageWidth(), 0);
                new Thread(this).start();
                setOpaque(false);
                
            }

            @Override
            public void run() {

                try {
                    while(true) {
                        Thread.currentThread().sleep(15);
                        repaint();
                        //System.out.println("backOne X: "+backOne.getX()+" i: "+i);
                    }
                }
                catch (Exception e) {}
            }

            @Override
            public void update(Graphics window) {
                paint(window);
            }

            @Override
            public void paint(Graphics window) {
                Graphics2D twoD = (Graphics2D)window;
                if (back == null)
                    back = (BufferedImage)(createImage(getWidth(), getHeight()));
                Graphics buffer = back.createGraphics();
                backOne.draw(buffer);backTwo.draw(buffer);
                
                twoD.drawImage(back, null, 0, 0);
                c.paintComponent(window);
                e.paintComponent(window);
                e1.paintComponent(window);   
            }
    }
}

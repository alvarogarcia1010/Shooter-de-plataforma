/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Dao.JugadorDao;
import Modelo.Jugador.Jugador;
import static View.Play.height;
import static View.Play.width;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Alcoleas <your.name at your.org>
 */
public class Bienvenida extends JFrame{
      public static int height = 700;
      public static int width = 1000;
      public static String usuario = "Alvaro";
      public static Jugador jugadorActual;
      private JButton bienvenida;
      private JButton about;
      private JButton rank;
      PanelBienvenido Fondo = new PanelBienvenido();
      
      
      public Bienvenida(){
        super("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
        add(Fondo);
        setVisible(true);
      }
      
      
      public void initialComponent(){
          //Bienvenida b = new Bienvenida();

          bienvenida = new JButton(new ImageIcon("./src/img/inicio.png"));
          bienvenida.setBounds(750,300,186,60);   
          about = new JButton(new ImageIcon("about.png"));
          about.setBounds(800, 400, 135, 53);
          rank = new JButton(new ImageIcon("top.png"));
          rank.setBounds(750, 200, 187, 60);
          
          
          
          

          Container container = getContentPane();
          container.add(bienvenida);
          container.add(about);
          container.add(rank);
          
          bienvenida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                usuario();
                Personajes p = new Personajes();
                p.setVisible(true);
                dispose();  
            }
            });
          
          about.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                About p = new About();
                p.setVisible(true);
            }
          });
          
          rank.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ae) {
                Ranking p = new Ranking();
                p.setVisible(true);
            }
          });
          
      }
      
     
       public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Bienvenida b = new Bienvenida();
                b.setVisible(true);

            }
            
        });

    }
       
       public void usuario(){
           usuario = JOptionPane.showInputDialog(null, "Usuario");
           JugadorDao jugadorDao= new JugadorDao();
           jugadorActual = new Jugador();
           jugadorActual.setNombre(usuario);
           jugadorDao.insert(jugadorActual);
       }
       
    private class PanelBienvenido extends JPanel{
 
            @Override
            public void paint(Graphics g){
                Dimension tamanio = getSize();
                ImageIcon image = new ImageIcon(getClass().getResource("/View/Components/b_1.png"));
                g.drawImage(image.getImage(), 0, 0, tamanio.width, tamanio.height, null);
                setOpaque(false);
                super.paint(g);
            }
    }
    
    

}

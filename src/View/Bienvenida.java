/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Play.height;
import static View.Play.width;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Alcoleas <your.name at your.org>
 */
public class Bienvenida extends JFrame{
      public static int height = 700;
      public static int width = 1000;
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
          bienvenida = new JButton(new ImageIcon("s2.png"));
          bienvenida.setBounds(800,300,120,50);   
          about = new JButton(new ImageIcon("about.png"));
          about.setBounds(800, 400, 120, 50);
          rank = new JButton(new ImageIcon("rank.png"));
          rank.setBounds(800, 200, 120, 50);
          
          
          
          
          Container container = getContentPane();
          container.add(bienvenida);
          container.add(about);
          container.add(rank);
          
          bienvenida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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

}

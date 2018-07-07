/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Bienvenida.height;
import static View.Bienvenida.width;
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
public class Personajes extends JFrame{
    
      public static int height = 700;
      public static int width = 900;
      public JButton p1,p2,p3;
      PanelPersonaje fondo = new PanelPersonaje();
      
      public Personajes(){
        super("Personajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
        add(fondo);
        setVisible(true);
        
      }
      
      public void initialComponent(){
          p1 = new JButton(new ImageIcon("p1.png"));
          p2 = new JButton(new ImageIcon("p2.png"));
          p3 = new JButton(new ImageIcon("p3.png"));
          
          p1.setBounds(100, 80, 210, 505);
          p2.setBounds(350, 80, 210, 505);
          p3.setBounds(600, 80, 210, 505);
          
          Container container = getContentPane();
          container.add(p1);
          container.add(p2);
          container.add(p3);
          
                    
        p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play p = new Play();
                p.setVisible(true);
                dispose();  
            }

        });
          
                    
        p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play p = new Play();
                p.setVisible(true);
                dispose();  
            }

        });
          
                    
        p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play p = new Play();
                p.setVisible(true);
                dispose();  
            }

        });
      }
         
       public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Personajes p = new Personajes();
                p.setVisible(true);

            }
            
        });

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Bienvenida.height;
import static View.Bienvenida.width;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Alcoleas <your.name at your.org>
 */
public class Personajes extends JFrame{
    
      public static int height = 700;
      public static int width = 900;
      public JButton p1,p2,p3;
      public PanelPersonaje fondo = new PanelPersonaje();
      
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
          p1 = new JButton();
          p2 = new JButton();
          p3 = new JButton();
          
          p1.setBounds(60, 80, 210, 505);
          p1.setOpaque(false);
          p1.setContentAreaFilled(false);
          p1.setBorderPainted(false);
          
          p2.setBounds(342, 80, 210, 505);
          p2.setOpaque(false);
          p2.setContentAreaFilled(false);
          p2.setBorderPainted(false);
          
          p3.setBounds(632, 80, 210, 505);
          p3.setOpaque(false);
          p3.setContentAreaFilled(false);
          p3.setBorderPainted(false);
          
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
    
    private class PanelPersonaje extends JPanel{
        @Override
        public void paint(Graphics g){
            Dimension tamanio = getSize();
            ImageIcon image = new ImageIcon(getClass().getResource("/View/Components/b_2.png"));
            g.drawImage(image.getImage(), 0, 0, tamanio.width, tamanio.height, null);
            setOpaque(false);
            super.paint(g);
        }
    }
    
}

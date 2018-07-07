/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Play.height;
import static View.Play.width;
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
      
      
      public Bienvenida(){
        super("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
      }
      
      
      public void initialComponent(){
          //Bienvenida b = new Bienvenida();
          bienvenida = new JButton(new ImageIcon("./src/img/welcome.png"));
          bienvenida.setBounds(400,300,200, 125);   
          Container container = getContentPane();
          container.add(bienvenida);
          
          bienvenida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Personajes p = new Personajes();
                p.setVisible(true);
                dispose();  
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

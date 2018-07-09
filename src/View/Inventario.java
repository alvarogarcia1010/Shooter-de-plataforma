/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Personajes.height;
import static View.Personajes.width;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author Daniel Alcoleas <your.name at your.org>
 */
public class Inventario extends JFrame{
    public static int height = 500;
    public static int width = 500;
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    
    public Inventario(){
        super("Inventario Armas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
    }
    
    public void initialComponent(){
        b1 = new JButton("Bala Comun");
        b1.setBounds(150,50,120,50);
        
        b2 = new JButton("Bala Pesada");
        b2.setBounds(150,150,120,50); 
        
        b3 = new JButton("Misil");
        b3.setBounds(150,250,120,50);   
        
         Container container = getContentPane();
         container.add(b1);
         container.add(b2);
         container.add(b3);
         
         b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play.x = 1;
            }
          });
         
         b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play.x = 2;
            }
          });
         
         b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Play.x = 3;
            }
          });
    }
}

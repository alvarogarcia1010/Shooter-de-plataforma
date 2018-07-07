/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ryane
 */
public class About extends JFrame{
    
    public static int height = 620;
    public static int width = 1050;
    PanelAbout fondo = new PanelAbout();
    private JButton regresar;
    
    public About(){
        super("About");
        initialcomponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        add(fondo);
        setVisible(true);
      }
    
    public void initialcomponents(){
        regresar = new JButton(new ImageIcon("regresar.png"));
        regresar.setBounds(20, 5, 50, 50);
        
        Container container = getContentPane();
        container.add(regresar);
        
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Bienvenida b = new Bienvenida();
                b.setVisible(false);
                dispose();  
            }
        });
    }
      
}

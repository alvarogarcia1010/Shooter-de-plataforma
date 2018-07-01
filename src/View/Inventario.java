/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Personajes.height;
import static View.Personajes.width;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Alcoleas <your.name at your.org>
 */
public class Inventario extends JFrame{
    public static int height = 500;
    public static int width = 500;
    
    public Inventario(){
        super("Inventario Armas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initialComponent();
        setSize(width,height);
        setLocationRelativeTo(null);
    }
    
    public void initialComponent(){
        
    }
}

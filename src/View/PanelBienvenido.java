/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ryane
 */
public class PanelBienvenido extends JPanel{
 
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon image = new ImageIcon(getClass().getResource("/View/Components/b_1.png"));
        g.drawImage(image.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paint(g);
    }
}

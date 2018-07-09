/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ryane
 */
public class Background {
    private BufferedImage image;
 
    private int x;
    private int y;
 
    public Background() {
        this(0,0);
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getImageWidth() {
        return image.getWidth();
    }
  
    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File("nivel2.png"));
        }
        catch (Exception e) { System.out.println(e); }
 
    }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
<<<<<<< HEAD
        this.x -= 5;
        if (this.x <= -1 * image.getWidth()) {
            this.x = this.x + image.getWidth() * 2;
            }   
=======
        this.x -= 1;      
>>>>>>> c5a8405ac40d1019a09206425557894131ecdae0
        }
}

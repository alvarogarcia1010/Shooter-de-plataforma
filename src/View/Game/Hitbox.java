/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Game;

import java.awt.Rectangle;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Hitbox {
    private int x, y, width, height;
    
    public Hitbox(int startX, int startY, int width, int height){
        this.x = startX;
        this.y = startY;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle bounds(){
        return (new Rectangle(x, y, width, height));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Disparos;

/**
 *
 * @author daniel
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class Disparo extends JFrame implements KeyListener, Runnable{
    
    int frameW = 1000, frameM = 700;
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image right = toolkit.getImage("./src/img/right.gif");
    Image left = toolkit.getImage("./src/img/left.gif");
    Image bg = toolkit.getImage("./src/img/bg.jpg");
    Image bullet = toolkit.getImage("./src/img/bullet.gif");
    Image image = right;
    int rightX = 200, rightY = 100;
    int bulletNo = 0;
    int bulletX[] = new int[10];
    int bulletY[] = new int[10];
    boolean isShot[] = new boolean[10];
    
    Thread thread = new Thread(this);

    
    public Disparo(){
        setBounds(50,50, frameW,frameM);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
        
        for(int i = 0; i<bulletX.length ;i++){
            isShot[i] = false;
            bulletX[i] = rightX + 20;
            bulletY[i] = rightY + 10;
        }
        thread.start();
    }

    public static void main(String[] args) {
        new Disparo();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_X){
            isShot[bulletNo] = true;
            bulletX[bulletNo] = rightX + 65;
            bulletY[bulletNo] = rightY + 40;
            ++bulletNo;
            if(bulletNo>bulletX.length-1) 
                bulletNo=0;
        }
        
        if (code == KeyEvent.VK_UP){
            rightY-=30;
            bulletY[bulletNo] = rightY;
        }
        
        if (code == KeyEvent.VK_DOWN){
            rightY+=30;
            bulletY[bulletNo] = rightY;
        }
        
        if (code == KeyEvent.VK_RIGHT){
            rightX+=30;
            bulletX[bulletNo] = rightX;
            image = right;
        }
        
        if (code == KeyEvent.VK_LEFT){
            rightX-=30;
            bulletX[bulletNo] = rightX;
            image = left;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(bg, 0, 0, null);
        
        for (int i = 0; i<bulletX.length; i++){
            if(isShot[i]){
                g.drawImage(bullet, bulletX[i], bulletY[i], this);
            }
        }
        
        g.drawImage(image, rightX, rightY, this);
    }

    @Override
    public void run() {
        while(true){
            for(int i = 0; i<bulletX.length ;i++){
                if(isShot[i]) 
                    bulletX[i]+=20;
                
                if(bulletX[i]> 1000){
                    isShot[i] = false;
                    bulletX[i] = rightX + 50;
                    bulletY[i] = rightY + 10;
                }
            }
            try{
                Thread.sleep(20);
            } catch (InterruptedException ex) {
               repaint();            
            }
        }
    }
    
}

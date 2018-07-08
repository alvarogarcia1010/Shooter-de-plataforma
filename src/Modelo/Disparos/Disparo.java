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
import PlataformShooter.Type;
import View.Game.Character;
import View.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author daniel
 */
public class Disparo extends JPanel implements Runnable, ImageObserver{
    
    //int frameW = 1000, frameM = 700;
    
    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
    //Image right = toolkit.getImage("./src/img/right.gif");
    //Image left = toolkit.getImage("./src/img/left.gif");
    //Image bg = toolkit.getImage("./src/img/bg.jpg");
    public static Image bullet = toolkit.getImage("./src/img/bullet.gif");
    public static Image bullet1 = toolkit.getImage("./src/img/bullet1.gif");
    public static Image image = bullet;
    //int rightX = 200, rightY = 100;
    int rightX , rightY;
    public static int bulletNo = 0;
    public static int bulletX[] = new int[10];
    public static int bulletY[] = new int[10];
    public static boolean isShot[] = new boolean[10];
    
    Thread thread = new Thread(this);

    
    public Disparo(Character c){
        this.rightX = c.posX;
        this.rightY = c.posY;
        //setBounds(50,50, Play.WIDTH,Play.HEIGHT);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
        //addKeyListener(this);
        
        /*for(int i = 0; i<bulletX.length ;i++){
            isShot[i] = false;
            bulletX[i] = rightX + 20;
            bulletY[i] = rightY + 10;
            System.out.println("hola");
        }*/
        thread.start();
    }

    /*public static void main(String[] args) {
        new Disparo();
    }*/

    /*@Override
    public void keyTyped(KeyEvent ke) {
        
    }*/

    /*@Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_X){
            isShot[bulletNo] = true;
            bulletX[bulletNo] = rightX + 65;
            bulletY[bulletNo] = rightY + 40;
            ++bulletNo;
            //System.out.println(":" + bulletNo);
            //System.out.println(": "+ bulletX.length);
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
    }*/

    /*@Override
    public void keyReleased(KeyEvent ke) {
    }*/
    
    /*@Override
    public void paint(Graphics g){
        //g.drawImage(bg, 0, 0, null);
        
        for (int i = 0; i<bulletX.length; i++){
            if(isShot[i] && imgActual==imagenes.get(Type.DERECHA)){
                g.drawImage(bullet, bulletX[i], bulletY[i], this);
                
            }
            
            if (isShot[i] && imgActual==imagenes.get(Type.IZQUIERDA)){
                g.drawImage(bullet1, bulletX[i], bulletY[i], this);
            }

        }
        
        //g.drawImage(image, rightX, rightY, this);
    }

    @Override
    public void run() {
        while(true){
            for(int i = 0; i<bulletX.length ;i++){
                if(isShot[i] && imgActual==imagenes.get(Type.DERECHA)) 
                    bulletX[i]+=20;
                

                if(isShot[i] && imgActual==imagenes.get(Type.IZQUIERDA)) 
                    bulletX[i]-=20;
                
                
                if(bulletX[i]> 1000 || bulletX[i]< 0){
                    isShot[i] = false;
                    bulletX[i] = rightX + 20;
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
    
   

    @Override
    public boolean imageUpdate(Image image, int i, int i1, int i2, int i3, int i4) {
        return true;    
    }*/

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Game;

import Modelo.Disparos.Disparo;
import Modelo.PlayerCharacter.CharacterManager;
import PlataformShooter.Type;
import View.Game.Enemy.Actions;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.Image.SCALE_AREA_AVERAGING;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class Enemy extends JPanel implements ActionListener, Runnable{
    public Timer t = new Timer(50,this);
    public CharacterManager personaje;
    public Actions status;
    public Toolkit toolkit;
    public HashMap<Type, Image> imagenes;
    public Image imgActual;
    public int posX =1000,posY=350;
    public int deltaX=0,deltaY=0;
    public long updatedAt = 0;
    private static final List<Actions> VALUES = Collections.unmodifiableList(Arrays.asList(Actions.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public int bulletNo = 0;
    public int bulletX[] = new int[10];
    public int bulletY[] = new int[10];
    public  boolean isShot[] = new boolean[10];
    
    Thread thread = new Thread(this);
    
    public static Actions randomAction() {
        if(RANDOM.nextInt(100) <= 50){
            return VALUES.get(0);
        }
        else if(RANDOM.nextInt(100) <= 50){
            return VALUES.get(2);
        }
        else if(RANDOM.nextInt(100) <= 20){
            return VALUES.get(3);
        }       
        return VALUES.get(1);
            //return VALUES.get(RANDOM.nextInt(SIZE));
    }


    
    public Enemy(){
        t.start();      
        setFocusable(true); 
        this.personaje = new CharacterManager();
        
        this.personaje.addImg(Type.IZQUIERDA, "./src/img/Marco/MarcoLeft.png");
        this.personaje.addImg(Type.CORRE_RIGHT, "./src/img/Marco/MarcoRuning.gif");
        this.personaje.addImg(Type.CORRE_LEFT, "./src/img/Marco/MarcoRuningL.gif");
        this.personaje.addImg(Type.DISPARA_R, "./src/img/Marco/MarcoShoot.png");
        this.personaje.addImg(Type.DISPARA_L, "./src/img/Marco/MarcoShootL.png");
        this.personaje.addImg(Type.BALADER, "./src/img/bullet.gif");
        this.personaje.addImg(Type.BALAIZQ, "./src/img/bullet1.gif");
        this.personaje.addImg(Type.MORIR, "./src/img/Boos/Boss4.gif");
        this.toolkit = Toolkit.getDefaultToolkit();
        this.imagenes = new HashMap<>();
        this.imagenes.put(Type.IZQUIERDA, toolkit.getImage(personaje.getImg().get(Type.IZQUIERDA)));
        this.imagenes.put(Type.CORRE_RIGHT, toolkit.getImage(personaje.getImg().get(Type.CORRE_RIGHT)));
        this.imagenes.put(Type.CORRE_LEFT, toolkit.getImage(personaje.getImg().get(Type.CORRE_LEFT)));
        this.imagenes.put(Type.DISPARA_R, toolkit.getImage(personaje.getImg().get(Type.DISPARA_R)));
        this.imagenes.put(Type.DISPARA_L, toolkit.getImage(personaje.getImg().get(Type.DISPARA_L)));
        this.imagenes.put(Type.BALADER, toolkit.getImage(personaje.getImg().get(Type.BALADER)));
        this.imagenes.put(Type.BALAIZQ, toolkit.getImage(personaje.getImg().get(Type.BALAIZQ)));
        this.imagenes.put(Type.MORIR, toolkit.getImage(personaje.getImg().get(Type.MORIR)));


        this.deltaX = personaje.getDeltaX();
        this.deltaY = personaje.getDeltaY();
        this.imgActual = this.imagenes.get(Type.MORIR);
        setStatus(status.WALK);
        
        for (int i = 0; i<bulletX.length; i++){
            bulletX[i] = posX - 30;
            bulletY[i] = posY + 60;         
        }
        
        thread.start();
        //updatedAt = System.currentTimeMillis();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i<bulletX.length; i++){
            if(isShot[i] && imgActual== imagenes.get(Type.DERECHA)){
                g.drawImage(imagenes.get(Type.BALADER), bulletX[i], bulletY[i], this);    
            }
           
            if (isShot[i] && imgActual==imagenes.get(Type.MORIR)){
                g.drawImage(imagenes.get(Type.BALAIZQ), bulletX[i], bulletY[i], this);
            }
        }
        g.drawImage(this.imgActual, this.posX,this.posY,this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
       // if(System.currentTimeMillis() - updatedAt > 3000){           
            switch(status){
                case WALK:
                    this.imgActual = this.imagenes.get(Type.MORIR);
                    posX = posX - 1;
                    System.out.println("Camina");
                    //updatedAt = System.currentTimeMillis();
                    break;
                case STOP:
                    this.imgActual = this.imagenes.get(Type.MORIR);
                    System.out.println("Stop");
                    status = VALUES.get(2);
                    //updatedAt = System.currentTimeMillis();
                    break;
                case SHOOT:
                    shoot();
                    System.out.println("Shoot");
                    //updatedAt = System.currentTimeMillis();
                    break;
                case JUMP:
                    System.out.println("Jump");
                    status = VALUES.get(2);
                    //updatedAt = System.currentTimeMillis();
                    break;
            }
            if(System.currentTimeMillis() - updatedAt > 3000){
                status = randomAction();
                updatedAt = System.currentTimeMillis();
            }
            //status = randomAction();
           // updatedAt = System.currentTimeMillis();
        //}
    }
    
    public void setPosX(int posX){
        this.posX = posX;
    }
    
    public enum Actions{
        WALK, STOP, SHOOT, JUMP;
    }
    
    public void setStatus(Actions action){
        this.status = action;
    }
    
    public Actions getStatus(){
        return status;
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame(); 
        Enemy p = new Enemy();
        p.setPosX(900);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setSize(1000,700); 
        f.setVisible(true); 
    }
    
    public void shoot(){
        isShot[bulletNo] = true;
        bulletX[bulletNo] = posX + 65;
        bulletY[bulletNo] = posY + 40;
        ++bulletNo;
        //System.out.println(":" + bulletNo);
        //System.out.println(": "+ bulletX.length);
        if(bulletNo>bulletX.length-1) 
        bulletNo=0;
    }
    
    @Override
    public void run() {
        while(true){
            for(int i = 0; i<bulletX.length ;i++){
                if(isShot[i] && imgActual==imagenes.get(Type.DERECHA)) 
                    bulletX[i]+=20;
                

                if(isShot[i] && imgActual==imagenes.get(Type.MORIR)) 
                    bulletX[i]-=20;
                
                
                if(bulletX[i]> 1000 || bulletX[i]< 0){
                    isShot[i] = false;
                    bulletX[i] = posX + 20;
                    bulletY[i] = posY + 10;
                    
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

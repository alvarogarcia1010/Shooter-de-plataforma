/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Game;

import Modelo.PlayerCharacter.CharacterManager;
import PlataformShooter.Type;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.Image.SCALE_AREA_AVERAGING;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class Character extends JPanel implements ActionListener, KeyListener {
    public Timer t = new Timer(50,this);
    public CharacterManager personaje;
    public Toolkit toolkit;
    public HashMap<Type, Image> imagenes;
    public Image imgActual;
    public int posX =30,posY=350;
    public int deltaX=0,deltaY=0;
    
    public Character(){
        t.start();      
        addKeyListener(this); 
        setFocusable(true); 
        setFocusTraversalKeysEnabled(false); 
        this.personaje = new CharacterManager();
        this.personaje.addImg(Type.DERECHA, "./src/img/Marco/MarcoRight.png");
        this.personaje.addImg(Type.IZQUIERDA, "./src/img/Marco/MarcoLeft.png");
        this.personaje.addImg(Type.ARRIBA_L, "./src/img/Marco/MarcoJumpL.png");
        this.personaje.addImg(Type.ARRIBA_R, "./src/img/Marco/MarcoJumpR.png");
        this.personaje.addImg(Type.ABAJO_L, "./src/img/Marco/MarcoCrouchL.png");
        this.personaje.addImg(Type.ABAJO_R, "./src/img/Marco/MarcoCrouchR.png");
        this.personaje.addImg(Type.CORRE_RIGHT, "./src/img/Marco/MarcoRuning.gif");
        this.personaje.addImg(Type.CORRE_LEFT, "./src/img/Marco/MarcoRuningL.gif");
        this.personaje.addImg(Type.DISPARA_R, "./src/img/Marco/MarcoShoot.png");
        this.personaje.addImg(Type.DISPARA_L, "./src/img/Marco/MarcoShootL.png");
        this.personaje.addImg(Type.MORIR, "./src/img/Marco/MarcoDead.png");
        this.toolkit = Toolkit.getDefaultToolkit();
        this.imagenes = new HashMap<>();
        this.imagenes.put(Type.DERECHA, toolkit.getImage(personaje.getImg().get(Type.DERECHA)));
        this.imagenes.put(Type.IZQUIERDA, toolkit.getImage(personaje.getImg().get(Type.IZQUIERDA)));
        this.imagenes.put(Type.ARRIBA_L, toolkit.getImage(personaje.getImg().get(Type.ARRIBA_L)));
        this.imagenes.put(Type.ARRIBA_R, toolkit.getImage(personaje.getImg().get(Type.ARRIBA_R)));
        this.imagenes.put(Type.ABAJO_L, toolkit.getImage(personaje.getImg().get(Type.ABAJO_L)));
        this.imagenes.put(Type.ABAJO_R, toolkit.getImage(personaje.getImg().get(Type.ABAJO_R)));
        this.imagenes.put(Type.CORRE_RIGHT, toolkit.getImage(personaje.getImg().get(Type.CORRE_RIGHT)));
        this.imagenes.put(Type.CORRE_LEFT, toolkit.getImage(personaje.getImg().get(Type.CORRE_LEFT)));
        this.imagenes.put(Type.DISPARA_R, toolkit.getImage(personaje.getImg().get(Type.DISPARA_R)));
        this.imagenes.put(Type.DISPARA_L, toolkit.getImage(personaje.getImg().get(Type.DISPARA_L)));
        this.imagenes.put(Type.MORIR, toolkit.getImage(personaje.getImg().get(Type.MORIR)));

        
//        this.posX = personaje.getPosicionActualX();
//        this.posY = personaje.getPosicionActualY();
        this.deltaX = personaje.getDeltaX();
        this.deltaY = personaje.getDeltaY();
        this.imgActual = this.imagenes.get(Type.DERECHA);

    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.imgActual, this.posX,this.posY,this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(posX<0){
            deltaX=0;
            posX = 0;
        }
        if(posX>930){
            deltaX=0;
            posX=930;
        }
        
        if(posY < 0) { 
            deltaY=0; 
            posY = 0; 
        }
        if(posY > 630) { 
            deltaY=0;
            posY = 630; 
        } 
        posX += deltaX; 
        posY += deltaY;
        
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); 
        if (code == KeyEvent.VK_DOWN){
            System.out.println("Moviendo");
            deltaY = 0; 
            deltaX = 0;
            System.out.println("x: " + posX);
            System.out.println("y: " + posY);
            if(imgActual == imagenes.get(Type.IZQUIERDA)){
                imgActual = imagenes.get(Type.ABAJO_L);
            }else{
                imgActual = imagenes.get(Type.ABAJO_R);
            }
        } 
        if (code == KeyEvent.VK_UP){ 
            System.out.println("Moviendo");
            deltaY = -10; 
            deltaX = 0;
            System.out.println("x: " + posX);
            System.out.println("y: " + posY);
            if(imgActual == imagenes.get(Type.IZQUIERDA)){
                imgActual = imagenes.get(Type.ARRIBA_L);
            }else{
                imgActual = imagenes.get(Type.ARRIBA_R);
            }
        } 
        if (code == KeyEvent.VK_LEFT){  
            System.out.println("Moviendo");
            deltaY = 0; 
            deltaX = -10; 
            System.out.println("x: " + posX);
            System.out.println("y: " + posY);
            imgActual = imagenes.get(Type.CORRE_LEFT);
        } 
        if (code == KeyEvent.VK_RIGHT){ 
            System.out.println("Moviendo");
            deltaY = 0; deltaX = 10;
            System.out.println("x: " + posX);
            System.out.println("y: " + posY);
            imgActual = imagenes.get(Type.CORRE_RIGHT);
        }
        
        if (code == KeyEvent.VK_X){
            if(imgActual==imagenes.get(Type.IZQUIERDA)){
                imgActual = imagenes.get(Type.DISPARA_L);
            }else{
                imgActual = imagenes.get(Type.DISPARA_R);
            }

            System.out.println("Shoot");
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(imgActual == imagenes.get(Type.DISPARA_L) ||
           imgActual == imagenes.get(Type.CORRE_LEFT) ||
           imgActual == imagenes.get(Type.ARRIBA_L) ||
           imgActual == imagenes.get(Type.ABAJO_L)){
                imgActual = imagenes.get(Type.IZQUIERDA);
        }else{
                imgActual = imagenes.get(Type.DERECHA);
        }
        deltaX = 0;
        deltaY = 0;
 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame(); 
        Character p = new Character(); 
        f.add(p); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setSize(1000,700); 
        f.setVisible(true); 
    }
    
}
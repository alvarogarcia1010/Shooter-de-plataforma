
package Modelo.PlayerCharacter;

import PlataformShooter.Type;
import java.util.HashMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class CharacterManager extends Thread{
    
    protected String Nombre;
    protected int vida;
    protected HashMap<Type,String> img;
    protected int posicionActualX;
    protected int posicionActualY;
    protected int deltaX;
    protected int deltaY;

    public CharacterManager(String Nombre, int vida, int PosicionActualX, int PosicionActualY, int deltaX, int deltaY) {
        this.Nombre = Nombre;
        this.vida = vida;
        this.posicionActualX = PosicionActualX;
        this.posicionActualY = PosicionActualY;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.img = new HashMap<>();
        
    }

    public CharacterManager() {}
    
    public void addImg(Type claveImg, String url) {
        this.img.put(claveImg, url);
}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public HashMap<Type, String> getImg() {
        return img;
    }

    public void setImg(HashMap<Type, String> img) {
        this.img = img;
    }

    public int getPosicionActualX() {
        return posicionActualX;
    }

    public void setPosicionActualX(int posicionActualX) {
        this.posicionActualX = posicionActualX;
    }

    public int getPosicionActualY() {
        return posicionActualY;
    }

    public void setPosicionActualY(int posicionActualY) {
        this.posicionActualY = posicionActualY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    
}

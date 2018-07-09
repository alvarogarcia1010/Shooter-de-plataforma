package PlataformShooter;

import Controllers.Connection;
import View.Bienvenida;


/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class PlataformShooter {


    public static void main(String[] args) throws Exception {
        // TODO code application logic here
                Connection prueba = Connection.getInstance();
                prueba.getConnection();
                Bienvenida p = new Bienvenida();

                p.setVisible(true);
    }
    
}

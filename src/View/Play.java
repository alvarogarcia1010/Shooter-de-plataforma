
package View;

import javax.swing.JFrame;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Play extends JFrame{

      public static int height = 700;
      public static int width = 1000;
		
 
      
    public Play(){
        super("Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setSize(width,height);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Play p = new Play();
                
                p.setVisible(true);

            }
            
        });

    }  
    
}

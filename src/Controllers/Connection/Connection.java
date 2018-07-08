
package Controllers.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Connection {
    private static Connection instance;
    
    //Credenciales
    private static final String user = "sql3246649";
    private static final String password = "8RawbUJSNN";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3246649";
    
    private static java.sql.Connection connection;
    
    private Connection(){
        try{ 
            Class.forName(this.driver);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se puede establecer comunicación con el controlador", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Connection getInstance(){
        if(instance == null){
            synchronized(Connection.class){
                if(instance == null){
                    instance = new Connection();
                }
            }
        }
        
        return instance;
    }
    
    public java.sql.Connection getConnection() throws Exception{
        try{
       
            connection = (java.sql.Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realizada con exito");  
            return connection;
        }catch(java.sql.SQLException ex){
            JOptionPane.showMessageDialog(null, "No se puede establecer conexión con la base de datos", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    
    
}

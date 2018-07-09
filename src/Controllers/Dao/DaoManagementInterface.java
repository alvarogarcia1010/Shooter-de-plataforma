
package Controllers.Dao;

import Controllers.Connection;
import java.util.List;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public interface DaoManagementInterface<T> {

    /**
     * Estableciendo conexion con la base de datos
     */
    Connection con = Connection.getInstance();
    
    /**
     * Retorna todos los registros encontrados en la tabla
     * @return ArrayList<T>
     */
    List<T> findAll();
    
     /**
     * Get all register in the database where the table are equals to value in the object
     *
     * @param <T> Objeto con el valor a encontrar
     * @param String Nombre de la tabla 
     * @return ArrayList<T>
     */   
    List<T> findBy(T find, String by);
    
    /**
     * Insert Object in the database and add  id value
     *
     * @param insertObject data to insert
     * @return true is inserted in another case return false
     */
    boolean insert(T insertObject);
    
    /**
     * Update Object in the database where id value
     *
     * @param updateObject
     * @return
     */
    boolean update(T updateObject);
    
    /**
     * Delete Object in the database where id value are equals to object id table
     *
     * @param deleteObject
     * @return
     */
    boolean delete(T deleteObject);
    
}

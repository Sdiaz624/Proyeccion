/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.sql.*;

        
/**
 * Clase encargada de generar conexiones a la base de datos
 * @author Owner
 */
public class Conectar {
   Connection con=null;
   
   /**
    * Metodo encargado de crear la conexion con la base de datos
    * @return un obejto de tipo conexion si hay conexion establecida 
    */
   public Connection conexion(){
       try {
           //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           
            //funcionamiento war
           //con=DriverManager.getConnection("jdbc:mysql://192.168.3.19:3306/ufps_13","ufps_13","ufps_82");
           // funcionamiento prueba
           con=DriverManager.getConnection("jdbc:mysql://sandbox2.ufps.edu.co:3306/ufps_13","ufps_13","ufps_82");
           // cuando sandbox no sirve
         // con=DriverManager.getConnection("jdbc:mysql://localhost/ufps_19","root","");
          
           
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error de conexccion");
           
       }
       return con;
   }
}

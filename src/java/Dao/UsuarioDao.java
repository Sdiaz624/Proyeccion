/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase encargada de interactuar con la Entidad usuario de la base de datos;
 * @author SDIAZ
 */
public class UsuarioDao {
    
    
    /**
     * Metodo encargado de sacar los datos para iniciar secion
     * @param usuario identificador del usuario
     * @return un vector de 2 posiciones en la primera e usuario y en la segunda la contraseña
     * @throws SQLException  errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public String[] iniciarSesion (String usuario) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM usuario WHERE codigo = '"+usuario+"';";
        ResultSet r;
        String [] datos=null;
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
            datos= new String[2];
            datos[0]=String.valueOf(r.getString("codigo"));
            datos[1]=String.valueOf(r.getString("contrase"));        
    }
        reg.close();
        return datos;
        
    }
    
}

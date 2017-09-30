/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Convenio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase encargada de interactuar con la entidad convenio de la base de datos
 * @author SDIAZ
 */
public class ConvenioDao {
    
    /**
     * Metodo encargado de actualizar en la base de datos un convenio
     * @param id identificador del convenio antes de actualizarlo
     * @param c objeto de tipo convenio
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void actualizar(int id,Convenio c) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE convenio "
                + "SET nombre=?, "
                + "fechaInicio=?, "
                + "fechaFin=?, "
                + "objetivo=?, "
                + "estado=?, "
                + "fundacion=?, "
                + "idConvenio=?, "
                + "descripcion=? "
                + " WHERE idConvenio = "+id+";";
                
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getFecha_inicio());
            pst.setString(3, c.getFecha_fin());
            pst.setString(4, c.getObjetivo());
            pst.setString(5, c.getEstado());
            pst.setInt(6, c.getFundacion().getId());
            pst.setInt(7,c.getId());
            pst.setString(8,c.getDescripcion());
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        reg.close();
        
    }
    
    /**
     * Metodo encargado de buscar un convenio en la base de datos
     * @param id identificador del convenio
     * @return un String si se encuentra o no el convenio
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public String consultarConvenio(int id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM convenio WHERE idConvenio = "+id+";";
        ResultSet r;
        Conectar con=new Conectar();
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
           
        
        if (r.next()){
            return "convenio no existe";
            }
            else return "";
        
     
    }
     /**
      * Metodo encargado de insertar un convenio en la base de datos 
      * @param idConvenio identificador del convenio    
      * @param nombre nombre del convenio
      * @param fecha_inicio fecha de inicio del convenio
      * @param fecha_fin fecha de fin del convenio
      * @param objetivo objtivo del convenio
      * @param estado estado del convnio
      * @param fundacion fundacion con la que se realizo el convenio
      * @param des descripcion del convenio
      * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
      */
    public void insertarConvenio(int idConvenio, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, String fundacion, String des) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO convenio (idConvenio,nombre, fechaInicio,fechaFin,objetivo,estado,fundacion, descripcion) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setLong(1,idConvenio);
            pst.setString(2, nombre);
            pst.setString(3, fecha_inicio);
            pst.setString(4, fecha_fin);
            pst.setString(5,objetivo);
            pst.setString(6, estado);
            pst.setString(7, fundacion);
            pst.setString(8,des);
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        reg.close();
    }
    
    /**
     * Metodo encargado de retornar un convenio
     * @param id identificador del convenio
     * @return un objeto de tipo convenio
     * @throws SQLException 
     */
      public Convenio obtenerConvenio(int id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM convenio WHERE idConvenio = "+id+";";
        ResultSet r;
        Conectar con=new Conectar();
        Convenio c = new Convenio();
        FundacionDao fu = new FundacionDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        
        if (r.next()){
           
            c.setEstado(r.getString("estado"));
            c.setFecha_fin(r.getString("fechaFin"));
            c.setFecha_inicio(r.getString("fechaInicio"));
            c.setFundacion(fu.obtenerFundacionPorId(r.getString("fundacion")));
            c.setId(r.getInt("idConvenio"));
            c.setNombre(r.getString("nombre"));
            c.setObjetivo(r.getString("objetivo"));
            c.setDescripcion(r.getString("descripcion"));
        
     
    }
    
        return c;
}
      /**
       * Metodo encargado de retornar todos los proyectos que se encuentran en la base de datos
       * @return una lista con todos los convenios
       * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
       */
      public ArrayList<Convenio> obtenerTodosConvenio() throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM convenio;";
        ResultSet r;
          
        FundacionDao fu = new FundacionDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        ArrayList<Convenio> myConvenio= new ArrayList<Convenio>();

        while (r.next()){
           
            Convenio c = new Convenio();
            c.setEstado(r.getString("estado"));
            c.setFecha_fin(r.getString("fechaFin"));
            c.setFecha_inicio(r.getString("fechaInicio"));
            c.setFundacion(fu.obtenerFundacion(r.getString("fundacion")));
            c.setId(r.getInt("idConvenio"));
            c.setNombre(r.getString("nombre"));
            c.setObjetivo(r.getString("objetivo"));
            myConvenio.add(c);
     
    }
    
        return myConvenio;
}

      public void insertarRutaArchivo(String ruta) {
          
        String por[]=ruta.split("\\.");
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE convenio "
                + "SET ruta=? "
                + " WHERE idConvenio = "+por[0]+";";
            
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
          
            
            pst.setString(1,ruta);
            
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            reg.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
          
      }
      
      public String sacarRutaArchivo(String id) {
          
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM convenio WHERE idConvenio = "+id+";";
        ResultSet r;
        PreparedStatement pst;
        String c ="No Hay Archivos";
        
        try {
            pst = reg.prepareStatement(sql);
            r= pst.executeQuery();
                   
            if (r.next()){
           
            c=r.getString("ruta");
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(c==null){
            c="No Hay Archivos";
        }
        
        return c; 
     
    }
    
        
          
      
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase encargada de interactuar con entidad proyecto de la base de datos
 * @author SDIAZ
 */
public class ProyectoDao {
    
    
    /**
     * metodo encargado de editarle el presupuesto a un proyecto cuando se actualiza una actividad
     * @param id identificador del proyecto
     * @param presupuesto presupuesto del proyecto
     */
    public void modificarPresupuesto(int id, double presupuesto) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE proyecto "
                + "SET  " 
                + " presupuesto=?  "
                + "  WHERE idProyecto = "+ id +";";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            
           
            pst.setDouble(1,presupuesto);
            
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        reg.close();
        
            
        
    }
    
      public void modificarRecursos(int id, double presupuesto) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE proyecto "
                + "SET " 
                + " recursosGastados = ?  "
                + "  WHERE idProyecto = "+ id +";";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            
           
            pst.setDouble(1,presupuesto);
            
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
     * Metodo encargado de registrar un proyecto en la base de datos
     * @param p objeto de tipo proyecto 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void registrar(Proyecto p) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO proyecto (idProyecto,nombre,descripcion,presupuesto,recursosGastados, fechaInicio,fechaFin,estado,fundacion) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setLong(1,p.getId());
            pst.setString(2,p.getNombre());
            pst.setString(3, p.getDescripcion());
            pst.setDouble(4,p.getPresupuesto());
            pst.setDouble(5 , p.getRecursosGastados());
            pst.setString(6, p.getFecha_inicio());
            pst.setString(7, p.getFecha_fin());
            pst.setString(8, p.getEstado());
            pst.setInt(9, p.getFundacion().getId());
            int n=pst.executeUpdate();
            if (n>0){
              //  System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        reg.close();
    }

    /**
     * Metodo encargado de contar la cantidad de proyectos en la base de datos
     * @return un entero con la cantidad de proyectos en la base de datos
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public int idProyecto() throws SQLException{
        
        String res="";
        ResultSet r;
        
        String sql="SELECT COUNT(*) AS contado FROM proyecto;";
        Conectar con=new Conectar();
        Connection reg=con.conexion();
       try{
        PreparedStatement pst=reg.prepareStatement(sql);
        
        r= pst.executeQuery();
        if (r.next()){
            res= r.getString("contado");
        }
        
        
        
       }catch(SQLException ex) {
            ex.printStackTrace();
        }
       reg.close(); 
       return Integer.parseInt(res);
        
    }  
    
    /**
     * Metodo encargado de actualizar un proyecto de la base de datos 
     * @param p objeto de tipo proyecto
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void actualizar(Proyecto p) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE proyecto "
                + "SET nombre=?,"
                + "descripcion=?,"
                
                + " fechaInicio=?,"
                + "fechaFin=?,"
                + "estado=?,"
                + "fundacion=?"
                + "  WHERE idProyecto = "+ p.getId() +";";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            
            pst.setString(1,p.getNombre());
            pst.setString(2, p.getDescripcion());
            
            pst.setString(3, p.getFecha_inicio());
            pst.setString(4, p.getFecha_fin());
            pst.setString(5, p.getEstado());
            pst.setInt(6, p.getFundacion().getId());
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
     * Metodo encargado de verificar si un proyecto se encuentra registrado 
     * @param id identificador del proyecto
     * @return true si no esta registrado, false si sta registrado
     * @throws SQLException 
     */
     public boolean consultarProyecto(int id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM proyecto WHERE idproyecto = "+id;
        ResultSet r;
        Conectar con=new Conectar();
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
            return false;
            }
            else return true;
        
    }
    
     
     /**
      * Metodo encargado de retornar un proyecto de la base de datos
      * @param id identificador del proyecto
      * @return un objeto de tipo proyecto
      * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
      */
     public Proyecto obtenerProyecto(int id) throws SQLException{
         
         
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM proyecto WHERE idproyecto = "+id;
        ResultSet r;
        Conectar con=new Conectar();
        Proyecto p = new Proyecto();
        FundacionDao f= new FundacionDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
            
            p.setId(r.getInt("idProyecto"));
            p.setFecha_inicio(r.getString("fechaInicio"));
            p.setFecha_fin(r.getString("fechaFin"));
            p.setEstado(r.getString("estado"));
            p.setFundacion(f.obtenerFundacionporID(r.getString("fundacion")));
            p.setDescripcion(r.getString("descripcion"));
            p.setNombre(r.getString("nombre"));
            p.setPresupuesto(r.getDouble("presupuesto"));
            p.setRecursosGastados(r.getDouble("recursosGastados"));        
    }
        reg.close();
        return p;
     }
     
     
     /**
      * Metodo encargado de buscar todos los proyectos de la base de datos
      * @return un listado con todos los proyectos de la base de datos
      * @throws SQLException  un listado con todos los proyectos de la base de datos
      */
     public ArrayList<Proyecto> obtenerTodosProyecto() throws SQLException{
         
         
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM proyecto" ;
        ResultSet r;
        Conectar con=new Conectar();
        ArrayList<Proyecto> myProyecto= new ArrayList<Proyecto>();
        FundacionDao f= new FundacionDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        while (r.next()){
            
            Proyecto p = new Proyecto();
            p.setId(r.getInt("idProyecto"));
            p.setFecha_inicio(r.getString("fechaInicio"));
            p.setFecha_fin(r.getString("fechaFin"));
            p.setEstado(r.getString("estado"));
            p.setFundacion(f.obtenerFundacion(r.getString("fundacion")));
            p.setDescripcion(r.getString("descripcion"));
            p.setNombre(r.getString("nombre"));
            p.setPresupuesto(r.getDouble("presupuesto"));
            p.setRecursosGastados(r.getDouble("recursosGastados"));        
            myProyecto.add(p);
                    
    }
        reg.close();
        return myProyecto;
     }
     
     /**
      * Metodo encargado de buscar todos los proyectos por fundacion de la base de datos
      * @return un listado con todos los proyectos de la base de datos
      * @throws SQLException  un listado con todos los proyectos de la base de datos
      */
     public ArrayList<Proyecto> obtenerTodosProyectoFundacion(int id) throws SQLException{
         
         
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM proyecto WHERE fundacion = "+id+" ; ";
        ResultSet r;
        Conectar con=new Conectar();
        ArrayList<Proyecto> myProyecto= new ArrayList<Proyecto>();
        FundacionDao f= new FundacionDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        while (r.next()){
            
            Proyecto p = new Proyecto();
            p.setId(r.getInt("idProyecto"));
            p.setFecha_inicio(r.getString("fechaInicio"));
            p.setFecha_fin(r.getString("fechaFin"));
            p.setEstado(r.getString("estado"));
            p.setFundacion(f.obtenerFundacion(r.getString("fundacion")));
            p.setDescripcion(r.getString("descripcion"));
            p.setNombre(r.getString("nombre"));
            p.setPresupuesto(r.getDouble("presupuesto"));
            p.setRecursosGastados(r.getDouble("recursosGastados"));        
            myProyecto.add(p);
                    
    }
        reg.close();
        return myProyecto;
     }
    }
    
    


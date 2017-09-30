/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Fundacion;
import Dto.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * clase encargada de interactuar con la entidad fundacion de la base de datos
 * @author SDIAZ
 */
public class FundacionDao {

    /**
     * Metodo encargado de contar todas las fundaciones en la base de datos
     * @return un entero con el numro de fundaciones 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    
    public int idFundacion() throws SQLException{
        
        String res="";
        ResultSet r;
        
        String sql="SELECT COUNT(*) AS contado FROM fundacion;";
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
     * Metodo encargado de insertar una fundacion en la base d datos
     * @param id identificador de la fundacion
     * @param nit nit de la fundacion 
     * @param nombre nombre de la fundacion 
     * @param representante repreesntante de la fundacion
     * @param telefono telefono de la fundacion
     * @param direccion direccion de la fundacion
     * @param correo correo de la fundacion
     * @param des descripcion de la fundacion
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void insertarFundacion(int id,String nit, String   nombre, double representante , String  telefono ,String direccion, String correo, String des) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO fundacion (idFundacion,nit, nombre, representante , telefono ,direccion, correo, descripcion)VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2,nit);
            pst.setString(3, nombre);
            pst.setDouble(4,representante);
            pst.setString(5,telefono);
            pst.setString(6, direccion);
            pst.setString(7, correo);
            pst.setString(8, des);
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
     * Metodo encargado de verificar la existencia de una fundacion
     * @param nit identificador de la fundacion 
     * @return true si no existe, false si existe
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public boolean consultarFundacion(String nit) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion WHERE nit = '"+nit+"';";
        ResultSet r;
       
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        
        if (r.next()){
            return false;
            }
            else return true;
        
    }
    
    
    /**
     * Metodo encargado de verificar la existencia de una fundacion
     * @param id identificador de la fundacion 
     * @return true si no existe, false si existe
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public boolean consultarFundacionPorId(String id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion WHERE idFundacion = '"+id+"';";
        ResultSet r;
       
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        
        if (r.next()){
            return false;
            }
            else return true;
        
    }
    /**
     * Metodo encargado de actualizar una fundacion en la base de datos
     * @param f objeto de tipo fundacion
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void actualizar(Fundacion f) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE fundacion  "
                + "SET nit=?, "
                + "nombre=?, "
                + "representante=? , "
                + "telefono=? , "
                + "direccion=?, "
                + "correo=?, "
                + "descripcion=? "
                + " WHERE idFundacion="+f.getId()+";";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setString(1,f.getNit());
            pst.setString(2, f.getNombre());
            pst.setDouble(3,f.getRepresntante().getCedula());
            pst.setString(4,f.getTelefono());
            pst.setString(5, f.getDireccion());
            pst.setString(6, f.getCorreo());
            pst.setString(7, f.getDescripcion());
            int n=pst.executeUpdate();
            if (n>0){
               // System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        reg.close();
        
    }

    /**
     * Metodo encargado de obtener una fundacionde la base de datos
     * @param id identificador de la fundacion
     * @return un objeto de tipo fundacion 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public Fundacion obtenerFundacion(String id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion WHERE nit ='"+id+"';";
        ResultSet r;
        
        Fundacion p = new Fundacion();
        PersonaDao y= new PersonaDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
          
            p.setId(r.getInt("idFundacion"));
            p.setCorreo(r.getString("correo"));
            p.setDireccion(r.getString("direccion"));
            p.setTelefono(r.getString("telefono"));
            p.setNombre(r.getString("nombre"));
            p.setNit(r.getString("nit"));
            p.setDescripcion(r.getString("descripcion"));
            p.setRepresntante(y.obtenerPersona(r.getDouble("representante")));
            
                        
    }
        return p;
    }

    /**
     * Metodo encargado de obtener una fundacionde la base de datos
     * @param id identificador de la fundacion
     * @return un objeto de tipo fundacion 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public Fundacion obtenerFundacionporID(String id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion WHERE idFundacion ='"+id+"';";
        ResultSet r;
        
        Fundacion p = new Fundacion();
        PersonaDao y= new PersonaDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
          
            p.setId(r.getInt("idFundacion"));
            p.setCorreo(r.getString("correo"));
            p.setDireccion(r.getString("direccion"));
            p.setTelefono(r.getString("telefono"));
            p.setNombre(r.getString("nombre"));
            p.setNit(r.getString("nit"));
            p.setDescripcion(r.getString("descripcion"));
            p.setRepresntante(y.obtenerPersona(r.getDouble("representante")));
            
                        
    }
        return p;
    }
    /**
     * Metodo encargado de obtener una fundacionde la base de datos
     * @param id identificador de la fundacion
     * @return un objeto de tipo fundacion 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public Fundacion obtenerFundacionPorId(String id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion WHERE idFundacion ='"+id+"';";
        ResultSet r;
        
        Fundacion p = new Fundacion();
        PersonaDao y= new PersonaDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
          
            p.setId(r.getInt("idFundacion"));
            p.setCorreo(r.getString("correo"));
            p.setDireccion(r.getString("direccion"));
            p.setTelefono(r.getString("telefono"));
            p.setNombre(r.getString("nombre"));
            p.setNit(r.getString("nit"));
            p.setDescripcion(r.getString("descripcion"));
            p.setRepresntante(y.obtenerPersona(r.getDouble("representante")));
            
                        
    }
        return p;
    }

    
    /**
     * Metodo encargado de obtener todas las fundaciones de la base de datos
     * @return un listado con todas las fundaciones 
     * @throws SQLException 
     */
    public ArrayList<Fundacion> obtenerTodasFundaciones() throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM fundacion;";
        ResultSet r;
        PersonaDao y= new PersonaDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        ArrayList<Fundacion> funda =new ArrayList<Fundacion>();
        r= pst.executeQuery();
        while (r.next()){
          
            Fundacion p = new Fundacion();
            p.setId(r.getInt("idFundacion"));
            p.setCorreo(r.getString("correo"));
            p.setDireccion(r.getString("direccion"));
            p.setTelefono(r.getString("telefono"));
            p.setNombre(r.getString("nombre"));
            p.setNit(r.getString("nit"));
            p.setDescripcion(r.getString("descripcion"));
            p.setRepresntante(y.obtenerPersona(r.getDouble("representante")));
            
            funda.add(p);
            
                        
    }
        return funda;
    }
}

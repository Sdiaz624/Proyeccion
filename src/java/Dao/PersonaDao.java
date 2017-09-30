/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Persona;
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
  Clase encargarda de interactuar con la entidad persona de la base de datos
 * @author SDIAZ
 */
public class PersonaDao {

    /**
     * Metodo encargado de obetener todas las personas de la base de datos dependiendo de un tipo
     * @param id tipo de persona
     * @return un listado de personas de un solo tipo
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public ArrayList<Persona> obtenerTipoPersona(int id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM persona where tipo =" + id + ";" ;
        ResultSet r;
        Conectar con=new Conectar();
        ArrayList<Persona> myProyecto= null;
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if(r.next()){
         r.previous();
        myProyecto = new ArrayList<Persona>();
        
        while (r.next()){
            
            Persona p = new Persona();
         
            p.setCedula(r.getDouble("cedula"));
            p.setCodigo(r.getInt("codigo"));
            p.setCorreo(r.getString("correo"));
            p.setNombre(r.getString("nombre"));
            p.setTelefono(r.getString("telefono"));
            p.setTipo(r.getInt("tipo"));
            
            myProyecto.add(p);
                    
    }
        }
        reg.close();
        return myProyecto;
     }
        
    
    
    
    /**
     * Metodo encargado de retornar una persona de la base de datos
     * @param cedula identificador de la persona 
     * @return un objeto de tipo persona
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public Persona obtenerPersona(double cedula) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM persona WHERE cedula = "+cedula+";";
        ResultSet r;
        Persona p =null;
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        if (r.next()){
        
            p= new Persona();
            p.setCedula(r.getDouble("cedula"));
            p.setCodigo(r.getInt("codigo"));
            p.setCorreo(r.getString("correo"));
            p.setNombre(r.getString("nombre"));
            p.setTelefono(r.getString("telefono"));
            p.setTipo(r.getInt("tipo"));
                    
    }
        reg.close();
        return p;
}
    /**
     * Metodo encargado de verificar una persona en la base de datos
     * @param cedula identificador de la persona
     * @return true si no se encuentra, false si si se encuentra
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public boolean buscarPersona(double cedula) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM persona WHERE cedula= "+cedula+";";
        ResultSet r;
        
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        if (r.next()){
                        return false;
            
            }
            else return true ;
        
        
    }
    
    /**
     * Metodo encargado de insertar una persona en la base de datos
     * @param p objeto de tipo persona 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void registrar(Persona p) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO persona (telefono, nombre, correo, cedula, tipo, codigo)VALUES (?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setString(1,p.getTelefono());
            pst.setString(2,p.getNombre());
            pst.setString(3,p.getCorreo());
            pst.setDouble(4,p.getCedula());
            pst.setInt(5, p.getTipo());
            pst.setInt(6, p.getCodigo());
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
     * Metodo encargado de actualizar una persona de la base de datos
     * @param p objeto de tipo persona
     * @throws SQLException 
     */
    public void actualizar(Persona p, double cedula) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE persona "
                + "SET telefono=?, "
                + "nombre=?, "
                + "correo=?, "
                + "cedula=?, "
                + "tipo=?, "
                + "codigo=? "
                + " WHERE cedula = "+cedula+";";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setString(1,p.getTelefono());
            pst.setString(2,p.getNombre());
            pst.setString(3,p.getCorreo());
            pst.setDouble(4,p.getCedula());
            pst.setInt(5, p.getTipo());
            pst.setInt(6, p.getCodigo());
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        reg.close();
        
        
    }
    }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Actividad;
import Dto.ActividadPersona;
import Dto.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase encargada de interactar con la entidad actividadPersona de la base de datos
 * @author SDIAZ
 */
public class ActividadPersonaDao {
    
    /**
     * Metodo encargado de consultar todas las personas pertenecientas a una actividad
     * @param cedula identificador de la persona
     * @param actividad identificador de la actividad
     * @return una lista con todos las personas involucradas eb uba actividad
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public ArrayList<ActividadPersona> consultar(int actividad) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM actividadpersona WHERE  idActividad="+actividad+";";
        ResultSet r;
        ArrayList<ActividadPersona> a = new ArrayList<ActividadPersona>();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        PersonaDao x= new PersonaDao();
        ActividadDao y = new ActividadDao();
        while(r.next()){
         
            ActividadPersona b = new ActividadPersona();
            
            double persona = r.getDouble("idPersona");
            int acti= r.getInt("idActividad");
            
            b.setA(y.retornarActividad(acti));
            b.setP(x.obtenerPersona(persona));
            
            a.add(b);
        }
        reg.close();
       
        return a;
    }
    /**
     * se encarga de registrar una persona en una actividad
     * @param a un objeto de tipo ActividadPersona 
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void registrar(ActividadPersona a) throws SQLException{
        
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO ActividadPersona (idActividad, idPersona, inicio, fin)VALUES (?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            
            pst.setInt(1,a.getA().getId());
            pst.setDouble(2,a.getP().getCedula());
            pst.setString(3,a.getA().getFecha_inicio() );
            pst.setString(4,a.getA().getFecha_fin());
            
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.println("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ActividadPersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        reg.close();
        
    }
    
    /**
     * Metodo encargado de buscar las personas que no se ncientran en la anctividad
     * @param id identificador de la actividad
     * @return un listado de personas que no estan en la  actividad
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public ArrayList<Persona> personasNoActividas(int id) throws SQLException{
        
       
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM persona WHERE cedula NOT IN ( SELECT idPersona FROM actividadpersona WHERE idActividad = "+ id +" );";
        ResultSet r;
        Conectar con=new Conectar();
        ArrayList<Persona> myProyecto= new ArrayList<Persona>();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
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
        reg.close();
        return myProyecto;
     }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Dto.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase actividadDao intereactua con la entidad actividad de la base de datos
 * @author SDIAZ
 */

public class ActividadDao {
    
    
    /**
     * Metodo encargado de actualizar en la base de datos un Actividad
     * @param a objeto de tipo Actividad
     * @throws SQLException errores de conexion a la base de datos, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void actualizar(Actividad a) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="UPDATE actividad "
                + " SET "
                + "nombre = ?, "
                + "descripcion = ?, "
                + "tipo = ?, "
                + "estado = ? , "
                + "presupuesto = ?, "
                + "recursosGastados =?, "
                + "fechaInicio = ? ,"
                + "fechaFin = ? , "
                + "evaluacion = ?, "
                + "coordinador =? , "
                + "proyecto = ?  "
                + " WHERE idActividad = "+a.getId()+";";
        
                PreparedStatement pst=reg.prepareStatement(sql);
        try{
            
            
            
           pst.setString(1,a.getNombre());
           pst.setString(2, a.getDescripcion());
           pst.setString(3,a.getTipo());
           pst.setString(4, a.getEstado());
           pst.setDouble(5, a.getPresupuesto());
           pst.setDouble(6,a.getRecursosGastados());
           pst.setString(7,a.getFecha_inicio());
           pst.setString(8,a.getFecha_fin() );
           pst.setString(9, a.getEvaluacion());
           pst.setDouble(10, a.getCoordinador().getCedula());
           pst.setInt(11,a.getProyecto().getId());
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
     * Metodo encargado de registrar una actividad en la base de datos
     * @param a un objeto de tipo Avtividad
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public void resgistrar(Actividad a) throws SQLException{
        
    
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="INSERT INTO actividad (idActividad,nombre,descripcion,tipo,estado, presupuesto,recursosGastados, fechaInicio,fechaFin, evaluacion,coordinador,proyecto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement pst=reg.prepareStatement(sql);
            pst.setInt(1,a.getId());
            pst.setString(2,a.getNombre());
            pst.setString(3, a.getDescripcion());
            pst.setString(4,a.getTipo());
            pst.setString(5, a.getEstado());
            pst.setDouble(6, a.getPresupuesto());
            pst.setDouble(7,a.getRecursosGastados());
            pst.setString(8,a.getFecha_inicio());
            pst.setString(9,a.getFecha_fin() );
            pst.setString(10, a.getEvaluacion());
            pst.setDouble(11, a.getCoordinador().getCedula());
            pst.setInt(12,a.getProyecto().getId());
            int n=pst.executeUpdate();
            if (n>0){
                //System.out.print("registrado con exito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FundacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        reg.close();
        
    }
    
    /**
     * Metodo encargado de verificar cuantas actividades hay en la base de datos
     * @return cantidad de actividades en la base de datos
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public int idActividad() throws SQLException{
        
        String res="";
        ResultSet r;
        
        String sql="SELECT COUNT(*) AS contado FROM actividad;";
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
     * Metodo  encargado de buscar todas las actividades pertenecintes a algun proyecto
     * @param proyecto identificador del proyecto
     * @return una lista con todas las actividades del proyecto a buscar
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public ArrayList<Actividad> obtenerTodaslasActividades(int proyecto) throws SQLException{
         
         
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM actividad WHERE proyecto ='"+proyecto+"';" ;
        ResultSet r;
        Conectar con=new Conectar();
        ArrayList<Actividad> myActividad= new ArrayList<Actividad>();
        PersonaDao f= new PersonaDao();
        ProyectoDao po = new ProyectoDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        while (r.next()){
            
            Actividad p = new Actividad();
            p.setId(r.getInt("idActividad"));
            p.setNombre(r.getString("nombre"));
            p.setFecha_inicio(r.getString("fechaInicio"));
            p.setFecha_fin(r.getString("fechaFin"));
            p.setDescripcion(r.getString("descripcion"));
            p.setPresupuesto(r.getDouble("presupuesto"));
            p.setTipo(r.getString("tipo"));
            p.setCoordinador(f.obtenerPersona(r.getInt("coordinador")));
            p.setProyecto(po.obtenerProyecto(r.getInt("proyecto")));
            p.setTipo(r.getString("tipo"));
            p.setEvaluacion(r.getString("evaluacion"));
            p.setRecursosGastados(r.getDouble("recursosGastados"));
            
            myActividad.add(p);
                    
    }
        reg.close();
        return myActividad;
     }

    /**
     * Metodo encargado de buscar una actividad en una base de datos y retornarla 
     * @param proyecto identificador de laactividad a buscar
     * @return un objeto de tipo actividad
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public Actividad retornarActividad(int proyecto) throws SQLException{
         
         
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM actividad WHERE idActividad ='"+proyecto+"';";
        ResultSet r;
        Conectar con=new Conectar();
        Actividad p = new Actividad();
        PersonaDao f= new PersonaDao();
        ProyectoDao po = new ProyectoDao();
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        if (r.next()){
           
            p.setId(r.getInt("idActividad"));
            p.setNombre(r.getString("nombre"));
            p.setFecha_inicio(r.getString("fechaInicio"));
            p.setFecha_fin(r.getString("fechaFin"));
            p.setDescripcion(r.getString("descripcion"));
            p.setPresupuesto(r.getDouble("presupuesto"));
            p.setTipo(r.getString("tipo"));
            p.setCoordinador(f.obtenerPersona(r.getInt("coordinador")));
            p.setProyecto(po.obtenerProyecto(r.getInt("proyecto")));
            p.setTipo(r.getString("tipo"));
            p.setEvaluacion(r.getString("evaluacion"));
            p.setRecursosGastados(r.getDouble("recursosGastados"));
            p.setEstado(r.getString("estado"));
                    
    }
        reg.close();
        return p;
     }
    
    /**
     * Metodo encargado de verificar si existe una actividad en la base de datos
     * @param id identificador de la actividad
     * @return un true si no esta en la base de datos, un false si si sta en la base de datos
     * @throws SQLException errores de conexion, duplicado de llaves primarias, llaves foraneas no existentes
     */
      public boolean consultarActividad(int id) throws SQLException{
        
        Conectar co= new Conectar();
        Connection reg= co.conexion();
        String sql="SELECT * FROM actividad WHERE idActividad = "+id;
        ResultSet r;
        Conectar con=new Conectar();
        
        PreparedStatement pst=reg.prepareStatement(sql);
        r= pst.executeQuery();
        
        
        if (r.next()){
            return true;
            }
            else return false;
        
        
    }
    
    }
    
    
    


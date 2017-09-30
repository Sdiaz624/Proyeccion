/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mundo;

import Dao.ActividadDao;
import Dao.ConvenioDao;
import Dao.FundacionDao;
import Dao.PersonaDao;
import Dao.ProyectoDao;
import Dto.Actividad;
import Dto.Convenio;
import Dto.Fundacion;
import Dto.Persona;
import Dto.Proyecto;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase encargada en realizar la logica del negocio sobre registros en la base de datos, se comunica con los dao de las entidades a insertar
 * @author SDIAZ
 */
public class Registros {
    
    private ArrayList <Fundacion> myFundaciones = new ArrayList <Fundacion>() ;
    private Consultas consulta= new Consultas();
    
    
    
    /**
     * Metodo encargado de verificar que la fundacion no este registrada y decirle al dao correspondient que la registre
     * @param nit nit de la fundacion a registrar
     * @param nombre nombre de la fundacion a registrar
     * @param representante representante de la fundacion a registrar
     * @param telefono telefono de la fundacion a registrar
     * @param direccion direccion de la fundacion a registrar 
     * @param correo correo de la fundacion a registrar
     * @param descripcion descripcion de la fundacion a registrar
     * @return si hubo registro exitoso o no
     * @throws SQLException errores de conexion a la base de datos, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public String registrarFundacion(String nit, String nombre, double representante, String telefono, String direccion, String correo, String descripcion ) throws SQLException{
        
        String msg="Registro no Exitoso";
        
        FundacionDao fu=new FundacionDao();
        int id = fu.idFundacion();
        if(consulta.BuscarFundacion(nit)){
            System.out.println("entro a fu");
            Persona p =consulta.obtenerPersona(representante);
            Fundacion f = new Fundacion(id+1,nit,nombre,p,telefono, direccion,correo, descripcion);
            if(consulta.obtenerPersona(representante)==null){
               
                return "no existe representante";
            }
                      
            fu.insertarFundacion(id+1,nit, nombre, representante ,  telefono , direccion,  correo, descripcion);
            
            
            return "Registro exitoso";
            
        }
        
        return msg;
    }
    
    
    /**
     * Metodo encargado de verificar que el convenio no este registrado y decirle al dao correspondiente que la registre
     * @param idConvenio id del convenio a registrar
     * @param nombre nombree del convenio a registrar
     * @param fecha_inicio fecha de inicio del convenio a regstrar
     * @param fecha_fin fecha de fin del convenio a registrar
     * @param objetivo objetivo del convnio a registrar
     * @param estado estado del convenio a registrar
     * @param fundacion fundacion del convenio a registrar
     * @param des descripcion del convenio a registrar
     * @return si hubo registro exitoso o no
     */
    public String resgistrarConvenio(int idConvenio, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, String fundacion, String des) {
        
              
                
               
        Fundacion f = consulta.obtenerFundacion(fundacion);
        String msg= "Registro no Exitoso";
        if(!f.equals(null)){
            if(!consulta.BuscarConvenio(idConvenio)){
                
                               
                try{
                               
            
                    
                Convenio c =new Convenio( idConvenio, nombre,fecha_inicio, fecha_fin,  objetivo, f, des);
                ConvenioDao co = new ConvenioDao();
                co.insertarConvenio(idConvenio, nombre, fecha_inicio, fecha_fin, objetivo, estado, fundacion, des);
                msg="registro exitoso";
                return msg;
                }catch (SQLException e){
                    e.printStackTrace();
                }
                
                
            }
            return "Convenio ya existe";
        }
        
        return "Fundacion ya existe";
    }
    
    
    /**
     * Metodo encargado de verificar que el proyecto no este registrado y decirle al dao correspondiente que la registre 
     * @param nombre nombre del proyecto a registrar
     * @param descripcion descripcion del proyecto a registrar
     * @param estado estado del proyecto a registrar
     * @param presupuesto presupuesto del proyecto a registrar 
     * @param recursosGastados recursos gastados del proyecto a registrar
     * @param fecha_inicio fecha de inicio  del proyecto a registrar
     * @param fecha_fin fecha de din del proyecto a registrar
     * @param fundacion fundacion del proyecto a registrar
     * @return si hubo registro exitoso o no
     */
    public String registrarProyecto(String nombre, String descripcion, String estado, double presupuesto,  String fecha_inicio, String fecha_fin, String fundacion){
        ProyectoDao p= new ProyectoDao();
        FundacionDao f= new FundacionDao();
        Fundacion fu = new Fundacion();
        try {
            if(!f.consultarFundacionPorId(fundacion)){
              
                fu=f.obtenerFundacionporID(fundacion);
                int id = p.idProyecto();
                Proyecto r = new Proyecto( id+1,  nombre,  descripcion, estado, presupuesto,0,  fecha_inicio, fecha_fin,fu);
                p.registrar(r);
                System.out.println("SII");
                return "Registro exitoso";
                
            }else{
                return "La fundacion no existe";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return "Error";
    }
    
    /**
     * Metodo encargado de verificar que la actividad no este registrada y decirle al dao correspondiente que la registre
     * @param nombre nombre de la actividad a registrar
     * @param descripcion descripcion de la actividad a registrar
     * @param tipo tipo de la actividad a registrar
     * @param estado estado de la actividad a registrar
     * @param recursosGastados recursos gastados de la actividad a registrar
     * @param presupuesto presupusto de la actividad a registrar
     * @param fecha_inicio fecha de inicio de la actividad a registrar
     * @param fecha_fin fecha de fin de la actividad a registrar
     * @param evaluacion evaluacion de la actividad a registrar
     * @param coordinador coordinador de la actividad a registrar
     * @param proyecto proyecto a la que pertenece la actividad a registrar
     * @return si hubo registro exitoso o no
     */
    public String registrarActividad( String nombre, String descripcion, String tipo, String estado, double recursosGastados, double presupuesto, String fecha_inicio, String fecha_fin, String evaluacion, double coordinador, int proyecto){
        
        ProyectoDao p = new ProyectoDao();
        PersonaDao po= new PersonaDao();
        ProyectoDao proy= new ProyectoDao();
        ActividadDao acti= new ActividadDao();
        try {
            if(!p.consultarProyecto(proyecto)){
        
                if(!po.buscarPersona(coordinador)){
                
                    if(!proy.consultarProyecto(proyecto)){
                        
                        Proyecto wn= proy.obtenerProyecto(proyecto);
                        Persona coor= po.obtenerPersona(coordinador);
                        int id = acti.idActividad() ;
                        Actividad a = new Actividad (id+1, nombre, descripcion, tipo, estado, recursosGastados, presupuesto,  fecha_inicio, fecha_fin, evaluacion, coor,  wn);
                        acti.resgistrar(a);
                        p.modificarPresupuesto(wn.getId(), wn.getPresupuesto()+a.getPresupuesto());
                        p.modificarRecursos(wn.getId(),wn.getRecursosGastados()+a.getRecursosGastados());
                        return "Registro exitoso";
                    }
                
                    return "Proyecto no registrado";
                }
                return "Coodinador no registrado";
            }
            
            return "El proyecto no esta registrado";
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return "Error";
    }
    
    
    /**
     * Metodo encargado de verificar que la persona no este registrado y decirle al dao correspondiente que la registre 
     * @param cedula cedula de la persona a registrar
     * @param nombre nombre de la persona a registrar
     * @param codigo codigo de la persona a registrar
     * @param telefono telefono de la persona a registrar
     * @param correo correo de la persona a registrar
     * @param tipo tipo de la persona a registrar
     * @return si hubo registro exitoso o no
     */
    public String registrarPersona(double cedula, String nombre, int codigo, String telefono, String correo, int tipo  ){
        
        PersonaDao m= new PersonaDao();
        try {
            if(m.buscarPersona(cedula)){
                
          Persona p = new Persona(cedula, codigo, nombre, telefono, correo, tipo);
          m.registrar(p);
          return "Registro exitoso";
                
                
            }
         
          return "Registro no exitoso";
        } catch (SQLException ex) {
            Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return "Error";
    }
    
}

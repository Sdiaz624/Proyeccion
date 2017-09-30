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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada en realizar la logica del negocio sobre actualizaciones de la base de datos, se comunica con los dao de las entidades a actualizar
 * @author SDIAZ
 */
public class Actualizaciones {
 
    /**
     * Metodo encargado en crear un objeto de tipo persona y enviarlo al dao correspondiente para que ejecute la actualizacion
     * @param cedula nueva cedula de la persona
     * @param nombre nuevo nombre de la persona
     * @param codigo nuevo codigo de la persona
     * @param telefono nuevo telefono de la persona
     * @param correo nuevo correo de la persona
     * @param tipo nuevo tipo de la persona
     * @return true si actualiza la persona, false si no actualiza
     */
    
    
    public boolean actualizarPersona(double cedulaa,double cedula, String nombre, int codigo, String telefono, String correo, int tipo  ){
        
        PersonaDao a= new PersonaDao();
        try {
            boolean esta = a.buscarPersona(cedulaa);
            if(!esta){
                Persona p= new Persona(cedula,codigo, nombre,  telefono,  correo,  tipo);
                a.actualizar(p,cedulaa);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
    /**
     * Metodo encargado en crear un objeto de tipo Fundacion y enviarlo al dao correspondiente para que ejecute la actualizacion
     * @param id nuevo id de la fundacion 
     * @param nit nuevo nit de la fundacion
     * @param nombre nuevo nombre de la fundacion
     * @param representante nuevo representante de la fundacion
     * @param telefono nuevo telefono de la fundacion
     * @param direccion nueva direccion de la fundacion
     * @param correo nuevo correo de la fundacion
     * @param des nueva descripcion de la fundacion
     * @return true si actualiza la fundacion, false si no actualiza
     */
    public boolean actualizarFundacion(int id,String nit, String nombre, double representante, String telefono, String direccion, String correo,String des){
        
        FundacionDao a= new FundacionDao();
        try {
            boolean esta = a.consultarFundacionPorId(String.valueOf(id));
            if(!esta){
                
                PersonaDao x = new PersonaDao();
                Persona y = x.obtenerPersona(representante);
                Fundacion p = new Fundacion (id,nit,  nombre, y, telefono,  direccion,  correo, des);
                a.actualizar(p);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
        
        
    }
    
    /**
     * Metodo encargado en crear un objeto de tipo convenio y enviarlo al dao correspondiente para que ejecute la actualizacion
     * @param id id antiguo del convenio
     * @param idConvenio  nuevo id del convenio
     * @param nombre buevo nombre del convenio
     * @param fecha_inicio nueva facha de inicio del convenio 
     * @param fecha_fin nueva fecha de fin del convenio
     * @param objetivo nuevo objetivo del convenio
     * @param estado nuevo stado del convenio
     * @param fundacion nueva fuadacion del convenio
     * @param Des nueva descripcion del convenio
     * @return  true si actualiza el Convenio, false si no actualiza
     */
    public boolean actualizarConvenio(int id,int idConvenio, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, String fundacion, String Des){
        
        ConvenioDao a= new ConvenioDao();
        try {
            String esta = a.consultarConvenio(id);
            if(esta.equals("convenio no existe")){
                
                FundacionDao f = new FundacionDao();
                Fundacion fu = f.obtenerFundacionPorId(fundacion);
                Convenio p = new Convenio( idConvenio,  nombre, fecha_inicio,  fecha_fin,  objetivo, estado, fu, Des);
                a.actualizar(id,p);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
        
        
    }
    
    /**
     * Metodo encargado en crear un objeto de tipo proyecto y enviarlo al dao correspondiente para que ejecute la actualizacion
     * @param id nuevo id del proyecto
     * @param nombre nuevo nombre del proyecto
     * @param descripcion nueva descripcion del proyecto
     * @param estado nuevo estado del proyecto
     * @param presupuesto nuevo presupuesto del proyecto
     * @param recursosGastados nuevo recursos gastados del proyecto
     * @param fecha_inicio nueva fecha de inicio del proyecto
     * @param fecha_fin nueva fecha de fin del proyecto
     * @param fundacion nueva fundacion del proyecto
     * @return true si actualiza el proyecto, false si no actualiza
     */
    public boolean actualizarProyecto(int id,String nombre, String descripcion, String estado, String fecha_inicio, String fecha_fin, String fundacion){
        
        ProyectoDao a= new ProyectoDao();
        try {
            boolean esta = a.consultarProyecto(id);
            if(!esta){
                FundacionDao f = new FundacionDao();
                Fundacion fu = f.obtenerFundacionporID(fundacion);
                Proyecto p = new Proyecto(id, nombre, descripcion, estado,0,  0,  fecha_inicio,  fecha_fin, fu);
                a.actualizar(p);
                
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
        
    }
    
    /**
     * Metodo encargado en crear un objeto de tipo actividad y enviarlo al dao correspondiente para que ejecute la actualizacion
     * @param id nuevo id de la actividad
     * @param nombre nuevo nombre de la actividad
     * @param descripcion nueva descripcion de la actividad
     * @param tipo nuevo tipo de la actividad
     * @param estado nuevo stado de la actividad
     * @param presupuesto nuvo presupuesto de la actividad
     * @param recursosGastados nuevo recursos gastados de la a ctividad
     * @param fecha_inicio nuva fecha de inicio de la actividad
     * @param fecha_fin nueva fecha de fin de la actividad
     * @param evaluacion nueva evaluacion de la activdad
     * @param coordinador nuevo coordinador de la actividad
     * @param proyecto nuevo proyecto de la actividad
     * @return true si actualiza la actividad, false si no actualiza
     */
    
    public boolean actualizarActividad( int id,String nombre, String descripcion, String tipo, String estado,  double presupuesto,double recursosGastados, String fecha_inicio, String fecha_fin, String evaluacion, double coordinador, int proyecto){
        
        
        ActividadDao a= new ActividadDao();
        try {
            boolean esta = a.consultarActividad(id);
            if(esta){
                PersonaDao po = new PersonaDao();
                Persona coo = po.obtenerPersona(coordinador);
                ProyectoDao pr = new ProyectoDao();
                Proyecto l= pr.obtenerProyecto(proyecto);
                Actividad p = new Actividad(id,nombre, descripcion, tipo,estado,  recursosGastados,  presupuesto,  fecha_inicio, fecha_fin, evaluacion, coo,  l);
                a.actualizar(p);
                pr.modificarPresupuesto(l.getId(), l.getPresupuesto()+p.getPresupuesto());
                pr.modificarRecursos(l.getId(),l.getRecursosGastados()+p.getRecursosGastados());
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Mundo.Actualizaciones;
import java.sql.Date;

/**
 * Clase intermediaria entre la interfaz grafica y la logica del negocio para los metodos relacionados con actualizaciones
 * @author SDIAZ
 */
public class ActualizacionesFacade {
 
    private Actualizaciones a= new Actualizaciones();
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para actualizar persona
     * @param cedula cedula de la persona
     * @param nombre nombre de la persona
     * @param codigo codigo de la persona
     * @param telefono telefono de la persona
     * @param correo correo de la persona
     * @param tipo tipo de persona
     * @return true si actualizo, false si o actualizo
     */
    public boolean actualizarPersona(double cedulaa,double cedula, String nombre, int codigo, String telefono, String correo, int tipo  ){
        
        return a.actualizarPersona(cedulaa,cedula, nombre, codigo, telefono, correo, tipo);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para actualizar fundacion
     * @param id identificador de la fundacion
     * @param nit nit de la fundacion
     * @param nombre nombre de la fundacion
     * @param representante represntante de la fundacion
     * @param telefono telefono de la fundacion
     * @param direccion direccion de a fundacion
     * @param correo correo de la fundacion
     * @param des descripcion de la fundacion 
     * @return  true si actualizo, false si no actualizo
     */
    public boolean actualizarFundacion(int id,String nit, String nombre, double representante, String telefono, String direccion, String correo,String des){
        
        return a.actualizarFundacion(id,nit, nombre, representante, telefono, direccion, correo, des);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para actualizar convenio
     * @param id identificador del convenio antiguo
     * @param idConvenio nuevo identificador del convenio
     * @param nombre nombre del convenio
     * @param fecha_inicio fecha de inicio del convenio
     * @param fecha_fin fecha de fin del convenio
     * @param objetivo objetivo del convenio
     * @param estado estado del convenio
     * @param fundacion fundacion del convenio
     * @param Des descripcion del convenio
     * @return true si actualizo, false si no actualizo
     */
    
    public boolean actualizarConvenio(int id, int idConvenio, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, String fundacion, String Des){
        
        return a.actualizarConvenio(id, idConvenio, nombre, fecha_inicio, fecha_fin, objetivo, estado, fundacion, Des);
    }
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para actualizar proyecto
     * @param id identificador del proyecto
     * @param nombre nombre del proyecto
     * @param descripcion descripcion del proyecto
     * @param estado estado del proyecto
     * @param presupuesto presupuesto del proyecto
     * @param recursosGastados recursos gastados del proyecto
     * @param fecha_inicio fecha de inicio de proyecto
     * @param fecha_fin fecha de fin del proyecto
     * @param fundacion fundacion del proyecto
     * @return true si actualizo, false si no actualizo
     */
    public boolean actualizarProyecto(int id,String nombre, String descripcion, String estado, String fecha_inicio, String fecha_fin, String fundacion){
        
        return a.actualizarProyecto(id,nombre, descripcion, estado,  fecha_inicio, fecha_fin, fundacion);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para actualizar actividad
     * @param id identificador de la actividad
     * @param nombre nombre de la actividad
     * @param descripcion descripcion de la actividad
     * @param tipo tipo de la actividad
     * @param estado estado de la actividad
     * @param presupuesto presupuesto de la actividad
     * @param recursosGastados recursos gastados de la actividad
     * @param fecha_inicio fecha de inicio de la actividad
     * @param fecha_fin fecha fin de la actividad
     * @param evaluacion evaluacion de la actividad
     * @param coordinador coordinador de la actividad
     * @param proyecto proyecto de la actividad
     * @return true si actualizo, false si no actualizo
     */
    public boolean actualizarActividad( int id,String nombre, String descripcion, String tipo, String estado,  double presupuesto,double recursosGastados, String fecha_inicio, String fecha_fin, String evaluacion, double coordinador, int proyecto){
        
        return a.actualizarActividad(id,nombre, descripcion, tipo, estado, presupuesto,recursosGastados, fecha_inicio, fecha_fin, evaluacion, coordinador, proyecto);
        
    }
    
}

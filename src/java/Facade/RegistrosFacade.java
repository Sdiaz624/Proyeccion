/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Mundo.Registros;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase intermediaria entre la interfaz grafica y la logica del negocio para los metodos relacionados con registros
 * @author SDIAZ
 */
public class RegistrosFacade {
    
    private Registros r = new Registros();
    
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para registrar fundacion
     * @param nit nit de la fundacion
     * @param nombre nombre de la fundacion
     * @param representante represntante de la fundacion
     * @param telefono telefono de la fundacion
     * @param direccion direccion de a fundacion
     * @param correo correo de la fundacion
     * @param des descripcion de la fundacion 
     * @return registro exitoso si inserto en la base de datos, registro no exitoso de lo contrario
     * @throws SQLException errores de conexion a la base de datos, duplicado de llaves primarias, llaves foraneas no existentes
     */
    public String registrarFundacion(String nit, String nombre, double representante, String telefono, String direccion, String correo,String des ) throws SQLException {
        
        
        return r.registrarFundacion(nit, nombre, representante, telefono, direccion, correo,des);
        
    }
    
       
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para registrar convenio
     * @param idConvenio nuevo identificador del convenio
     * @param nombre nombre del convenio
     * @param fecha_inicio fecha de inicio del convenio
     * @param fecha_fin fecha de fin del convenio
     * @param objetivo objetivo del convenio
     * @param estado estado del convenio
     * @param fundacion fundacion del convenio
     * @param Des descripcion del convenio
     * @return registro exitoso si inserto en la base de datos, registro no exitoso de lo contrario
     */
    public String resgistrarConvenio(int idConvenio, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, String fundacion, String Des)throws ParseException{
        
        return r.resgistrarConvenio( idConvenio,  nombre,  fecha_inicio,  fecha_fin, objetivo,  estado,  fundacion,Des);
        
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para registrar Proyecto 
     * @param nombre nombre del proyecto
     * @param descripcion descripcion del proyecto
     * @param estado estado del proyecto
     * @param presupuesto presupuesto del proyecto
     * @param recursosGastados recursos gastados del proyecto
     * @param fecha_inicio fecha de inicio de proyecto
     * @param fecha_fin fecha de fin del proyecto
     * @param fundacion fundacion del proyecto
     * @return registro exitoso si inserto en la base de datos, registro no exitoso de lo contrario
     */
    public String registrarProyecto( String nombre, String descripcion, String estado, double presupuesto, double recursosGastados, String fecha_inicio, String fecha_fin, String fundacion){
        
        return r.registrarProyecto( nombre,  descripcion, estado,  presupuesto,  fecha_inicio,  fecha_fin, fundacion);
        
    }
    
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para registrar Actividad
     * @param nombre nombre de la actividad
     * @param descripcion descripcion de la actividad
     * @param tipo tipo de la actividad
     * @param estado estado de la actividad
     * @param presupuesto presupuesto de la actividad
     * @param fecha_inicio fecha de inicio de la actividad
     * @param fecha_fin fecha fin de la actividad
     * @param evaluacion evaluacion de la actividad
     * @param coordinador coordinador de la actividad
     * @param proyecto proyecto de la actividad
     * @return registro exitoso si inserto en la base de datos, registro no exitoso de lo contrario
     */
    public String registrarActividad( String nombre, String descripcion, String tipo, String estado,  double presupuesto, String fecha_inicio, String fecha_fin, String evaluacion, double coordinador, int proyecto){
        
        double recursosGastados =0;
        return r.registrarActividad( nombre,  descripcion, tipo,  estado,  recursosGastados,  presupuesto,  fecha_inicio,  fecha_fin, evaluacion, coordinador, proyecto);
   
    }
    
    /**
      * metodo intermediario entre la interfaz de usuario y la logica del negocio para Registrar persona
     * @param cedula cedula de la persona
     * @param nombre nombre de la persona
     * @param codigo codigo de la persona
     * @param telefono telefono de la persona
     * @param correo correo de la persona
     * @param tipo tipo de persona
     * @return registro exitoso si inserto en la base de datos, registro no exitoso de lo contrario
     */
    public String registrarPersona(double cedula, String nombre, int codigo, String telefono, String correo, int tipo  ){
   
        return r.registrarPersona(cedula, nombre, codigo, telefono, correo, tipo);
        
    }
  
    
    
}

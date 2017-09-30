/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Mundo.Consultas;

/**
 * Clase intermediaria entre la interfaz grafica y la logica del negocio para los metodos relacionados con consultas
 * @author SDIAZ
 */
public class ConsultasFacade {
    
   
    
    public String[][] cargarProyectoFundacion(int id){
        
        Consultas c = new Consultas();
        return c.TodosLosProyectosFundacion(id);
        
    }
    
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar si existe una persona y una fundacion
     * @param a identificador de actividad  
     * @return un vectro con todos los datoas de las personas que no estan en una actividad
     */
    public String[][] personasQueNoEstanEnActividad(int a){
        
        Consultas c = new Consultas ();
        return c.retornarPersonaQuenoestan(a);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar si existe una persona y una fundacion
     * @param nit identificador de la fundacion
     * @param cedula identificador de la cedula
     * @return true si no existen  los dos,false de lo contrario 
     */
    public boolean buscarFundacionCoordinador(String nit, double cedula){
        
        Consultas c= new Consultas();
        return c.fundacionycoordinador(nit, cedula);
        
        
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para cargar todas las personas d un tipo
     * @param id tipo de personas a buscar
     * @return un vector con el nombre y cedula de las personas del tipo buscado
     */
    public String[][] cargartipoPersonas(int id){
        
        Consultas c = new Consultas();
        return c.retornarTipoPersona(id);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para validar usuario
     * @param usuario que desea iniciar sesion
     * @param contraseña del usuario que desea iniciar sesion
     * @return true si inicia secion, false si no inicia sesion
     */
    public boolean iniciarSesion(String usuario, String contraseña){
        
        Consultas c = new Consultas();
        return c.iniciarSesion(usuario, contraseña);
    
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar todas las fundaciones
     * @return un vector con el nit y nombre de las fundaciones
     */
    public String [][] cargarFundaciones(){

        Consultas c = new Consultas();
        return c.todasLasFundaciones();
        
    }
     
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar todos los convenios
     * @return un vector con identificador y nombre de los convenios 
     */
    public String [][] cargarConvenios(){
         
        
        
         Consultas c = new Consultas();
         return c.todasLosConvenio();
        
    }
     
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar todos los proyectos
     * @return un vector con identificador y nombre de los proyectos
     */
    public String [][] cargarProyectos(){
        
        Consultas c = new Consultas();
        return c.TodosLosProyectos();
        
    }
    
   /**
    * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar todas las actividades de un proyecto
    * @param id identificador del proeycto
    * @return un vector con idntificador y nombre de las actividades de un proyecto
    */
    
    
    public String [][] cargarActividades(String id){
       
        Consultas c = new Consultas();
        return c.CargarActividadPRoyecto(id);
        
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar una fundacion
     * @param id identificador de una fundacion
     * @return un vector con todos los atributos de la fundacion
     */
    public String [] cargarFundacion(String id){
        
        Consultas c = new Consultas();
        return c.retornarFundacion(id);
    }
     
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar un convenio
     * @param id identificador del convenio
     * @return un vector con todos los atributos del convenio
     */
    public String []cargarConvenio(String id){
        
        Consultas c = new Consultas();
        return c.retornarConvenio(id);
        
    }
     
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar un proyecto
     * @param id identificador del proyecto
     * @return un vector con todos los atributos del proyecto
     */
    public String [] cargarProyecto(String id){
         
        Consultas c = new Consultas();
        return c.retornarProyecto(id);
    }

    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar un proyecto
     * @param id identificador del proyecto
     * @return un vector con todos los atributos del proyecto
     */
    public String [] RetornarPoyecto(String id){
        
        Consultas c = new Consultas();
        return c.retornarProyecto(id);
                
    }
    
    /**
     *  metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar una persona
     * @param id cedula de la persona
     * @return un vector con todos los atributos de la persona
     */
    public String[] RetornarPersona(double id){
        
        Consultas c = new Consultas();
        return c.retornarPersona(id);
        
    }
    
     /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar una fundacion
     * @param id identificador de una fundacion
     * @return un vector con todos los atributos de la fundacion
     */
    public String[] RetornarFundacion(String id){
        
        Consultas c = new Consultas();
        return c.retornarFundacion(id);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar un convenio
     * @param id identificador del convenio
     * @return un vector con todos los atributos del convenio
     */
    public String[] RetornarConvenio(String id){
        
        Consultas c = new Consultas();
        return c.retornarConvenio(id);
    }
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar una actividad
     * @param id identificador de la actividad
     * @return un vector con todos los atributos de la actividad
     */
    public String[] RetornarActividad(int id){
        
        Consultas c = new Consultas();
        return c.retornarActividad(id);
    }
    
    /**
     *  metodo intermediario entre la interfaz de usuario y la logica del negocio para consultar las personas en una actividad
     * @param id identificador de la actividad
     * @return informacion que retorna el mundo
     */
    public String[][] personasActividad(int id){
        
        Consultas c = new Consultas();
        return c.personasEnActividad(id);
        
    }
    
    /*
    
    */
    public String cargarPDF(String id){
        
        Consultas c = new Consultas();
        return c.rutaArchivo(id);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mundo;

import Dao.ActividadDao;
import Dao.ActividadPersonaDao;
import Dao.ConvenioDao;
import Dao.PersonaDao;
import Dao.ProyectoDao;
import Dto.Actividad;
import Dto.ActividadPersona;
import Dto.Persona;
import Dto.Proyecto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SDIAZ
 */
public class Operaciones {
    
    
    /**
     * Metodo encargado en asociar una persona a una actividad, busca una persona, busca una actividad, crea un objeto de tipo actividad persona y luego manda al dao correspondiente a insertar
     * @param actividad identificador de la actividad
     * @param persona identificador de la persona
     * @return ture si asocio la persona a la actividad, false si lo contrario
     */
    public boolean asociarPersonaActividad (int actividad, double[] personas){
        
        PersonaDao x= new PersonaDao();
        ActividadDao y = new ActividadDao();
        ActividadPersonaDao o = new ActividadPersonaDao();
        try {
            
            if(personas.length>0){
                
            for(int i =0;i<personas.length;i++){
            Persona p = x.obtenerPersona(personas[i]);
            Actividad a = y.retornarActividad(actividad);
            if(!p.equals(null)){
                if(!a.equals(null)){
                    ActividadPersona z = new ActividadPersona(p,a);
                    o.registrar(z);
                    
                }
            }
            }
            return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return false;   
    }
    
    /**
     * metodo encargado de imprimir el control de presupuesto de una fundacion y todo llevarlo a cadena
     * @param id idntificador de la fundacion
     * @return una cadena con todo lo relacionado a una fundacion
     */
    public String controlDePresupuesto(int id){
        
        ProyectoDao p = new ProyectoDao();
        ActividadDao a = new ActividadDao();
        
        String cadena="";
        try {
            ArrayList<Proyecto> pr =p.obtenerTodosProyectoFundacion(id);
            
            if(!pr.equals(null)){
                
                for(int i=0;i<pr.size();i++){
                    
                    ArrayList<Actividad> act =a.obtenerTodaslasActividades(pr.get(i).getId());
                    cadena+="PROYECTO   "+pr.get(i).getNombre()+","+pr.get(i).getPresupuesto()+","+pr.get(i).getRecursosGastados()+";";
                    if(!act.equals(null)){
                        
                        for(int j=0;j<act.size();j++){
                        
                        cadena+="ACTIVIDAD   "+act.get(j).getNombre()+","+act.get(j).getPresupuesto()+","+act.get(j).getRecursosGastados()+";";
                                
                        }
                        
                    }
                    
                }
                
                
            }
            
           return cadena;
            
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
     return null;
        
        
    }

    
    /**
     * metodo encargado a dar tratamientos a los datos para poder ser leidos en las vistas
     * @param id identificador fundacion
     * @return un vector con todos los datos de proyectos y actividades relacionados a una actividad
     */
    public String[][] controPresupuestoRe(int id){
        
        String cadena =this.controlDePresupuesto(id);
        
        
        if(!cadena.equals("")){
        
            
            String[] fila= cadena.split(";");
            String[][] de = new String [fila.length][3];
            int c=0;
                       
                for(int i=0;i<fila.length;i++){
                    
                    String [] z = fila[i].split(",");
                    
                    for(int w=0; w<z.length;w++){
                        
                        de[i][w]=z[w];
                        
                    }
                
                }
            
            return de;
        
        }
        
        return null;
    }
    
    /**
     * Metodo encargado en mostrar la evalacion de todas las actividades
     * @param id identificador de la fundacion 
     * @return una cadena;
     */
    public String controlDeEvaluacion(int id){
        
        ProyectoDao p = new ProyectoDao();
        ActividadDao a = new ActividadDao();
        
        String cadena="";
        try {
            ArrayList<Proyecto> pr =p.obtenerTodosProyectoFundacion(id);
            
            if(!pr.equals(null)){
                
                for(int i=0;i<pr.size();i++){
                    
                    double evaluacion=0;
                    ArrayList<Actividad> act =a.obtenerTodaslasActividades(pr.get(i).getId());
                    if(!act.equals(null)){
                        
                        for(int j=0;j<act.size();j++){
                        
                        cadena+="ACTIVIDAD  "+act.get(j).getNombre()+","+act.get(j).getEvaluacion()+";";
                        evaluacion+=Integer.parseInt(act.get(j).getEvaluacion());
                        
                        }
                    evaluacion=evaluacion/act.size();
                    cadena+="PROYECTO  "+pr.get(i).getNombre()+","+evaluacion+";";
                        
                    }
                    
                }
                
                
            }
         System.out.println(cadena);
           return cadena;
            
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
     return null;
        
        
    }

    
  /**
     * metodo encargado a dar tratamientos a los datos para poder ser leidos en las vistas
     * @param id identificador fundacion
     * @return un vector con todos los datos de proyectos y actividades relacionados a una actividad y su evaluacion
     */
    public String[][] controEvaluacion(int id){
        
        String cadena =this.controlDeEvaluacion(id);
        
        
        if(!cadena.equals("")){
        
            
            String[] fila= cadena.split(";");
            String[][] de = new String [fila.length][3];
            int c=0;
                       
                for(int i=0;i<fila.length;i++){
                    
                    String [] z = fila[i].split(",");
                    
                    for(int w=0; w<z.length;w++){
                        
                        de[i][w]=z[w];
                        
                    }
                
                }
            
            return de;
        
        }
        
        return null;
    }
    
    public void archivo(String archivo) {
        ConvenioDao o = new ConvenioDao();
        o.insertarRutaArchivo(archivo);
    }
}


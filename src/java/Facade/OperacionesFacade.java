/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Mundo.Operaciones;
import Mundo.crearPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase intermediaria entre la interfaz grafica y la logica del negocio para los metodos relacionados con operaciones
 * @author SDIAZ
 */
public class OperacionesFacade {
    
    private Operaciones o = new Operaciones();
    
    
    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para asociar una persona a una actividad
     * @param actividad identificador de la actividad
     * @param persona identficador de la persona
     * @return  true si asocio persona a actividad, false o contrario
     */
    public boolean asociarPersonaActividad(int actividad, double[] persona){
        
        return o.asociarPersonaActividad(actividad, persona);
        
    }

    /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para mostrar el presupuesto de una fundacion
     * @param id identificador de una fundacion
     * @return un vector con todas las actividades y proyectos relacionadas a una fundacion
     */
    public String [][] controlPresupuesto(int id){
        
        return o.controPresupuestoRe(id);
    }
    
     /**
     * metodo intermediario entre la interfaz de usuario y la logica del negocio para mostrar las evaluaciones de las actividades de una fundacion
     * @param id identificador de una fundacion
     * @return un vector con todas las actividades y proyectos relacionadas a una fundacion y su evaluacion
     */
    public String [][] controlEvaluacion(int id){
        
        return o.controEvaluacion(id);
    }
    
    public void CreafPdf(String id, Document d,String ruta,PdfWriter fd){
        
       crearPDF a= new crearPDF() ;
       a.setId_pdf(id);
       a.correr(d, ruta, fd);
        
    }
    
    public void archivo (String ubicacion){
        o.archivo(ubicacion);
    }
}

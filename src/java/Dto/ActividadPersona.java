/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

import java.sql.Date;

/**
 * Clase actividadPersona encargadas de crear relacion entrea personas y actividades
 * @author SDIAZ
 */
public class ActividadPersona {
    
    private Persona p;
    private Actividad a;
   
    /**
     * constructor vacio
     */
    public ActividadPersona() {
    }

    /**
     * constructor con paramtros
     * @param p persona 
     * @param a actividad
     * @param inicio fecha inicio
     * @param fin fecha fin
     */
    public ActividadPersona(Persona p, Actividad a) {
        this.p = p;
        this.a = a;
      
    }

    /**
     * sacar persona de persona actividad
     * @return persona de persona actividad
     */
    public Persona getP() {
        return p;
    }

    /**
     * editar persona de persona actividad
     * @param p nueva persona de persona actividad
     */
    public void setP(Persona p) {
        this.p = p;
    }

    /**
     * sacar Actividad de persona actividad
     * @return  Actividad de persona actividad
     */
    public Actividad getA() {
        return a;
    }

    /**
     * editar Actividad de persona actividad
     * @param a nueva Actividad de persona actividad
     */
    public void setA(Actividad a) {
        this.a = a;
    }

    /**
     * sacar fecha inicio actividad persona
     * @return fecha inicio actividad persona
     */
 
    
    
}

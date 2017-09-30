/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

import java.sql.Date;

/**
 * Clase actividad encargada de crear objetos de tipo actividad
 * @author SDIAZ
 */
public class Actividad {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String estado;
    private double recursosGastados;
    private double presupuesto;
    private String fecha_inicio;
    private String fecha_fin;
    private String evaluacion;
    private Persona coordinador;
    private Proyecto proyecto;
    
  
    /**
     * contructor vacio o por Default
     */
    public Actividad() {
    }

    /**
     * Constructor con parametros de actividad
     * @param id identificador de la actividad
     * @param nombre nombre de la actividad
     * @param descripcion descripcion de la actividad
     * @param tipo tipo de actividad
     * @param estado estado de la actividad
     * @param recursosGastados recursos gastados de la actividad
     * @param presupuesto presupuesto de la actividad
     * @param fecha_inicio fecha de inicio de la actividad
     * @param fecha_fin fecha de fin de la actividad
     * @param evaluacion Eavluacion de la actividad
     * @param coordinador coordinador de la actividad
     * @param proyecto Proyecto al qu pertenece la actividad
     */
    
    
    public Actividad(int id, String nombre, String descripcion, String tipo, String estado, double recursosGastados, double presupuesto, String fecha_inicio, String fecha_fin, String evaluacion, Persona coordinador, Proyecto proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.recursosGastados = recursosGastados;
        this.presupuesto = presupuesto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.evaluacion = evaluacion;
        this.coordinador = coordinador;
        this.proyecto = proyecto;
    }

    /**
     * sacar id
     * @return id actividad
     */
    public int getId() {
        return id;
    }

    /**
     * editar id actividad
     * @param id nuevo id actividad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sacar nombre actividad
     * @return nombre actividad
     */
    public String getNombre() {
        return nombre;
    }

    
    /**
     * editar nombre actividad
     * @param nombre nuevo nombre actividad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * sacar descripcion actividad
     * @return descripcion actividad
     */
    public String getDescripcion() {
        return descripcion;
    }

    
    /**
     * editar descripcion actividad
     * @param descripcion nueva descripcion actividad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * sacar tipo actividad
     * @return tipo actividad
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * editar tipo actividad
     * @param tipo nuevo tipo Actividad
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * sacar estado Actividad
     * @return estado actividad
     */    
    public String getEstado() {
        return estado;
    }

    /**
     * editar estado actividad
     * @param estado nuevo estado actividad
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    /**
     * sacar Recursos gastados actividad
     * @return recursos gastados actividad
     */
    
    public double getRecursosGastados() {
        return recursosGastados;
    }

    /**
     * editar recursos gasrados actividad
     * @param recursosGastados nuevo recursos gastados actividad
     */
    public void setRecursosGastados(double recursosGastados) {
        this.recursosGastados = recursosGastados;
    }

    /**
     * sacar presupuesto actividad
     * @return presupuesto actividad
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * editar presupuesto actividad
     * @param presupuesto nuevo presupuesto actividad
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * sacar fecha inicio actividad
     * @return fecha inicio actividad
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * editar fecha inicio actividad
     * @param fecha_inicio nueva fecha inicio actividad
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * sacar fecha fin actividad
     * @return fecha fin actividad
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * editar fecha fin actividad
     * @param fecha_fin nueva fecha fin actividad
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * sacar evaluacion actividad
     * @return evaluacion actividad
     */
    public String getEvaluacion() {
        return evaluacion;
    }

    /**
     * editar evaluacion actividad
     * @param evaluacion nueva evaluacion actividad
     */
    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * sacar coordinador activdad
     * @return coordinador actividad
     */
    public Persona getCoordinador() {
        return coordinador;
    }

    /**
     * editar coordnador actividad
     * @param coordinador nuevo coordinador actividad
     */
    public void setCoordinador(Persona coordinador) {
        this.coordinador = coordinador;
    }

    /**
     * sacar proyecto actividad
     * @return proyecto actividad
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * editar proyecto actividad
     * @param proyecto nuevo proyecto actividad
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    
}

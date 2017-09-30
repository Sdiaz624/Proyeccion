/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

import java.sql.Date;

/**
 * clase Proyecto encargada de generar objetos de tipo proyecto
 * @author SDIAZ
 */
public class Proyecto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private double presupuesto;
    private double recursosGastados;
    private String fecha_inicio;
    private String fecha_fin;
    private Fundacion fundacion;

    /**
     * constructor vacio
     */
    public Proyecto() {
    }

    /**
     * constructo con parametros
     * @param id identificador del proyecto
     * @param nombre nombre del proyecto
     * @param descripcion descripcion del proyecto
     * @param estado estado del proyecto
     * @param presupuesto presupuesto del proyecto 
     * @param recursosGastados recursos gastados en el proyecto
     * @param fecha_inicio fecha de inicio del proyecto
     * @param fecha_fin fecha de fin del proyecto
     * @param fundacion fundacion del proyecto
     */
    public Proyecto(int id, String nombre, String descripcion, String estado, double presupuesto, double recursosGastados, String fecha_inicio, String fecha_fin, Fundacion fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.recursosGastados = recursosGastados;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fundacion = fundacion;
    }

    /**
     * sacar identificador del proyecto
     * @return identificador del proyecto
     */
    public int getId() {
        return id;
    }

    /**
     * editar identificador del proyecto
     * @param id nuevo identificador del proyecto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * sacar nombre del proyecto
     * @return nombre del proyecto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * editar nombre del proyecto
     * @param nombre nuevo nombre del proyecto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * sacar descripcion del proyecto
     * @return descripcion del proyecto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * editar descripcion del proyecto
     * @param descripcion nuevo descripcion del proyecto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * sacar estado del proyecto
     * @return estado del proyecto
     */
    public String getEstado() {
        return estado;
    }

    /**
     * editar estado del proyecto
     * @param estado nuevo estado del proyecto
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Sacar presupesto del proyecto
     * @return presupesto del proyecto
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * editar presupesto del proyecto
     * @param presupuesto nuevo presupesto del proyecto
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * editar recursos gastados del proyecto
     * @return recursos gastados del proyecto 
     */
    public double getRecursosGastados() {
        return recursosGastados;
    }

    /**
     * editar recursos gastados del proyecto
     * @param recursosGastados nuevo recursos gastados del proyecto
     */
    public void setRecursosGastados(double recursosGastados) {
        this.recursosGastados = recursosGastados;
    }

    /**
     * sacar fecha de inicio del proyecto
     * @return fecha de inicio del proyecto
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * editar fecha de inicio del proyecto
     * @param fecha_inicio nuevo fecha de inicio del proyecto
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * sacar fecha de fin del proyecto
     * @return fecha de fin del proyecto
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * editar fecha de fin del proyecto
     * @param fecha_fin nueva fecha de fin del proyecto
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * sacar fundacion del proyecto
     * @return fundacion del proyecto
     */
    public Fundacion getFundacion() {
        return fundacion;
    }

    /**
     * editar fundacion del proyecto
     * @param fundacion nueva fundacion del proyecto
     */
    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }

    
    
}

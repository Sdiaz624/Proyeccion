/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

import java.sql.Date;

/**
 * Clase convenio encargada de crar objetos de tipo convenio
 * @author SDIAZ
 */
public class Convenio {

    private int id;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    private String objetivo;
    private String estado;
    private Fundacion fundacion;
    private String descripcion;

    /**
     * constructor vacio
     */
    public Convenio() {
    }

    
    /**
     * constructor con paramtros
     * @param id identificador del convenio
     * @param nombre nombre del convenio
     * @param fecha_inicio fecha de inicio del convenio
     * @param fecha_fin fecha de fin del convenio
     * @param objetivo objetivo del convenio
     * @param fundacion fundacion del convnio
     * @param descripcion descripcion del convenio
     */
    public Convenio(int id, String nombre, String fecha_inicio, String fecha_fin, String objetivo, Fundacion fundacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.objetivo = objetivo;
        this.fundacion = fundacion;
        this.estado="registrado";
        this.descripcion=descripcion;
    }
/**
 * contructor con parametros
 * @param id identificador de convenio
 * @param nombre nombre del convenio
 * @param fecha_inicio fecha de inicio del convenio
 * @param fecha_fin fecha de fin del convenio
 * @param objetivo objetivo del convenio
 * @param estado estado del convenio
 * @param fundacion fundacion del convenio
 * @param descripcion descripcion del convenio
 */
    
    public Convenio(int id, String nombre, String fecha_inicio, String fecha_fin, String objetivo, String estado, Fundacion fundacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.objetivo = objetivo;
        this.estado = estado;
        this.fundacion = fundacion;
        this.descripcion = descripcion;
    }

    /**
     * sacar descripcion del convenio
     * @return descripcion del convenio 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * editar descripcion del convenio
     * @param descripcion nueva descripcion del convenio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * sacar id del convenio
     * @return id del convenio
     */
    public int getId() {
        return id;
    }
    
    /**
     * editar id del convenio
     * @param id nuevo id del convenio
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * sacar nombre del convenio
     * @return nombre del convenio 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * editar nombre del convenio
     * @param nombre nuevo nombre del convenio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * sacar fecha inicio del convenio
     * @return fecha inicio del convenio 
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * editar fecha inicio del convenio
     * @param fecha_inicio nueva fecha inicio del convenio
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    /**
     * sacar fecha fin del convenio
     * @return fecha fin del convenio
     */

    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * editar fecha fin del convenio
     * @param fecha_fin fecha fin del convenio
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

   /**
    * sacar objetivo del convenio
    * @return objetivo del convenio 
    */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * editar objetivo del convenio
     * @param objetivo nuevo objetivo del convenio
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * sacar estado del convenio
     * @return estado del convenio 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * editar estado del convenio
     * @param estado nuevo estado del convenio
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * sacar fundacion del convenio
     * @return fundacion del convenio
     */
    public Fundacion getFundacion() {
        return fundacion;
    }
    
    /**
     * editar fundacion del convenio
     * @param fundacion nueva fundacion del convenio
     */

    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }
            
    
    
}

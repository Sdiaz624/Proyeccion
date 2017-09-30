/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

/**
 * Clase encargada de crear objetos de tipo fundacion
 * @author SDIAZ
 */
public class Fundacion {

    
    private int id;
    private String nit;
    private String nombre;
    private Persona represntante;
    private String telefono;
    private String direccion;
    private String correo;
    private String descripcion;

    /**
     * constructor vacio
     */
    public Fundacion() {
    }

    /**
     * constructor con parametros
     * @param id identificador la fundacion 
     * @param nit nit de la fundacion
     * @param nombre nombre de la fundacion
     * @param represntante representante de la fundacion
     * @param telefono telefono de la fundacion
     * @param direccion direccion de la fundacion
     * @param correo correo de a fundacion
     * @param descripcion descripcion de la fundacion
     */
    public Fundacion(int id, String nit, String nombre, Persona represntante, String telefono, String direccion, String correo, String descripcion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.represntante = represntante;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.descripcion = descripcion;
    }

    
    /**
     * sacar id de la fundacion
     * @return  id de la fundacion
     */
    public int getId() {
        return id;
    }
    
    /**
     * editar id de la fundacion
     * @param id nuevo id de la fundacion
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sacar el nit de la fundacion
     * @return  nit de la fundacion
     */
    public String getNit() {
        return nit;
    }

    /**
     * editar nit de la fundacion
     * @param nit nit de la fundacion
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * sacar el nombre de la fundacion
     * @return nombre de la fundacion
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * editar nombre de la fundacion
     * @param nombre nombre de la fundacion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * sacar el representante de la fundacion
     * @return representante de la fundacion
     */
    public Persona getRepresntante() {
        return represntante;
    }

    /**
     * editar representante de la fundacion
     * @param represntante representante de la fundacion
     */
    public void setRepresntante(Persona represntante) {
        this.represntante = represntante;
    }

    /**
     * Sacar el telefono de la fundacion
     * @return el telefono de la fundacion
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * editar el telefono de la fundacion
     * @param telefono el telefono de la fundacion
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * sacar la diraccion de la fundacion
     * @return diraccion de la fundacion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * editar diraccion de la fundacion
     * @param direccion diraccion de la fundacion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * sacar correo de la fundacion
     * @return correo de la fundacion
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * editar correo de la fundacion
     * @param correo correo de la fundacion
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * sacar descripcion de la fundacion
     * @return descripcion de la fundacion 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * editar descripcion de la fundacion
     * @param descripcion descripcion de la fundacion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

            
    
}

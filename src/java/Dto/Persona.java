/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

/**
 * Clase encargada de crear objetos de tipo persona
 * @author SDIAZ
 */
public class Persona {
   
    private double cedula;
    private int codigo;
    private String nombre;
    private String telefono;
    private String correo;
    private int tipo;

    /**
     * Consturctor vacio
     */
    public Persona() {
    }

    /**
     * Constructor con parametros
     * @param cedula de la persona
     * @param codigo de la persona
     * @param nombre de la persona
     * @param telefono de la persona
     * @param correo de la persona
     * @param tipo  de la persona
     */
    public Persona(double cedula, int codigo, String nombre, String telefono, String correo, int tipo) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
    }

    /**
     * sacar cedula de la persona
     * @return  cedula de la persona
     */
    public double getCedula() {
        return cedula;
    }

    /**
     * editar cedula de la persona
     * @param cedula cedula de la persona
     */
    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    /**
     * sacar codigo de la persona
     * @return codigo de la persona
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * editar codigo de la persona
     * @param codigo codigo de la persona
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * sacar nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * editar nombre de la persona
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * sacar telefono de la persona
     * @return telefono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * editar telefono de la persona
     * @param telefono telefono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * sacar correo de la persona
     * @return correo de la persona
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * editar correo de la persona
     * @param correo nuevo correo de la persona
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * sacar tipo de persona
     * @return tipo de persona
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * editar tipo de persona
     * @param tipo nuevo tipo de persona
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
   
    
    
            
    
}

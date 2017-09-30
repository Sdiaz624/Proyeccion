/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mundo;

import Dao.ActividadDao;
import Dao.ActividadPersonaDao;
import Dao.ConvenioDao;
import Dao.FundacionDao;
import Dao.PersonaDao;
import Dao.ProyectoDao;
import Dao.UsuarioDao;
import Dto.Actividad;
import Dto.ActividadPersona;
import Dto.Convenio;
import Dto.Fundacion;
import Dto.Persona;
import Dto.Proyecto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada en realizar la logica del negocio sobre consultas de la base de datos, se comunica con los dao de las entidades a consultar
 * @author SDIAZ
 */
public class Consultas {
    
    
    /**
     * Metodo encargado de llamar al dao correspondiente para consultar una fundacion por su nit
     * @param nit fundacion a consultar
     * @return la informacion que retorne el dao
     */
    public boolean BuscarFundacion(String nit){
       
        String msg;
        FundacionDao fu= new FundacionDao();
        try {
            return fu.consultarFundacion(nit);
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("no consulta");
        return false;
    }
    
    
    /**
     * Metodo encargado de llamar al dao correspondiente para consultar una fundacion por su nit, y un coordinador por su cdula
     * @param nit identificador de la fundacion
     * @param cedula identificador del coordinador
     * @return si los dos son true retorna true, cualquier otro caso false
     */
    public boolean fundacionycoordinador(String nit, double cedula){
        
        
        try {
            
            PersonaDao z = new PersonaDao();
            boolean a= this.BuscarFundacion(nit);
            boolean b= z.buscarPersona(cedula);
            
            
            if(a){
                
                if(b){
                   
                System.out.println("entraa");
                return true; 
                
                }
                
                return false;
            }
            
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Metodo encargado de llamar al dao correspondiente para consultar una fundacion por su nit
     * @param nit identificador de la fundacion
     * @return la informacion que retorne el dao
     */
    public Fundacion obtenerFundacion(String nit){
       
        
        FundacionDao fu= new FundacionDao();
        Fundacion f;
        try {
            f = fu.obtenerFundacion(nit);
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
    }
    
    
    /**
     * Metodo encargado de llamar al dao correspondiente para consultar un convenio por su id
     * @param nit identificador de el convenio
     * @return la informacion que retorne el dao
     */
    public boolean BuscarConvenio(int nit){
       
        String msg;
        ConvenioDao fu= new ConvenioDao();
        try {
            msg=fu.consultarConvenio(nit);
             if(msg.isEmpty()){
            return false;
        }
            return true;
        
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
    }
    
    
    /**
     * Metodo encargado de llamar al dao correspondiente para consultar una persona por su cedula
     * @param codigo identificador de la persona
     * @return la informacion que retorne el dao
     */
    public Persona obtenerPersona(double codigo){
        
        PersonaDao fu= new PersonaDao();
        Persona f;
        try {
            f = fu.obtenerPersona(codigo);
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
    }
    
    
    /**
     * metodo encargardo en validar la informacionde la base de datos, lo digitado por el usuario
     * @param usuario usuario a buscar en la base de datos
     * @param contraseña contraseña a comparar con de la base de datos
     * @return si son iguales los de la base de datos con los parametros recibidos retorna true de lo contrario false
     */
    public boolean iniciarSesion(String usuario, String contraseña){
        
        UsuarioDao u= new UsuarioDao();
        Seguridad s = new Seguridad();
        String usuarioEncriptado = s.Encriptar(usuario);
        String ContraseñaEncriptada= s.Encriptar(contraseña);
       
        try {
            String [] a= u.iniciarSesion(usuarioEncriptado);
            if(a!=null){
                if(a[1].equals(ContraseñaEncriptada)){
                    return true;
                }
                return false;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
        
    }
    
    
    /**
     * Metodo encargado de pedir todas las fundaciones al dao correspondiente
     * @return el nit y nombre de todas las fundaciones en una matriz
     */
    public String[][] todasLasFundaciones(){
        
        
        FundacionDao f = new FundacionDao();
        try {
            ArrayList<Fundacion> myFundacion= f.obtenerTodasFundaciones();
           
            if (!myFundacion.equals(null)){
                String [][] fundacion = new String [myFundacion.size()][2];
            
                
                for(int i=0; i<myFundacion.size();i++){
                
                fundacion[i][0]=String.valueOf(myFundacion.get(i).getId());
                fundacion[i][1]=myFundacion.get(i).getNombre();
            
                
                }
            return fundacion;
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    /**
     * Metodo encargado de pedir una fundacion al dao correspondiente
     * @param id identificador de la fundacion a buscar
     * @return un vector con todos los atriutos de la fundacion
     */
    public String[] retornarFundacion(String id){
        
        FundacionDao w= new FundacionDao();
        Fundacion f;
        try {
            f = w.obtenerFundacionporID(id);
            
            if(!f.equals(null)){
            
        String[] fundacion= new String [9];
        
        fundacion[0]=f.getNit();
        fundacion[1]=f.getNombre();
        fundacion[2]=f.getRepresntante().getNombre();
        fundacion[3]=f.getTelefono();
        fundacion[4]=f.getDireccion();
        fundacion[5]=f.getCorreo();
        fundacion[6]=f.getDescripcion();
        fundacion[7]=String.valueOf(f.getId());
        fundacion[8]=String.valueOf(f.getRepresntante().getCedula());
        
        
        return fundacion;
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return null;
    }
    
    /**
     * Metodo encargado de pedir un convenio al dao correspondinte
     * @param id identificador del convenio
     * @return un vector con todos los atributos del convenio
     */
    public String[] retornarConvenio(String id){
        
        ConvenioDao c = new ConvenioDao();
        int ij = Integer.parseInt(id);
        
        try {
            Convenio co= c.obtenerConvenio(ij);
            if(co.equals(null)){
                String[]con= new String[1];
                con[0]= "no exite convenio";
                return con;
            }else{
                
                String[]con= new String[9];
                con[0]=String.valueOf(co.getId());
                con[1]=co.getNombre();
                con[2]=String.valueOf(co.getFecha_inicio());
                con[3]=String.valueOf(co.getFecha_fin());
                con[4]=co.getObjetivo();
                con[5]=co.getEstado();
                con[6]=co.getFundacion().getNombre();
                con[7]=co.getDescripcion();
                con[8]=String.valueOf(co.getFundacion().getId());
                
                return con;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
        
    }
    
    /**
     * Metodo encargado de pedir al dao correspondiente todos los convenios 
     * @return una matriz con el id y l nombre de todos los convenios
     */
    public String[][] todasLosConvenio(){
        
        
        ConvenioDao f = new ConvenioDao();
        try {
            ArrayList<Convenio> myConvenio= f.obtenerTodosConvenio();
            if(!myConvenio.equals(null)){
                
                String [][] Convenio = new String [myConvenio.size()][2];
            
            for(int i=0; i<myConvenio.size();i++){
                
                Convenio[i][0]=String.valueOf(myConvenio.get(i).getId());
                Convenio[i][1]=myConvenio.get(i).getNombre();
            }
            
            return Convenio;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Metodo encargado de pedir al dao correspondiente todos los proyectos
     * @return una matriz con el id y el nombre de todos los proyectos
     */
    public String[][] TodosLosProyectos(){
        
         ProyectoDao f = new ProyectoDao();
        try {
            ArrayList<Proyecto> myProyecto= f.obtenerTodosProyecto();
            
            String [][] proyecto=null;
            
            if(!myProyecto.equals(null)){
                
                 proyecto = new String [myProyecto.size()][2];
            
            for(int i=0; i<myProyecto.size();i++){
                
                proyecto[i][0]=String.valueOf(myProyecto.get(i).getId());
                proyecto[i][1]=myProyecto.get(i).getNombre();
            }
            
            return proyecto;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    /**
     * Metodo encargado en pedir al dao correspondiente un proyecto por su id
     * @param id identificador del proyecto
     * @return un vector con todos los atributos de un proyecto
     */
    public String[] retornarProyecto(String id){
        
        ProyectoDao po = new ProyectoDao();
        int ij = Integer.parseInt(id);
        try {
            Proyecto p= po.obtenerProyecto(ij);
            if(!p.equals(null)){
                
                String [] lo= new String [10];
                
                lo[0]=String.valueOf(p.getId());
                lo[1]=String.valueOf(p.getFecha_inicio());
                lo[2]=String.valueOf(p.getFecha_fin());
                lo[3]=p.getEstado();
                lo[4]=p.getFundacion().getNombre();
                lo[5]=p.getNombre();
                lo[6]=String.valueOf(p.getPresupuesto());
                lo[7]=String.valueOf(p.getRecursosGastados());
                lo[8]=p.getDescripcion();
                lo[9]=String.valueOf(p.getFundacion().getId());
                
                return lo;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    /**
     * Metodo encargado en pedir al dao correspondiente todas las actividades de un proyecto
     * @param id identificador de un proyecto
     * @return  una matriz con el id y el nombre de todas las actividades
     */
    public String[][] CargarActividadPRoyecto(String id){
        
        ActividadDao f = new ActividadDao();
        int ij=Integer.parseInt(id);
        try {
            ArrayList<Actividad> myActividad= f.obtenerTodaslasActividades(ij);
            if(!myActividad.equals(null)){
                
                String [][] actividad = new String [myActividad.size()][2];
            
            for(int i=0; i<myActividad.size();i++){
                
                actividad[i][0]=String.valueOf(myActividad.get(i).getId());
                actividad[i][1]=myActividad.get(i).getNombre();
            }
            
            return actividad;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    /**
     * Metodo encargardo de pedir al dao correspondiente una actividad
     * @param id identificador de la actividad
     * @return un vector con todos los atributos de las actividades
     */
    public String [] retornarActividad(int id){
        
        ActividadDao po = new ActividadDao();
        
        try {
            Actividad p= po.retornarActividad(id);
            if(!p.equals(null)){
                
                String [] lo= new String [14];
                
                lo[0]=String.valueOf(p.getId());
                lo[1]=String.valueOf(p.getFecha_inicio());
                lo[2]=String.valueOf(p.getFecha_fin());
                lo[3]=p.getEstado();
                lo[5]=p.getNombre();
                lo[6]=String.valueOf(p.getPresupuesto());
                lo[7]=String.valueOf(p.getRecursosGastados());
                lo[8]=p.getDescripcion();
                lo[9]=p.getTipo();
                lo[10]=p.getEvaluacion();
                lo[13]=String.valueOf(p.getCoordinador().getCedula());
                lo[4]=p.getProyecto().getNombre();
                lo[12]=String.valueOf(p.getCoordinador().getCedula());
                lo[11]=String.valueOf(p.getCoordinador().getNombre());
                return lo;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    /**
     * Metodo encargado en pedir al dao correspondiente una persona por su cedula
     * @param cedula identificador de la persona
     * @return un vector con todos los atributos de la persona
     */
    public String [] retornarPersona(double cedula){
        
        PersonaDao po = new PersonaDao();
        try {
            Persona p= po.obtenerPersona(cedula);

            if(!p.equals(null)){
                
                String [] lo= new String [6];
                
                lo[0]=String.valueOf(p.getCedula());
                lo[1]=String.valueOf(p.getTipo());
                lo[2]=p.getCorreo();
                lo[3]=p.getTelefono();
                lo[4]=String.valueOf(p.getCodigo());
                lo[5]=p.getNombre();
                
                return lo;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Metodo encargado de pedirle a dao correspondiente buscar las personas de un tipo
     * @param id tipo de persona
     * @return una matriz con la cedula y el nombre de todas la personas de un tipo
     */
    public String[][] retornarTipoPersona(int id){
        System.out.print(id);
        PersonaDao c = new PersonaDao();
        try {
            ArrayList<Persona> l = c.obtenerTipoPersona(id);
            
            if(l!=null){
                
            String [][] z = new String [l.size()][2];
            
            for(int i=0; i<l.size();i++){
                
                z[i][0]=String.valueOf(l.get(i).getCedula());
                z[i][1]=l.get(i).getNombre();
                System.out.print("cedula =" + z[i][0] + "nombre=" + z[i][1] + "tipo="+id);
                
            }
            
            return z;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Metodo en cargado de pedir al dao indicado las personas que no pertenecen a una actividad
     * @param id identificador de actividad
     * @return una matriz con todas las personas que no estan en la actividad
     */
      public String[][] retornarPersonaQuenoestan(int id){
        
        ActividadPersonaDao c = new ActividadPersonaDao();
        ActividadDao s= new ActividadDao();
        
        try {
            
            boolean a = s.consultarActividad(id);
            if(a){
            ArrayList<Persona> l = c.personasNoActividas(id);
            
            if(!l.equals(null)){
                
            String [][] z = new String [l.size()][2];
            
            for(int i=0; i<l.size();i++){
                
                z[i][0]=String.valueOf(l.get(i).getCedula());
                z[i][1]=l.get(i).getNombre();
            }
            
            return z;
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Metodo encargado de retornar los valores de las personas en una actividad
     * @param a id actividad
     * @return una matriz con la cedula y nombre de las personas en la actividad
     */
    public String[][] personasEnActividad(int a){
        
        ActividadPersonaDao o = new ActividadPersonaDao();
        
        ActividadDao p = new ActividadDao();
        
        
        try {
            boolean esta;
            esta = p.consultarActividad(a);
            if(esta){
                
                ArrayList<ActividadPersona> listado = o.consultar(a);
                String [][] personas =null;
                if(!listado.isEmpty()){
                     personas=new String [listado.size()] [2];
                    
                    for(int i = 0; i< listado.size();i++){
                        
                        personas[i][0]=String.valueOf(listado.get(i).getP().getCedula());
                        personas[i][1]=listado.get(i).getP().getNombre();
                        
                    }
                    
                    return personas;
                }
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
        
    }
    
    
      /**
     * Metodo encargado de pedir al dao correspondiente todos los proyectos por fundacion
     * @return una matriz con el id y el nombre de todos los proyectos
     */
    public String[][] TodosLosProyectosFundacion(int id){
        
         ProyectoDao f = new ProyectoDao();
        try {
            ArrayList<Proyecto> myProyecto= f.obtenerTodosProyectoFundacion(id);
            if(!myProyecto.equals(null)){
                
                String [][] proyecto = new String [myProyecto.size()][2];
            
            for(int i=0; i<myProyecto.size();i++){
                
                proyecto[i][0]=String.valueOf(myProyecto.get(i).getId());
                proyecto[i][1]=myProyecto.get(i).getNombre();
            }
            
            return proyecto;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public String rutaArchivo(String id) {
        
        ConvenioDao o = new ConvenioDao();
        return o.sacarRutaArchivo(id);
    }
}

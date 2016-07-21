/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASeman;

/**
 *
 * @author Javier
 */
public class VariablesFunciones {
    String nombre;
    String funcion;
    public VariablesFunciones(){
        
    }
    public VariablesFunciones(String nombre, String funcion){
        this.nombre = nombre;
        this.funcion = funcion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFuncion(String funcion){
        this.funcion = funcion;
    }
     public String getNombre(){
        return nombre;
    }
    public String getFuncion(){
        return funcion;
    }
}

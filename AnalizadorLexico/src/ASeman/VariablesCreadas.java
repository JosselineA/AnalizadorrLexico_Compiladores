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
public class VariablesCreadas {
    String nombre;
    String tipo;
    
    public VariablesCreadas(){
        
    }
    public VariablesCreadas(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
}

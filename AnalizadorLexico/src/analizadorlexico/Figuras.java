/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

/**
 *
 * @author Javier
 */
public class Figuras {
    String nombre = "";
    String figura = "";
    int largo = 20;
    int ancho = 20;
    int posicionX = 0;
    int posicionY = 0;
    String colorInterior = "black";
    String colorBorde = "black";
    
    public Figuras(){
        
    }
    public Figuras(String nombre, String figura){
        this.nombre = nombre;
        this.figura = figura;
    }
     public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getFigura(){
        return figura;
    }
    public void setFigura(String figura){
        this.figura = figura;
    }
    
    public int getLargo(){
        return largo;
    }
    public void setLargo(int largo){
        this.largo = largo;
    }
    public int getAncho(){
        return ancho;
    }
    public void setAncho(int ancho){
        this.ancho= ancho;
    }
    public int getPosicionX(){
        return posicionX;
    }
    public void setPosicionX(int x){
        this.posicionX=x;
    }
    public int getPosicionY(){
        return posicionX;
    }
    public void setPosicionY(int y){
        this.posicionY=y;
    }
    public String getColorInterior(){
        return colorInterior;
    }
    public void setColorInterior(String colorInterior){
        this.colorInterior=colorT(colorInterior);
    }
     public String getColorBorde(){
        return colorBorde;
    }
    public void setColorBorde(String colorBorde){
        this.colorBorde=colorT(colorBorde);
    }
    private String colorT(String color){
    
                switch(color){
                    case "rojo":
                            return "red";
                    case "azul":
                            return "blue";
                    case "verde":
                        return "green";
                    case "amarillo":
                        return "yellow";
                    case "blanco":
                        return "white";
                    case "negro":
                        return "black";
                }
        return "black";
    }
    
    
}

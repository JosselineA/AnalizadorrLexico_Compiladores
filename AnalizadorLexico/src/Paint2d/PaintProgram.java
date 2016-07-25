/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint2d;

import analizadorlexico.Figuras;
import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Javier
 */
public class PaintProgram{

    ArrayList<Figuras> figurasCreadas;
    private GraphicsContext gcB;
    
    public PaintProgram( ArrayList<Figuras> figurasCreadas, Canvas TheCanvas){
        this.figurasCreadas = figurasCreadas;
        gcB = TheCanvas.getGraphicsContext2D();
        gcB.clearRect(0, 0, TheCanvas.getWidth(), TheCanvas.getHeight());
    }
    public void dibujar(){
        for (Figuras figurasCreada : figurasCreadas) {
            switch(figurasCreada.getFigura()){
            case "cuadrado":
                drawRect(
                        figurasCreada.getAncho(), 
                        figurasCreada.getAncho(),
                        figurasCreada.getColorInterior(),
                        figurasCreada.getColorBorde(),
                        figurasCreada.getPosicionX(), 
                        figurasCreada.getPosicionY()
                );
                break;
            case "rectangulo":
                drawRect(
                        figurasCreada.getAncho(), 
                        figurasCreada.getLargo(),
                        figurasCreada.getColorInterior(),
                        figurasCreada.getColorBorde(),
                        figurasCreada.getPosicionX(), 
                        figurasCreada.getPosicionY()
                );
                break;
            case "circulo":
                drawOval(
                        figurasCreada.getAncho(), 
                        figurasCreada.getLargo(),
                        figurasCreada.getColorInterior(),
                        figurasCreada.getColorBorde(),
                        figurasCreada.getPosicionX(), 
                        figurasCreada.getPosicionY()
                );
               break;
            case "triangulo":
               
                break;
            case "linea":
                drawLine(
                        figurasCreada.getAncho(),
                        figurasCreada.getAncho(),
                        figurasCreada.getColorBorde(),
                        figurasCreada.getPosicionX() ,
                        figurasCreada.getPosicionY()
                );
                break;
             
        }
        }
        
    }

    private void drawRect(int wh, int hg,String colorInterior,String colorBorde,int x,int y) {

        gcB.setLineWidth(2);

        gcB.setFill( Color.web(colorInterior));
        gcB.setStroke(Color.web(colorBorde));
        gcB.fillRect(x, y, wh, hg);
        gcB.strokeRect(x,y, wh, hg);
    }
    
    private void drawOval(int wh,int hg,String colorInterior,String colorBorde,int x,int y){
       
        gcB.setLineWidth(2);
        
            gcB.setFill(Color.web(colorInterior));
            gcB.setStroke(Color.web(colorBorde));
            gcB.fillOval(x, y, wh, hg);
            gcB.strokeOval(x, y, wh, hg);
        
    }
        private void drawLine(int wh,int hg,String colorBorde,int x,int y){
        gcB.setLineWidth(2);
        gcB.setStroke(Color.web(colorBorde));
        gcB.strokeLine(x,y,x+wh,y+hg);
    }

}

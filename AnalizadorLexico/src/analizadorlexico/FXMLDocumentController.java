/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import AS.AnalizadorSintactico;
import Paint2d.PaintProgram;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {
    
    ArrayList<Tokens> tokensAS = new ArrayList();
    boolean banderaErrorL = false;
    @FXML
    private Label label;
    @FXML Canvas canv;

      @FXML
    private TextArea entrada,resultado,ErroresSin;
      
    

    private void createLexFile(String path){
        File file = new File(path);
        jflex.Main.generate(file);
        System.out.println("creado");
    }
    @FXML
    private void creditos(ActionEvent event){
        Alert a = new Alert(AlertType.INFORMATION);
         a.setTitle("Creditos");
        a.setHeaderText("Universidad Politécnica de Chiapas");
       a.setContentText("Integrantes: \n Josseline Juliane Arreola Cruz \n Javier de Jesús Flores Herrera \n Hugo Sarmiento Toledo");
       a.showAndWait();
    }
    
    @FXML void clean(ActionEvent e){
        entrada.setText("");
        resultado.setText("");
    }
    
    @FXML
    private void accion(ActionEvent e){
        try {
            tokensAS = new ArrayList<Tokens>();
            probarLexerFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(!banderaErrorL){
            ErroresSin.setText("");
            AnalizadorSintactico as = new AnalizadorSintactico(tokensAS,ErroresSin);        
            as.S();
            PaintProgram pa = new PaintProgram(as.getFigurasCreadas(), canv);
            pa.dibujar();
        }
    }
   public void probarLexerFile() throws FileNotFoundException, IOException{
        File fichero = new File("fichero.txt");
        PrintWriter writer;
        try {
            writer = new  PrintWriter(fichero);
            writer.print(entrada.getText());
            writer.close();
        } catch (Exception ex) {
            
        }
        Reader reader;
        reader = new BufferedReader(new FileReader("fichero.txt"));
      Lexer lexer = new Lexer(reader);
        String Resultados="";
        String lex="";
        
        while (true) {            
            Token token = lexer.yylex();
            if(token ==null){
                Resultados = Resultados ;
                lex=lex;
                
                resultado.setText(Resultados);
                return;
                
            }
            switch(token){
                case ERROR:
                    Resultados = Resultados + "ERROR, sintaxís erronea \n";
                    banderaErrorL = true;
                    break;
                case Figura:
                case nuevo:
                case tamanoX:
                case tamanoY:
                case posicion:
                case borde:
                case eliminar:
                case fondo:
                case ID:
                case Color:
                case Numero:
                    Resultados = Resultados + "\nToken: "+token+" "+lexer.save+"\n";
                    lex = lex+token+"@codigo4321@"+lexer.save+"\n";
                    Tokens a = new Tokens();
                    a.token = token;
                    a.palabra = lexer.save;
                    tokensAS.add(a);
                    break;
                default:
                    Resultados = Resultados + "\nToken: "+token+"\n";
                    Tokens b = new Tokens();
                    b.token = token;
                    tokensAS.add(b);
                    break;
                    
                    
            }
            
            
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ErroresSin.setText("");
       String aux = "C:\\Users\\Javier\\Documents\\NetBeansProjects\\Cuatrimestre 6\\Compiladores\\AnalizadorrLexico_Compiladores\\AnalizadorLexico\\src\\analizadorlexico\\lexico.flex";
        createLexFile(aux);
    }    
    
}

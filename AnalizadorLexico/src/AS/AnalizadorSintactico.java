/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AS;

import ASeman.VariablesCreadas;
import ASeman.VariablesFunciones;
import analizadorlexico.Token;
import static analizadorlexico.Token.*;
import analizadorlexico.Tokens;
import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author Javier
 */
public class AnalizadorSintactico {

    ArrayList<Tokens> tokens;
    ArrayList<VariablesCreadas> variablesD = new ArrayList<VariablesCreadas>();
    VariablesFunciones variablesF = new VariablesFunciones();
    int index;
    TextArea s;
    String ErrorSemantico = "";
    String nombreF = "";
    public void setVariableD(String nombre,String tipo){
        VariablesCreadas vc = new VariablesCreadas(nombre,tipo);
        variablesD.add(vc);
        System.out.println("Nombre: "+nombre);
        System.out.println("Tipo: "+tipo);
    }
      public void setVariableF(String nombre,String funcion){
        variablesF = new VariablesFunciones(nombre,funcion);
        
    }
    
    public void checarVariableCreada(){
        System.out.println("Veri");
        boolean bandera = false;
        String tipo = "";
        for (int i = 0; i < variablesD.size(); i++) {
            System.out.println("If "+variablesD.get(i).getNombre() + " - "+variablesF.getNombre());
            if(variablesD.get(i).getNombre().equals(variablesF.getNombre())){
                bandera = true;
                tipo = variablesD.get(i).getTipo();
            }              
        }
        if(!bandera && ErrorSemantico.length() <1){
            ErrorSemantico = "Variable necesita ser creada";
            System.err.println("La Variable"+variablesF.getNombre()+" necesita ser creada");
        }
        //checar funciones "cuadrado"|"rectangulo"|"circulo"|"triangulo"|"linea"
         if( ErrorSemantico.length() < 1){
        switch(tipo){
            case "cuadrado":
                if(variablesF.getFuncion().equals("tamanoX")){
                    System.err.println("Funcion no relacionada para la variable " +variablesF.getNombre());
                    ErrorSemantico = "La funcion no es valida para un cuadrado. Variable: "+variablesF.getNombre();
                }
                break;
            case "rectangulo":
                
            case "circulo":
               
            case "triangulo":
                if(variablesF.getFuncion().equals("tamanoY")){
                    System.err.println("Funcion no relacionada para la variable " +variablesF.getNombre());
                    ErrorSemantico = "La funcion no es valida para un triangulo. Variable: "+variablesF.getNombre();
                }
                break;
            case "linea":
                if(variablesF.getFuncion().equals("tamanoX")){
                    System.err.println("Funcion no relacionada para la variable " +variablesF.getNombre());
                    ErrorSemantico = "La funcion no es valida para una linea. Variable: "+variablesF.getNombre();
                }else if(variablesF.getFuncion().equals("borde")){
                    ErrorSemantico = "La funcion no es valida para una linea. Variable: "+variablesF.getNombre();
                }
                break;
             
        }
         }
    }

    
    public AnalizadorSintactico(ArrayList<Tokens> tokens, TextArea s) {
        this.tokens = tokens;
        index = 0;
        this.s = s;
    }
  public void S(){
      ErrorSemantico = "";
    variablesD = new ArrayList<VariablesCreadas>();
    variablesF = new VariablesFunciones(); 
      
             if(tokens.isEmpty())
                 s.setText("Se esperaba identificador");
          s.setStyle("-fx-text-fill:red;" );
                crear();
                R();
               
       
        
    }
    public void R() {
        crear();
                InicioFuncion();
                
                if(!tokens.isEmpty())
                    R();
                else{
                    
                    if("".equals(s.getText()) && ErrorSemantico.length()<1){
                        s.setText("Sintaxis correcta");
                         s.setStyle("-fx-text-fill:black;" );
                         //Fin del programa
                         
                         //Analizador semantico
                         
                         
                    }else{
                        s.setText(ErrorSemantico);
                    }
                }
                    
    }

    public void crear() {
        String nombre = "";
        try {
            if (tokens.get(0).token == ID) {
                nombre =tokens.get(0).palabra+"";   
                System.out.println("Nombre2;" +nombre);
                try {
                    if (tokens.get(1).token == igual) {
                        tokens.remove(0);
                        tokens.remove(0);
                        try {
                            if (tokens.get(0).token== nuevo) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(0).token== Figura) {
                                        setVariableD(nombre,tokens.get(0).palabra+"" );
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(0).token== PI) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(0).token== PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(0).token== PC) {
                                                                tokens.remove(0);
                                                                
                                                            } else {
                                                                tokens = new ArrayList<Tokens>();
                                                                
                                                                s.setText("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Tokens>();
                                                            s.setText("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Tokens>();
                                                        s.setText("Se esperaba un parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Tokens>();
                                                    s.setText("Se esperaba un parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba una parentesis izquierdo ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba un parentesis izquierdo");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba una figura ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba una figura ");
                                }
                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba palabra reservada nuevo");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba palabra reservada nuevo");
                        }
                    } else {
                        try{
                        if(tokens.get(1).token != Punto){
                             tokens = new ArrayList<Tokens>();// 
                       s.setText("Se esperaba palabra reservada igual o punto");
                       
                        }
                        }catch(Exception e){
                              s.setText("Se esperaba palabra reservada igual o punto");
                        }
                        
                      
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();//
                    s.setText("Se esperaba palabra reservada igual o punto");
                }
             } else {

            }
        } catch (Exception e) {
            
        }
                
    }

    public void InicioFuncion() {
       nombreF = "";
        try {
            if (tokens.get(0).token== ID) {
                nombreF = tokens.get(0).palabra+"";
               
                tokens.remove(0);
                try {
                    if (tokens.get(0).token== Punto) {
                        tokens.remove(0);
                        funciones();
                    } else {
                        if(tokens.get(0).token== igual){
                            tokens.add(0,new Tokens(ID));
                            crear();
                            return;
                        }
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba punto ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba punto ");
                }
            } else {
                tokens = new ArrayList<Tokens>();
                s.setText("Se esperaba identificador ");
            }
        } catch (Exception e) {
            //vacio
        }
    }

    public void funciones() {
        tamanoY();
        
    }

    public void tamanoY() {

        try {
            if (tokens.get(index).token == tamanoY) {
                setVariableF(nombreF,"tamanoY"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index).token == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index).token == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba parentesis derecho ");
                                }
                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
                tamanoX();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada ");
        }

    }

    public void tamanoX() {

        try {
            if (tokens.get(index).token == tamanoX) {
                setVariableF(nombreF,"tamanoX"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index).token == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index).token == Coma) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == Numero) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(index).token == PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(index).token == PC) {
                                                                tokens.remove(0);

                                                            } else {
                                                                tokens = new ArrayList<Tokens>();
                                                                s.setText("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Tokens>();
                                                            s.setText("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Tokens>();
                                                        s.setText("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Tokens>();
                                                    s.setText("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba entero ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba  coma ");
                                }

                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
                posicion();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada ");
        }

    }

    public void posicion() {

        try {
            if (tokens.get(index).token == posicion) {
                setVariableF(nombreF,"posicion"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index).token == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index).token == Coma) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == Numero) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(index).token == PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(index).token == PC) {
                                                                tokens.remove(0);

                                                            } else {
                                                                tokens = new ArrayList<Tokens>();
                                                                s.setText("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Tokens>();
                                                            s.setText("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Tokens>();
                                                        s.setText("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Tokens>();
                                                    s.setText("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba entero ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba  coma ");
                                }

                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
               color();

            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada  ");
        }

    }

    public void color() {

        try {
            if (tokens.get(index).token == fondo) {
                setVariableF(nombreF,"fondo"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index).token == Color) {
                                tokens.remove(0);

                                try {
                                    if (tokens.get(index).token == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba parentesis derecho ");
                                }

                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba color ");
                        }
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
                        colorB();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada  ");
        }

    }
    
    public void colorB() {

        try {
            if (tokens.get(index).token == borde) {
                setVariableF(nombreF,"borde"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index).token == Color) {
                                tokens.remove(0);

                                try {
                                    if (tokens.get(index).token == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba parentesis derecho ");
                                }

                            } else {
                                tokens = new ArrayList<Tokens>();
                                s.setText("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Tokens>();
                            s.setText("Se esperaba color ");
                        }
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
                eliminar();
            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada  ");
        }

    }
    
    public void eliminar() {

        try {
            if (tokens.get(index).token == eliminar) {
                setVariableF(nombreF,"eliminar"); //--
                checarVariableCreada();
                tokens.remove(0);
                try {
                    if (tokens.get(index).token == PI) {
                        tokens.remove(0);
                       
                                try {
                                    if (tokens.get(index).token == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index).token == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Tokens>();
                                                s.setText("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Tokens>();
                                            s.setText("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Tokens>();
                                        s.setText("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Tokens>();
                                    s.setText("Se esperaba parentesis derecho ");
                                }

                            
                    } else {
                        tokens = new ArrayList<Tokens>();
                        s.setText("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Tokens>();
                    s.setText("Se esperaba parentesis izquierdo ");
                }
            } else {
                tokens = new ArrayList<Tokens>();
                s.setText("Se esperaba palabra reservada  ");
            }
        } catch (Exception e) {
            tokens = new ArrayList<Tokens>();
            s.setText("Se esperaba palabra reservada");
        }

    }

  
}

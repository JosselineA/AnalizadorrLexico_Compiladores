/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AS;

import analizadorlexico.Token;
import static analizadorlexico.Token.*;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class AnalizadorSintactico {

    ArrayList<Token> tokens;
    int index;

    public AnalizadorSintactico(ArrayList<Token> tokens) {
        this.tokens = tokens;
        index = 0;
    }
  public void S(){

        
                crear();
                R();
               
       
        
    }
    public void R() {
        crear();
                InicioFuncion();
                
                if(!tokens.isEmpty())
                    R();
    }

    public void crear() {
        try {
            if (tokens.get(0) == ID) {
                
                try {
                    if (tokens.get(1) == igual) {
                        tokens.remove(0);
                        tokens.remove(0);
                        try {
                            if (tokens.get(0) == nuevo) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(0) == Figura) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(0) == PI) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(0) == PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(0) == PC) {
                                                                tokens.remove(0);
                                                                
                                                            } else {
                                                                tokens = new ArrayList<Token>();
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Token>();
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Token>();
                                                        System.err.println("Se esperaba un parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Token>();
                                                    System.err.println("Se esperaba un parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba una parentesis izquierdo ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba un parentesis izquierdo");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba una figura ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba una figura ");
                                }
                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba palabra reservada nuevo");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba palabra reservada nuevo");
                        }
                    } else {
                        try{
                        if(tokens.get(1) != Punto){
                             tokens = new ArrayList<Token>();// 
                       System.err.println("Se esperaba palabra reservada igual");
                       
                        }
                        }catch(Exception e){
                              System.err.println("Se esperaba palabra reservada igual");
                        }
                        
                      
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();//
                    System.err.println("Se esperaba palabra reservada igual");
                }
             } else {

            }
        } catch (Exception e) {
        }
                
    }

    public void InicioFuncion() {
       
        try {
            if (tokens.get(0) == ID) {
                tokens.remove(0);
                try {
                    if (tokens.get(0) == Punto) {
                        tokens.remove(0);
                        funciones();
                    } else {
                        if(tokens.get(0) == igual){
                            tokens.add(0,ID);
                            crear();
                            return;
                        }
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba punto ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba punto ");
                }
            } else {
                tokens = new ArrayList<Token>();
                System.err.println("Se esperaba identificador ");
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
            if (tokens.get(index) == tamanoY) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index) == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index) == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba parentesis derecho ");
                                }
                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                tamanoX();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada ");
        }

    }

    public void tamanoX() {

        try {
            if (tokens.get(index) == tamanoX) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index) == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index) == Coma) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == Numero) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(index) == PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(index) == PC) {
                                                                tokens.remove(0);

                                                            } else {
                                                                tokens = new ArrayList<Token>();
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Token>();
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Token>();
                                                        System.err.println("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Token>();
                                                    System.err.println("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba entero ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba  coma ");
                                }

                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                posicion();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada ");
        }

    }

    public void posicion() {

        try {
            if (tokens.get(index) == posicion) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index) == Numero) {
                                tokens.remove(0);
                                try {
                                    if (tokens.get(index) == Coma) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == Numero) {
                                                tokens.remove(0);
                                                try {
                                                    if (tokens.get(index) == PD) {
                                                        tokens.remove(0);
                                                        try {
                                                            if (tokens.get(index) == PC) {
                                                                tokens.remove(0);

                                                            } else {
                                                                tokens = new ArrayList<Token>();
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            tokens = new ArrayList<Token>();
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        tokens = new ArrayList<Token>();
                                                        System.err.println("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    tokens = new ArrayList<Token>();
                                                    System.err.println("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba entero ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba  coma ");
                                }

                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
               color();

            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada  ");
        }

    }

    public void color() {

        try {
            if (tokens.get(index) == fondo) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index) == Color) {
                                tokens.remove(0);

                                try {
                                    if (tokens.get(index) == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba color ");
                        }
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                        colorB();
        
            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada  ");
        }

    }
    
    public void colorB() {

        try {
            if (tokens.get(index) == borde) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                        try {
                            if (tokens.get(index) == Color) {
                                tokens.remove(0);

                                try {
                                    if (tokens.get(index) == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            } else {
                                tokens = new ArrayList<Token>();
                                System.err.println("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            tokens = new ArrayList<Token>();
                            System.err.println("Se esperaba color ");
                        }
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                eliminar();
            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada  ");
        }

    }
    
    public void eliminar() {

        try {
            if (tokens.get(index) == eliminar) {
                tokens.remove(0);
                try {
                    if (tokens.get(index) == PI) {
                        tokens.remove(0);
                       
                                try {
                                    if (tokens.get(index) == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == PC) {
                                                tokens.remove(0);

                                            } else {
                                                tokens = new ArrayList<Token>();
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            tokens = new ArrayList<Token>();
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        tokens = new ArrayList<Token>();
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    tokens = new ArrayList<Token>();
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            
                    } else {
                        tokens = new ArrayList<Token>();
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    tokens = new ArrayList<Token>();
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                tokens = new ArrayList<Token>();
                System.err.println("Se esperaba palabra reservada  ");
            }
        } catch (Exception e) {
            tokens = new ArrayList<Token>();
            System.err.println("Se esperaba palabra reservada");
        }

    }

  
}

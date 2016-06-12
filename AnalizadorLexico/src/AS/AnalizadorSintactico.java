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
                InicioFuncion();
                 if(!tokens.isEmpty())
                    S();
           
       
        
    }
  /*  public void S() {
        R();
    }
*/
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
                                                                S();
                                                            } else {
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        System.err.println("Se esperaba un parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    System.err.println("Se esperaba un parentesis derecho ");
                                                }
                                            } else {
                                                System.err.println("Se esperaba una parentesis izquierdo ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba un parentesis izquierdo");
                                        }
                                    } else {
                                        System.err.println("Se esperaba una figura ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba una figura ");
                                }
                            } else {
                                System.err.println("Se esperaba palabra reservada nuevo");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba palabra reservada nuevo");
                        }
                    } else {
                       // System.err.println("Se esperaba palabra reservada igual");
                    }
                } catch (Exception e) {
                    //System.err.println("Se esperaba palabra reservada igual");
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
                    } else {
                        System.err.println("Se esperaba punto ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba punto ");
                }
            } else {
                System.err.println("Se esperaba identificador ");
            }
        } catch (Exception e) {
            //vacio
        }
    }

    public void funciones() {
        tamanoY();
        tamanoX();
        posicion();
        color();
        colorB();
        eliminar();
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
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba parentesis derecho ");
                                }
                            } else {
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } /*else {
                System.err.println("Se esperaba palabra reservada tamanoY ");
            }*/
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada tamanoY ");
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
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        System.err.println("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    System.err.println("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                System.err.println("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba entero ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba  coma ");
                                }

                            } else {
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } /*else {
                System.err.println("Se esperaba palabra reservada tamanoX ");
            }*/
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada tamanoX ");
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
                                                                System.err.println("Se esperaba punto y coma ");
                                                            }
                                                        } catch (Exception e) {
                                                            System.err.println("Se esperaba punto y coma ");
                                                        }
                                                    } else {
                                                        System.err.println("Se esperaba parentesis derecho ");
                                                    }
                                                } catch (Exception e) {
                                                    System.err.println("Se esperaba parentesis derecho ");
                                                }
                                            } else {
                                                System.err.println("Se esperaba  entero ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba entero ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba  coma ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba  coma ");
                                }

                            } else {
                                System.err.println("Se esperaba entero ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba entero ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            }/* else {
                System.err.println("Se esperaba palabra reservada posicion ");
            }*/
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada posicion ");
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
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            } else {
                                System.err.println("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba color ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            }/* else {
                System.err.println("Se esperaba palabra reservada fondo ");
            }*/
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada fondo ");
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
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            } else {
                                System.err.println("Se esperaba color ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba color ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            }/* else {
                System.err.println("Se esperaba palabra reservada borde ");
            }*/
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada borde ");
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
                            if (tokens.get(index) == Figura) {
                                tokens.remove(0);

                                try {
                                    if (tokens.get(index) == PD) {
                                        tokens.remove(0);
                                        try {
                                            if (tokens.get(index) == PC) {
                                                tokens.remove(0);

                                            } else {
                                                System.err.println("Se esperaba punto y coma ");
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Se esperaba punto y coma ");
                                        }
                                    } else {
                                        System.err.println("Se esperaba parentesis derecho ");
                                    }
                                } catch (Exception e) {
                                    System.err.println("Se esperaba parentesis derecho ");
                                }

                            } else {
                                System.err.println("Se esperaba figura ");
                            }
                        } catch (Exception e) {
                            System.err.println("Se esperaba figura ");
                        }
                    } else {
                        System.err.println("Se esperaba parentesis izquierdo ");
                    }
                } catch (Exception e) {
                    System.err.println("Se esperaba parentesis izquierdo ");
                }
            } else {
                System.err.println("Se esperaba palabra reservada eliminar ");
            }
        } catch (Exception e) {
            System.err.println("Se esperaba palabra reservada eliminar ");
        }

    }

  
}

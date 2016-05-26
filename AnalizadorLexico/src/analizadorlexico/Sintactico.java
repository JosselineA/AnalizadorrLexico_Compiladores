/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.util.ArrayList;

/**
 *
 * @author W8
 */
public class Sintactico {
    ArrayList tokens = new ArrayList();
    public void setTokens(String resultado){
        String[] res=resultado.split("\n");
        int c=0;
        boolean b=false;
        String tipo="";
        String iden="";
        System.out.println(res.length);
        for (int i=0; i<res.length;i++){
            System.out.println("TOKEN: "+i+ " "+ res[i]);
            String div[]=res[i].split("@codigo4321@");
        tipo= div[0];
        b=paquete(tipo);
        
        System.out.println("Tipo: "+tipo);
        iden= div[1];
        System.out.println("Ident: "+ iden);
        c=div.length;
        }
        
        if(b==false){
            System.out.println("Error de sintaxis");
        }else{
            System.out.println("ok");
        }
        System.out.println(b);
        
        System.out.println(c);
    }
    
    public boolean paquete(String tipo){
        if (tipo.equals("paquete")|| tipo.equals("importar")){
            return true;
        }else{
            return clase(tipo);
        } 
    }
    
    public boolean clase(String tipo){
        if (tipo.equals("clase")){
           return true;
        }
            return false;   
    }
    
   
}

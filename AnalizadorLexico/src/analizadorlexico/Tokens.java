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
public class Tokens {
    public Token token;
    public String palabra = "";
    
    public Tokens(){
        
    }
    public Tokens(Token token){
        this.token  = token;
    }
}

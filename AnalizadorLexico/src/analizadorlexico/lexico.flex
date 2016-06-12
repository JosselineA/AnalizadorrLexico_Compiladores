package analizadorlexico;
import static analizadorlexico.Token.*;
%%
%class Lexer
%type Token
L=[a-zA-Z_]
D=[0-9]
white=[ \t\r\n]
color = "rojo"|"azul"|"verde"|"amarillo"|"blanco"|"negro"
figuras= "cuadrado"|"rectangulo"|"circulo"|"triangulo"|"linea"
%{
    public String save;
%}
%%
<YYINITIAL> {color} {save = yytext(); return Color;}
<YYINITIAL> {figuras} {save = yytext(); return Figura;}
<YYINITIAL> nuevo {save = yytext(); return nuevo;}
<YYINITIAL> tamanoX {save = yytext(); return tamanoX;}
<YYINITIAL> tamanoY {save = yytext(); return tamanoY;}
<YYINITIAL> posicion {save = yytext(); return posicion;}
<YYINITIAL> fondo {save = yytext(); return fondo;}
<YYINITIAL> borde {save = yytext(); return borde;}
<YYINITIAL> eliminar {save = yytext(); return eliminar;}
<YYINITIAL>{
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
";" {return PC;}
"=" {return igual;}
"(" {return PI;}
")" {return PD;}
"." {return Punto;}
"," {return Coma;}
["'!''¡'"]?{D}+[.] {D}+ {save = yytext(); return Numero;}
["'!''¡'"]?{D}+ {save = yytext(); return Numero;}

{L} ({L}|{D})* {save = yytext();return ID;}
. {return ERROR;}
}






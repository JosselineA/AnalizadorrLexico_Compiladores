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
<YYINITIAL> nuevo {save = yytext(); return PR;}
<YYINITIAL> tamano {save = yytext(); return PR;}
<YYINITIAL> posicion {save = yytext(); return PR;}
<YYINITIAL> fondo {save = yytext(); return PR;}
<YYINITIAL> borde {save = yytext(); return PR;}
<YYINITIAL> eliminar {save = yytext(); return PR;}
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






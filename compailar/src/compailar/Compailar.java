/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compailar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS H310
 */
public class Compailar {
      
   static enum TokenType{keyWord,number,idinty,opplus,oppminus,oppmul,oppdiv,oppEQ,opppower,LPAREN,RPAREN};
   static class Token
   {
       String s;
       TokenType t;

        public Token(String s,TokenType t) {
        this.s = s;
        this.t = t;
        }  
   }
    /**
     * @param args the command line arguments
     */
   static ArrayList<Token>  Tokens = new ArrayList<Token>();
   
    public static void main(String[] args) throws FileNotFoundException {
        
        boolean isHavaValue = false;
        File file=new File("C:\\Users\\Abd Alrahim Shalar\\Desktop\\test.txt");
        Scanner sc = new Scanner(file);
       Lexical lexicl=new Lexical();
        List<IdintyTable> idtable=new ArrayList<IdintyTable>();
     while (sc.hasNextLine()) {
         lexicl.LineNumber++;
        lexicl.FullText = sc.nextLine()+"\n";
        lexicl.FullText = lexicl.DeleteComment(lexicl.FullText);
        isHavaValue =false;
        String value = "";
        String name = "";
     while (!lexicl.FullText.isEmpty()){
         lexicl.isFloat =false;
      String text = (lexicl.getOneToken(lexicl.FullText)).toLowerCase();
        // System.out.println("Spliting text is : "+text);
      
         if(lexicl.iskeyword(text)){
             System.out.println("line number ["+lexicl.LineNumber+"]"+" key Word : "+text);
             Tokens.add(new Token(text, TokenType.keyWord));
         }
        else if(lexicl.isoper(text))
        {
            System.out.println("line number ["+lexicl.LineNumber+"]"+" "+lexicl.getOper(text)+" : "+text);
        switch(text)
        {
            case "opplus" :  Tokens.add(new Token(text, TokenType.opplus));break;
            case "oppminus" : Tokens.add(new Token(text, TokenType.oppminus));break;
            case "oppmul" : Tokens.add(new Token(text, TokenType.oppmul));break;
            case "oppdiv" : Tokens.add(new Token(text, TokenType.oppdiv));break;
            case "oppEQ" : Tokens.add(new Token(text, TokenType.oppEQ));break;
            case "opppower" :Tokens.add(new Token(text, TokenType.opppower));break;
            case "LPAREN" :Tokens.add(new Token(text, TokenType.LPAREN));break;
            case "RPAREN" : Tokens.add(new Token(text, TokenType.RPAREN));break;                  
        }
            
            Tokens.add(new Token(text, TokenType.oppEQ));
        }
        else if(lexicl.isDigit(text) && !lexicl.isFloat)
        {
            System.out.println("line number ["+lexicl.LineNumber+"]"+" Integer Number  : "+text);
            if(isHavaValue)value = text;
            Tokens.add(new Token(text, TokenType.number));
        }
        else if(lexicl.isDigit(text) &&  lexicl.isFloat)
        {
            System.out.println("line number ["+lexicl.LineNumber+"]"+" Real Number  : "+text);
             if(isHavaValue)value = text;
             Tokens.add(new Token(text, TokenType.number));
        }                                                                            
         else if(lexicl.isidinty(text))
         {
             System.out.println("line number ["+lexicl.LineNumber+"]"+" idinty  : "+text);
             Tokens.add(new Token(text, TokenType.idinty));
             isHavaValue = true;
             name = text;
         }
         
          /*switch(text){
             case "out": System.out.println("["+lexicl.LineNumber+"]"+" key Word : "+lexicl.Out(lexicl.FullText));break;
                 default: continue;
         }
         break;
         }*/
     }
     if(!name.isEmpty())
     {
        IdintyTable id1=new IdintyTable(name, value);
            idtable.add(id1);
            System.out.println(id1.name+" hava vlaue : "+id1.value+" AND FORMAT IS : "+id1.isFormat+" , is Delecate is :"+id1.isDelecate); 
     }
     }
     Syntax sy=new Syntax();
     sy.syntaxVar(Tokens);
    }     
}
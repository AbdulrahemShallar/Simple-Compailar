/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compailar;

import java.util.ArrayList;

/**
 *
 * @author Abd Alrahim Shalar
 */
public class Syntax {
    
    static void syntaxVar(ArrayList<Compailar.Token> t)
   {
       for (int i = 0; i < t.size() - 1; i++) {
           if(t.get(i).t == Compailar.TokenType.keyWord && t.get(i).s.equalsIgnoreCase("var"))
           { i++;
               if(t.get(i).t == Compailar.TokenType.idinty)
               {
                   i++;
                   if(t.get(i).t == Compailar.TokenType.oppEQ)
                   {
                       i++;
                       if(t.get(i).t == Compailar.TokenType.number)
                       {
                           System.out.println("Variable name is : "+t.get(i-2).s+"\nValue for it is : "+t.get(i).s);
                       }
                   }
               }
           }
       }
   }
}

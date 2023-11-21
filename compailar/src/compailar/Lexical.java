/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compailar;
import java.util.*;
  
public class Lexical {
    public static enum Type {
        LPAREN, RPAREN, ATOM,opplus,oppminus,oppdiv,oppmul,opppower,key_word,iden;
    }
     
    public Type t;
    public  String c;
    public String FullText = ""; 
    public String word;
    public  int LineNumber = 0;
    private String keyWord[] = {"marhab","var","out","bye"};
    private char oper[] = {'+','-','=','/','*'};
    private char digit[]= {'0','1','2','3','4','5','6','7','8','9'};
   
    
    boolean moreline_comm =false;
     public String DeleteComment(String Line)
    {
       String n="";
       for (int i = 0; i < Line.length(); i++) {
         if (!moreline_comm){
            if(Line.charAt(i) == '$'&&Line.charAt(i+1) == '*')
           {  
               moreline_comm=true;
               break;
            }
                    else if(Line.charAt(i) == '$' ){
               break;
                    }}
           else if(Line.charAt(i) == '*'&&Line.charAt(i+1) == '$')
           {
              
                moreline_comm=false;
                i++;
              continue;
           }
          if(!moreline_comm)
         
               n += Line.charAt(i);
           
      
       }
       return n;
   }
     
     public String getOneToken(String word)
    {
        String Word = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ' ' || word.charAt(i) == '\n'  )
            {  
                FullText = FullText.substring(i+1);
                break;
            }
            else
                Word += word.charAt(i);
            
        
        }
        return Word;
    }
     public boolean iskeyword(String word)
    {
        for (int i = 0; i <= keyWord.length-1;i++) 
            if (!word.equals(keyWord[i])) {
            } else {
                return true;
            }
            
         return false;
    }
      public boolean isoper(String word)
    {
        switch(word)
        {
            case "+" : return true;
                case "-" : return true;
                    case "*" : return true;
                        case "/" : return true;
                            case "=" : return true;
                                case "^" : return true;
                                    case "(" : return true;
                                        case ")" : return true;
                            default:return false;
                                
        }
            

    }
      public String getOper(String word)
    { 
        switch(word)
        {
            case "+" : return "opplus";
                case "-" : return "oppminus";
                    case "*" : return "oppmul";
                        case "/" : return "oppdiv";
                            case "=" : return "oppEQ";
                                case "^" : return "opppower";
                                    case "(" : return "LPAREN";
                                        case ")" : return "RPAREN";
                            default:return "";
                                
        }
            

    }
   public String Out(String Line)
    {    
        String text = "";
        for (int i = 0; i < Line.length(); i++) {
            if(Line.charAt(i) == '"'){
                for (int j = i+1; j < Line.length(); j++) {
                    if(Line.charAt(j) == '"')   
                        break;
                     text = text + Line.charAt(j); 
                }
           break;
            }
        }
        return text;
    }
   public char operator(char getoper)
   {
         for (int i = 0; i < oper.length-1; i++) {
           if(getoper == oper[i])
               return oper[i];
         }
         return '~';
   }
     public boolean isFloat=false;
   public boolean isDigit(String word){
       int foundPoint = 0;
       int foundDigit = 0;
       for(int i=0;i<word.length();i++)
       {  for (int j = 0; j < digit.length ; j++) {
               if(word.charAt(i)== digit[j])
               {
                  foundDigit = 0;
                  break; 
               }
               else if(word.charAt(i) == '.')
               {
                   foundPoint ++;
                   isFloat = true;
                   break;
               }
               else 
               {
                   foundDigit = -1;
               }
           }
           if(foundDigit == -1)
               break;
        } 
       char x = 's';
        
        return !( foundDigit == -1||foundPoint > 1);
   }
  public boolean isidinty(String word)
  {  
      String n = "";
      if(Character.isLetter(word.charAt(0)))
      {   
          n += word.charAt(0);
          for (int i = 1; i < word.length(); i++) {
              if(Character.isLetter(word.charAt(0)) || Character.isDigit(word.charAt(0)) || word.charAt(0) == '_')
              n += word.charAt(i);   
              else 
                  break;
          }
          return true;
      }
      return false;
  }

}


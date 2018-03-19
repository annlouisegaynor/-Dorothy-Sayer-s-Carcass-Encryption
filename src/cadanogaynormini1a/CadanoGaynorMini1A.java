package cadanogaynormini1a;
import java.util.*;
/**
 * @author Patrick 
 * @author Ann-Louise
 */
public class CadanoGaynorMini1A {
    public static void main(String[] args) {
        String key;
            int counter=0; 
        do{
            
            Scanner scan=new Scanner(System.in);      
            char square[][]=new char [5][5];    
               
            boolean b;     
            b=true;
            System.out.print("Keyword: "); //To get a valid keyword input from user
            key=scan.nextLine(); 
            key=key.replaceAll("[^aizA-z]",""); 
            int keylength=key.length();
            
             if (key.equals("999")){ //Causes the program to exit once 999 is inputted
                break;
            }
            if (keylength<6)//If the inputted keyword is not more than 6 letters, the user will be prompted to input again
            {
                System.out.println("invalid keyword! Must be more than 6 letters!");
                continue;
            }       
                      
            key=key.toUpperCase();//Changes all lowercase letters in the inputted keyword to uppercase letters
              
            String remaining = "";//Finds the letters that are not part of the keyword
            for ( char alpha='A'; alpha < '[' ; alpha++ )
            {  
                int check = key.indexOf(alpha);
                if ( check == -1 )
                { 
                    remaining += alpha; 
                }       
            }   
                      
            String result= key.concat(remaining);  
            String keyword=result.replace("J","I");//I and J are one     
            char keywordchar[]=keyword.toCharArray();      
            int x, x1 =0;
            int y, y1= 0;
            counter=0;           
            while (counter<keywordchar.length)
            {//If there is a repeated letter, only it frist occurence will be counted
                b=true;
                for (x=0;x<5;x++)
                {
                    for(y=0;y<5;y++)
                    {
                        if (keywordchar[counter]==square[x][y])
                        {
                            b=false;
                        }
                    }
                }
                if (b==true)
                {
                    square[x1][y1]=keywordchar[counter];
                    y1++;
                    if (y1==5)
                    {
                        x1++;
                        y1=0;
                    }
                }
                counter++;
            }
            
            //Prints out the table that contains the keyword and the letters not found in it
            /*If table is part of final ouput, pls. remove comment indicators :)
            System.out.println("+---+---+---+---+---+");
            for (x=1;x<6;x++)
            {
                for(y=1;y<6;y++)
                {
                    System.out.print("| "+square[x-1][y-1]+ " ");
                    if ( y%5 == 0 )               
                    {   
                        System.out.print("|\n");
                        System.out.println("+---+---+---+---+---+"); 
                    }
                }
             }*/
            
            String message;      
            System.out.print("Message: ");//Prompts user to input a message
            message=scan.nextLine();           
            message=message.toUpperCase();
            message=message.replace("J","I");//Lets I and J be one
            message=message.replaceAll("[^aizA-z]","");//Replaces all non-letter characters with ""         
            int length = message.length();
            StringBuilder buff = new StringBuilder(message);
            int a=0;
            b=true;
            do 
                {                
                    if (buff.charAt(a) == buff.charAt(a+1))
                        {
                            if (buff.charAt(a)=='Q')//Inserts a 'Z' between two Q's that are found in a row
                            {
                                buff.insert(a+1,"Z"); 
                                message=buff.toString(); 
                                length++;  
                            }
                            else 
                            {
                                buff.insert(a+1,"Q"); //Inserts a 'Q' between two letters that are the same
                                message=buff.toString();   
                                length++;
                            }
                        }
                    a++;   
                    
                    
                    }  while(a!=length-1);
            
            if (length%2==1){//If the last of the message is odd.....
                char last=message.charAt(length-1);
                if(last=='Q')//Adds 'Z' if the last letter of the message is Q
                {   
                    message=message.concat("Z");
                                                        
                }
                else//Adds 'Q' if the last letter of the message is repeated 
                    message=message.concat("Q");
            }
            
            char messagechar[]=message.toCharArray();
            int c=message.length()/2;
            char encode[][]=new char [c][2]; 
            counter =0;
            while(counter<message.length())
            {
                for(x=0;x<c;x++)
                {
                    for(y=0;y<2;y++)
                    {
                       encode[x][y]=messagechar[counter];             
                       counter++;
                    }     
                }
            }
    
           counter=0;
            x=0;
            y=0;
            x1=0;
            y1=0;
            int coordx1=0;
            int coordy1=0;
            int coordx2=0;
            int coordy2=0;
            length=message.length();  
            System.out.print("Output: ");
            
            //For getting the coded message
            while (counter<length/2)
            {          
                do{
                    if(encode[x][y]==square[x1][y1])
                    {
                        coordx1=x1;
                        coordy1=y1;
                        break;
                    }
                    y1++;
                    if(y1==5)
              	      {
                        x1++;
                        y1=0;
                    }                   
                } while(1==1);
                x1=0;
                y1=0;
                do{
                	if(encode[x][y+1]==square[x1][y1])
                    {
                        coordx2=x1;
                        coordy2=y1;
                        break;
                    }
                    y1++;
                    if(y1==5)
                    {
                        x1++;
                        y1=0;
                    }
                } while(1==1);
                x1=0;
                y1=0; 
                if(coordx1==coordx2)
                {
                    coordy1+=1;
                    coordy2+=1;
                    if (coordy1==5)
                    {
                        coordy1=0;
                    }
                    if (coordy2==5)
                    {
                        coordy2=0;
                    }
                    encode[x][y]=square[coordx1][coordy1];
                    encode[x][y+1]=square[coordx2][coordy2];
                }
                else if (coordy1==coordy2)
                {
                    coordx1+=1;
                    coordx2+=1;
                    if (coordx1==5)
                    {
                        coordx1=0;
                    }
                    if (coordx2==5)
                    {
                        coordx2=0;
                    }
                    encode[x][y]=square[coordx1][coordy1];
                    encode[x][y+1]=square[coordx2][coordy2];    
                }
                else
                {
                    encode[x][y]=square[coordx1][coordy2];
                    encode[x][y+1]=square[coordx2][coordy1];
                }
                counter++;
                System.out.print(encode[x][y]+""+ encode[x][y+1]+" ");   
                x++; 
            }
            System.out.println();
        } while(key!="999");//Entire loop continues to repeat as long as the value 999 is not inputted
    }
}    
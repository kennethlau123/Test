import java.util.regex.Pattern;  
import java.util.Scanner;  
import java.util.regex.Matcher;    
import java.util.*; 
public class card
{  
    public static void main(String args[])
    {  
    
        Scanner sc=new Scanner(System.in);  
        System.out.println("Enter card:");  
        String card = sc.nextLine();
        card = card.replaceAll("-", "");
        System.out.println("card is: " + card);
        int leng = card.length();
        
        
                        
            boolean b1 = Pattern.matches("[4-6]{1}[0-9]{15}", card);
           
            if (b1==true)
            {
                for (int i=0; i< leng-4 ; i++ )
                {
                    if (card.charAt(i) == card.charAt(i+1) && card.charAt(i) == card.charAt(i+2)&& card.charAt(i) == card.charAt(i+3))
                    {
                        b1 = false; 
                        break;
                    }
                } 

            }    
            
            System.out.println(b1);
    } 
        
}
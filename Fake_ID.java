import java.util.*; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Random;
public class Fake_ID
{  
    public static void main(String args[])
    {  
//T1--------------------------------------------------

		String[] GG = new String[7];
       	String[] GG1 ={"Ken", "John", "Peter", "Dick", "Alex"};
		String[] GG2 ={"Chan", "Lau", "Cheung", "Mok", "Ma"};
		String[] GG3 ={"1","2","3","4","5","6","7","8","9"};
		String[] GG4 ={"M',","F',"};
		String[] GG5 ={"2","5","8","9"};
		String[] GG6 ={"Tycoon Place House No. 9,","Gold Reserved Court,","Tai Po Mei Wan Building,","Eightland Gardens Block 3,"};
		String[] GG7 ={"KLN,","KT,","NT,"};
      	Random r=new Random();        
      	int randomNumber=r.nextInt(GG1.length);
		int randomNumber2=r.nextInt(GG2.length);
		int randomNumber3=r.nextInt(GG3.length);
		int randomNumber4=r.nextInt(GG4.length);
		int randomNumber5=r.nextInt(GG5.length);
		int randomNumber6=r.nextInt(GG6.length);
		int randomNumber7=r.nextInt(GG7.length);
		
		System.out.print("'name': '");
		System.out.print(GG1[randomNumber]+" ");
		System.out.println(GG2[randomNumber2]+"',");	
		
		System.out.print("'gender': '");
		System.out.println(GG4[randomNumber4]);	
		
		System.out.print("'dateOfBirth': '");
		int ran =r.nextInt(30);
		if(ran <= 9)
		{
		    System.out.print("0"+ ran+"/");
		}
		else
		{
		    System.out.print(ran+"/");
		}
		 ran=r.nextInt(12);
		if(ran <= 9)
		{
		    System.out.print("0"+ ran+"/");
		}
		else
		{
		    System.out.print(ran+"/");
		}
		ran=r.nextInt(100);
		if(ran <= 20)
		{
		    System.out.println("20"+ ran+"',");
		}
		else
		{
		    System.out.println("19"+ran+"',");
		}
		
		System.out.print("'phoneNumber': '");
		System.out.print(GG5[randomNumber5]);	
		int num2, num3;
		ran = r.nextInt (9)+10;
		num2 = r.nextInt (9999999)+1000;
		num3 = r.nextInt (98)+1;
		System.out.println(ran+num2+num3+"',");
        
        System.out.print("'email': '");
        System.out.print(GG1[randomNumber]);
		System.out.println(GG2[randomNumber2]+"@gmail.com',");	
		
		System.out.print("'address': '");
		System.out.print("RM"+r.nextInt (40)+"0"+r.nextInt (9)+", "+GG6[randomNumber6]+GG7[randomNumber7]+"Hong kong");
		
		

    } 
        
}

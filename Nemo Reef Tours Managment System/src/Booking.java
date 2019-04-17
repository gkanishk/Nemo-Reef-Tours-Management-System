import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Booking {
	static private String bookingName[]=new String[10];
	static private int passengers[]=new int[10];
	static private double charge[]=new double[10];

     JFrame jf=new JFrame();
public void setName(int index) {
	Scanner in=new Scanner(System.in);
	if(index<10) {
	System.out.println("Enter Name");
	bookingName[index]=in.nextLine();
	if(bookingName[index]=="")
	{
		System.out.println("Entered name cant be blank");
	}
	System.out.println("Enter number of passengers");
	//String s=in.next();
	String s=JOptionPane.showInputDialog(null,"Enter number of passengers",0);
	
	passengers[index]=Integer.parseInt(s);
	if(s=="")
		System.out.println("Number of passengers cant be blank");
	//
	if(passengers[index]==0)
	{
		System.out.println("Number of passengers cant be blank");
	}
	getCharge(passengers[index],index);	
	
}
	//Maximum number limit reached
	else
		System.out.println("Maximumlimit reached");
	}
public void getCharge(int n,int index) {
	double ch=n*85.5;
	if(n>0&&n<3)
	{
		charge[index]=ch;
	}
	else if (n>2&&n<6)
	{
		charge[index]=ch-ch*0.1;
	}
	else if(n>5&&n<11) {
		charge[index]=ch-ch*0.15;
	}
	else if(n>10) {
		charge[index]=ch-ch*0.20;
	}
	
}
public void displayData(int index) {
	System.out.println("Name\tPassengers\tCharges");
	for(int i=0;i<index;i++)
	{
		System.out.print(bookingName[i]+"\t"+passengers[i]+"\t");
		System.out.printf("%.2f\n",charge[i]);
	}
}
public void getStat(int index) {
	int min=passengers[0],max=0,minn=0,maxn = 0;
	double sum=0,csum=0;

	for(int i=0;i<index;i++)
	{
		if(passengers[i]>max) {
			max=passengers[i];
			maxn=i;}
		if(passengers[i]<min) {
			min=passengers[i];
			minn=i;}
		sum=sum+passengers[i];
		csum=csum+charge[i];
		
	}
	System.out.println(bookingName[maxn]+" has the maximum number of "+max+" passengers");
	System.out.println(bookingName[minn]+" has the minimum number of "+min+" passengers");
	System.out.println("Average Number of Passengers="+sum/index);
	System.out.println("The total Charges are:"+csum);
	
}
public void searchData(int index)
{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter Passenger name you want to search");
	String nm=in.nextLine();
	int f=0;
	
	for(int i=0;i<index;i++)
	{
		if(bookingName[i].equalsIgnoreCase(nm))
		{
			System.out.println("Booking Found");
			System.out.println("Name\tPassengers\tCharges");
			System.out.print(bookingName[i]+"\t"+passengers[i]+"\t");
			System.out.printf("%.2f\n",charge[i]);
			f=1;
		}
		
	}
	//Search Data not found
	if(f==0)
	{
		System.out.println("Data not found");
	}
}
void sortData(int index)
{String temp;
if(index<1)
{
	System.out.println("You must enter at least two booking to sort");
	
}else {
	 for(int i=0; i<index; i++)
     {
         for(int j=1; j<index; j++)
         {
             if(bookingName[j-1].compareTo(bookingName[j])>0)
             {
                 temp=bookingName[j-1];
                 bookingName[j-1]=bookingName[j];
                 bookingName[j]=temp;
                //Sort Passengers Number
                 passengers[j]=passengers[j]+passengers[j-1];
                 passengers[j-1]=passengers[j]-passengers[j-1];
                 passengers[j]=passengers[j]-passengers[j-1];
                 //Sort Charges
                 charge[j]=charge[j]+charge[j-1];
                 charge[j-1]=charge[j]-charge[j-1];
                 charge[j]=charge[j]-charge[j-1];
                 
                 
                 
             }
         }
     }}
}
		
				

	}



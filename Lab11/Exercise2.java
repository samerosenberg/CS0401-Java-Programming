/*
	Exercise2.java

	- requires you to try/catch recovery from a format mismatch error
*/
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{

		Scanner kbd = new Scanner(System.in);
		boolean cont = true;
		boolean exception = true;
		int num=0;

		do{
			System.out.print("Enter a number between 1 and 100: ");
			try{
				exception = true;
				num=kbd.nextInt();
				cont = false;
			}	catch(InputMismatchException e){
					System.out.println("Input not a number. Try again.\n");
					kbd.next();
					exception = false;
			}
			if((num<1 || num>100) && exception){
				System.out.println("java.lang.Exception: Out of Range Exception. Must be in 1..100\n");
				cont = true;
			}
			else if(num >=1 && num<=100)
				cont = false;
		}while(cont);

		System.out.printf("You entered %d\n", num );

	} //END main
} //EOF

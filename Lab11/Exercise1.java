/*
	Exercise1.java

	- requires you to write a try catch to handle a checked exception

		* REMOVE throws Exception then recompile and let the compiler tell you which exception(s) need handled
		* put the exception code in a try block
		* write the handler code in the catch block - your catch should prompt the user for the input file name
		 then re-intitialise the scanner using the new file name.
*/


import java.io.*;
import java.util.*;
public class Exercise1
{
	public static void main( String args[] )
	{
		if (args.length < 1)
		{
			System.out.println("\nYou must enter an input filename on cmd line!\n");
			System.exit(0);
		}
		boolean fnf = false;
		String infileName = args[0];
		Scanner infile = null;
		Scanner scan = new Scanner(System.in);
		do{
			try{
				fnf=false;
				infile = new  Scanner ( new File( infileName) );
			}
			catch(FileNotFoundException f){
				System.out.print("Bad filename :=( Enter a valid input file name: ");
				infileName = scan.next();
				fnf=true;
			}
		}while(fnf);
		int tokenCnt=0;
		while (infile.hasNext())
		{
			String token = infile.next(); // read a string from infile
			System.out.printf("%d: %s\n", tokenCnt++, token);
		}
	}
} //End class

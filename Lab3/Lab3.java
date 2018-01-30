/* Lab3.java  InsertInOrder */

import java.util.*;
import java.io.*;

public class Lab3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		// ALWAYS TEST FOR REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab3 L3input.txt\n");
			System.exit(0);
		}
		// LOAD FILE INTO ARR USING INSERINORDER

		Scanner infile =  new Scanner( new File( args[0] ) );
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		while (infile.hasNextInt())
		{
			if ( count == arr.length ) arr = upSize( arr );
			insertInOrder( arr, count, infile.nextInt() );
			++count; // WE JUST ADDED A VALUE - UP THE COUNT
		}
		infile.close();
		printArray( "SORTED ARRAY: ", arr, count );

	} // END MAIN
	// ################################################################

	// USE AS IS - DO NOT MODIFY
	static void printArray( String caption, int[] arr, int count  )
	{
		System.out.print( caption );
		for( int i=0 ; i<count ;i++)
			System.out.print(arr[i] + " " );
		System.out.println();
	}

	// YOU WRITE THIS METHOD - DO NOT MODIFY THIS FILE ANYWHERE ELSE
	// ################################################################
	static void insertInOrder( int[] arr, int count, int key   )
	{
		for(int i=count;count>-1;count--){
			if(count==0){
				arr[0]=key;
				break;
			}
			else if(key<arr[count-1]){
				arr[count]=arr[count-1];
			}
			else if(key>=arr[count-1]){
				arr[count]=key;
				break;
			}
		}
	}
	static int[] upSize( int[] fullArr )
	{
		int arr[]= new int[fullArr.length*2];
		for(int i=0;i<fullArr.length;i++)
			arr[i]=fullArr[i];
		return arr; // CHANGE TO YOUR RETURN STATEMENT
	}
} // END LAB3

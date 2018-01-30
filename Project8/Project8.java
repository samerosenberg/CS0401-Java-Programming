
import java.io.*;

public class Project8
{
	public static void main( String[] args )
	{
		// T R I S T A R S
		int rows = 5;
		System.out.format("A tringle with %d rows contains %d stars\n", rows, triStars( rows ) );

		// S U M D I G I T S
		int number = 12345;
		System.out.format("The sum of the digits in the number %d = %d\n", number, sumDigits( number ) );

		// C O U N T 7 S
		number = 713274772;
		System.out.format("There are %d occurances of the digit 7 in the number %d\n", count7s(number), number );

		// C O U N T 8 S
		number = 82338828;
		System.out.format("There are %d occurances of the digit 8 in the number %d\n", count8s(number), number );

		// P O W E R N
		int base=2,exponent=8;
		System.out.format("%d to the power %d = %d\n", base, exponent, powerN(base,exponent) );


		// I S S O R T E D
		// perturb values as needed to test on an unsorted array
		int[] array = { 7, 8, 12, 20, 21, 22, 37, 41, 55, 60, 65, 74, 83, 84, 87 };
		int startingAt=0;
		boolean isSorted = isSorted( array, startingAt, array.length );
		System.out.print( "array: ");
		for ( int i=0 ; i<array.length ; ++i ) System.out.print( array[i] + " " );
		if (isSorted)
			System.out.println(" is SORTED" );
		else
			System.out.println(" is NOT SORTED" );


		// P A L I N D R O M E
		String s = "stanleyyelnats"; // try with several differnt values that are or not palindromes
		if ( isPalindrome( s, 0, s.length()-1 ) )
			System.out.format("%s IS a palindrome\n", s );
		else
			System.out.format("\n%s IS NOT a palindrome\n", s );



	} // END MAIN

	// count stars in a triangle using # of rows as input
	static int triStars(int rows)
	{	if(rows==1) return 1;
		return rows + triStars(rows-1);
	}
	// given a number return the sum of the digits
	static int sumDigits(int n)
	{	if(n==0) return 0;
		return (n%10) + sumDigits(n/10);
	}
	// given a number compute the number of 7's in that number
	static int count7s(int n)
	{	if(n==0) return 0;
		if(n%10==7) return 1+count7s(n/10);
		return count7s(n/10);
	}
	// given a number count the number of 8 but if an 8 has another 8 to its immdiate left count it as 2
	// the number 8802388 will return a count of 6
	static int count8s(int n)
	{	if(n==0) return 0;
		if(n%10==8){
			if(n%100==88) return 2+count8s(n/10);
			return 1+count8s(n/10);
		}
		return count8s(n/10);
	}
	//compute base to the power n
	static int powerN(int base, int n)
	{	if(n==0) return 1;
		return base*powerN(base,n-1);
	}
	// return true only if the array is sorted
	static boolean isSorted(int array[], int i, int count )
	{
		if(i<count-1){
			if(array[i]>array[i+1])
				return false;
		isSorted(array,i+1,count);
		}
		return true;
	}

	// return true if string is palindrome
	static boolean isPalindrome(String s, int lo, int hi )
	{
		if(s.charAt(lo)!=s.charAt(hi))
			return false;
		if(lo==hi)
			return true;
		if(lo<hi)
			return isPalindrome(s,lo+1,hi-1);
		return true;

	}
} // END CLASS Project8

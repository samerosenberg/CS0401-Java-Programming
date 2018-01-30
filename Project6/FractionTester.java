import java.io.*;
import java.util.*;

public class FractionTester
{
	public static void main( String args[] ) throws Exception
	{
		Random generator = new Random( 17 );

		// POPULATE AN ARRAYLIST OF FRACTIONS WITH RANDOM VALUES

		ArrayList<Fraction> AList = new ArrayList<Fraction>();
		for (int i=5 ; i>=0 ; --i )
			AList.add(  new Fraction(1+generator.nextInt(100), 1+generator.nextInt(100)) ); // numer and denom in [1..99]

		// MAKE DEEP COPY OF THOSE FRACTIONS IN THE ARAYLIST ABOVE,  BUT STORE INTO PLAIN ARRAY OF FRACTION

		Fraction[] plainArr = new Fraction[ AList.size() ];
		for ( int i = 0 ; i < plainArr.length ; ++i )
			plainArr[i] = new Fraction( AList.get(i) );

		// PRINT BOTH CONTAINERS TO VERIFY THEY MATCH

		System.out.println("\nArrayList OF FRACTIONS UNSORTED:");
		for ( Fraction f : AList )
			System.out.println( f );

		System.out.println("\nplainArr OF FRACTIONS UNSORTED:");
		for ( Fraction f : plainArr )
			System.out.println( f );

		// SORT BOTH CONTAINERS USING APPROPRIATE LIBRARY

		Collections.sort( AList );
		Arrays.sort( plainArr );

		//RE-PRINT BOTH AND THEY SHOULD BE IDENTICAL AND IN SORTED ORDER

		System.out.println("\nArrayList OF FRACTIONS SORTED:");
		for ( Fraction f : AList )
			System.out.println( f );
		

		System.out.println("\nplainArr OF FRACTIONS SORTED:");
		for ( Fraction f : plainArr )
			System.out.println( f );
	}// END MAIN
} // END

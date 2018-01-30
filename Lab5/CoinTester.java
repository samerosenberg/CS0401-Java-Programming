/*
	CoinTester.java - tests the Coin class by
	constructing variables and calling it's methods
	DO NOT MODIFY.  DO NOT HAND IN. WE WILL USE THIS FILE TO TEST YOUR COIN CLASS
*/
public class CoinTester
{
  public static void main( String args[] )
  {
    Coin coin1 = new Coin( 17 ); // 17 is the SEED
    Coin coin2 = new Coin( 13 ); // 13 is the SEED

	// FLIP COIN1, PRINT RESULTS

    System.out.println("\nFlipping Coin1 20 times.");
    for (int i=0 ; i<20 ; ++i)
        System.out.print( coin1.flip() + " " ); // Equal chance of head or tail
    System.out.println();

    System.out.println("# heads: " + coin1.getNumHeads() +
    		 "  # tails: " + coin1.getNumTails() );
    coin1.reset(); // sets numHeads and numTails back to zero;

	// FLIP COIN2, PRINT RESULTS

    System.out.println("\nFlipping Coin2 10 times.");
    for (int i=0 ; i<10 ; ++i)
        System.out.print( coin2.flip() + " " ); // Equal chance of head or tail
    System.out.println();

    System.out.println("# heads: " + coin2.getNumHeads() +
    		"  # tails: " + coin2.getNumTails() );
    coin2.reset(); // sets numHeads and numTails back to zero;

	// FLIP COIN1 AGAIN, PRINT RESULTS

    System.out.println("\nFlipping Coin1 again 35 times.");
    for (int i=0 ; i<35 ; ++i)
       System.out.print( coin1.flip() + " " ); // Equal chance of head or tail
    System.out.println();

    System.out.println("# heads: " + coin1.getNumHeads() +
    		"  # tails: " + coin1.getNumTails() );
    coin1.reset(); // sets numHeads and numTails back to zero;
  }// END main
}//EOF

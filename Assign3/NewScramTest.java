// CS 401 Fall 2017
// Test file for Scramble2 class.  This program should run as is with your Scramble2
// class.  The scrambled versions of the words do not have to exactly match the ones
// shown in the test execution and since the orders are also pseudorandom, those don't
// have to match either.  However, all of the words should be produced where shown.

import java.io.*;
import java.util.*;
public class NewScramTest
{
    public static void main(String[] args) throws IOException
    {
    	System.out.println("Testing normal use...\n");
        Scramble2 theScramble = new Scramble2("words.txt"); 
        // Create Scramble object using the file name as an argument
        
		showWords(theScramble);
        // Rather than creating a new Scramble2 object, we now reset the previous one.
        // This will allow us to reuse the same words over and over, with a different
        // pseudorandom order being given each time.
        System.out.println("Resetting words...");
        theScramble.reset();
        showWords(theScramble);
        
        theScramble.reset();
        System.out.println("\nTesting special cases...\n");
        System.out.println("Initial call to getScrambledWord(): ");
        String word = theScramble.getScrambledWord();
        if (word == null)
        	System.out.println("No scrambled word yet"); 
        String word1 = theScramble.getRealWord();
        String word2 = theScramble.getRealWord();
        System.out.println("\nTwo calls to getRealWord(): ");
        System.out.println("Word 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("\nTwo calls to getScrambledWord(): ");
        word1 = theScramble.getScrambledWord();
        word2 = theScramble.getScrambledWord();
        System.out.println("Scram word 1: " + word1);
        System.out.println("Scram word 2: " + word2);
        System.out.println("\nNow a call to each: " );
        word1 = theScramble.getRealWord();
        word2 = theScramble.getScrambledWord();
        System.out.println("Word: " + word1);
        System.out.println("Scram word: " + word2);
        
        theScramble.reset();
        System.out.println("\nPartial use then reset: ");
        for (int i = 0; i < 5; i++)
        {
        	word1 = theScramble.getRealWord();
        	word2 = theScramble.getScrambledWord();
        	System.out.println("Word: " + word1);
        	System.out.println("Scram word: " + word2);
        }
        System.out.println();
        theScramble.reset();
        showWords(theScramble);
        	
    }

	public static void showWords(Scramble2 theScramble)
	{
		// Sentinel controlled loop.  Keep getting words and showing them until returned
        // word is null.  This code is the same as in ScramTest.  However, now the words
        // should not appear in the order shown in the file, but in pseudorandom order	
        System.out.println("Here are the words:");
	    String word = theScramble.getRealWord();
        while (word != null)	
        {
        	System.out.println("\tReal word is : " + 	word);
        	System.out.println("\tScrambled word is: " + theScramble.getScrambledWord());
        	
        	word = theScramble.getRealWord();
        }
        System.out.println();
    }
}

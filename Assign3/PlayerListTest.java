// CS 0401 Fall 2017
// Program to test PlayerList and Player classes.  Note the sample output shown
// for this program -- the first time run some new players are added but the
// second time none are added since the updated list was saved back to the file.

// Your Player and PlayerList classes can be implemented in various ways and must
// have additional methods to implement your Scramble game effectively.  However, the
// required methods below demonstrate how the classes should fundamentally work, and
// your Player and PlayerList classes must produce the same results given the same
// players.txt file.

// For some help with these files you should look at Lab7 and, in particular the
// Movie class and the MovieDB class.

import java.util.*;
import java.io.*;

public class PlayerListTest
{
	public static void main(String [] args) throws IOException
	{
		System.out.println("Testing PlayerList and Player classes");
		
		// Create a PlayerList from a file of players.  Note the format of the file
		// and note that after this constructor all of the player information is stored
		// within the allPlayers object.  Note also the effect of the toString() method.
		PlayerList allPlayers = new PlayerList("players.txt");
		System.out.println("Here are the player stats: ");
		System.out.println(allPlayers.toString());
		
		System.out.println();
		String [] names = {"Marge", "Fezzik", "Ingmar", "Inigo"};
		for (String S: names)
		{
			// getPlayer will return a Player object if the player's name is within the
			// PlayerList or null otherwise
			Player onePlayer = allPlayers.getPlayer(S);
			if (onePlayer != null)
			{
				System.out.println("Returning player info:");
				// Note what is produced by the toString() method for a Player
				System.out.println(onePlayer.toString());
			}
			else
			{
				// Create a new player with just a String for the name.  The remaining
				// fields should be 0
				onePlayer = new Player(S);
				System.out.println("New player info: ");
				System.out.println(onePlayer.toString());
				// Add the player to the 
				allPlayers.addPlayer(onePlayer);
			}
		}
		// Note the format and information returned by the toString() method.  Your
		// output should contain the same, well formatted information.
		System.out.println("Here are the player stats: ");
		System.out.println(allPlayers.toString());
		System.out.println();
		// The toStringAdmin() method adds the individual player information to the
		// output.  This would not be used in the game but might be used by an
		// administrator (see extra credit)
		System.out.println("Here are the stats with the individual Player info:");
		System.out.println(allPlayers.toStringAdmin());

		String rName = "Fezzik";
		for (int i = 0; i < 2; i++)
		{
			System.out.println("Trying to remove " + rName);
			// The removePlayer() method will look for the Player with the name
			// matching the argument, remove that Player from the PlayerList, and
			// return that Player to the caller.  If the Player is not found the
			// method should return null
			Player P = allPlayers.removePlayer(rName);
			if (P != null)
			{
				System.out.print(P.toString());
				System.out.println("...has been removed\n");
			}
			else
			{
				System.out.println("Player " + rName + " was not found");
			}
		}
		
		// Write the players back to a text file so that they can be retrieved later
		allPlayers.saveList();
	}		
}

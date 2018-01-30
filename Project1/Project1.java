// F16 CS 401 Speeding Ticket Project
// Project1.java Starter File

import java.io.*;
import java.util.*;

public class Project1
{
	public static void main (String args[])
	{
		// Create a scanner to read from keyboard
		Scanner kbd = new Scanner (System.in);

		String firstName="N/A",lastName="N/A";
		int age=0, speedLimit=0, actualSpeed=0, mphOverLimit=0;
		boolean consZone;
		int baseFine=0, underAgeFine=0, zoneFine=0, totalFine=0;
		final int LO_RATE=30,	HIGH_RATE=50, UNDERAGE_FINE=300;
		// DO NOT ADD TO OR MODIFY ABOVE THIS LINE
		System.out.print("Enter first name and last name: ");
		firstName = kbd.next();
		lastName = kbd.next();
		System.out.print("Your age: ");
		age = kbd.nextInt();
		System.out.print("The speed limit: ");
		speedLimit = kbd.nextInt();
		System.out.print("Driver's actual speed: ");
		actualSpeed = kbd.nextInt();
		System.out.print("Did violation occur in a construction zone? (true/false): ");
		consZone = kbd.nextBoolean();
		mphOverLimit = actualSpeed - speedLimit;
		if(mphOverLimit < 5)
			baseFine = 0;
		else if(mphOverLimit > 5 && mphOverLimit <=20)
			baseFine = LO_RATE*(mphOverLimit/5);
		else if(mphOverLimit >20)
			baseFine = HIGH_RATE*(mphOverLimit/5);
		if(consZone)
			zoneFine = baseFine;
		if(age<21 && mphOverLimit>20)
			underAgeFine = UNDERAGE_FINE;
		totalFine = baseFine + zoneFine + underAgeFine;

		// DO NOT ADD TO OR MODIFY BELOW THIS LINE
		System.out.println();
		System.out.format( "name: %s, %s\n",lastName,firstName );
		System.out.format( "age: %d yrs.\n",age );
		System.out.format( "actual speed: %d mph.\n",actualSpeed );
		System.out.format( "speed limit: %d mph.\n",speedLimit );
		System.out.format( "mph over limit: %d mph.\n",mphOverLimit );
		System.out.format( "base fine: $%d\n",baseFine );
		System.out.format( "zone fine: $%d\n",zoneFine );
		System.out.format( "under age fine: $%d\n",underAgeFine );
		System.out.format( "total fine: $%d\n",totalFine );
	} // END MAIN
} // END PROJECT1 CLASS

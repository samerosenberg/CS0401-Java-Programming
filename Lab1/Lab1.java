// Lab1.java     STARTER FILE

import java.io.*; // I/O
import java.util.*; // Scanner class

public class Lab1
{
	public static void main( String args[] ) throws Exception
	{
		final double MILES_PER_MARATHON = 26.21875; // i.e 26 miles 285 yards

		Scanner kbd = new Scanner (System.in);
		double aveMPH=0, aveMinsPerMile=0, aveSecsPerMile=0; // YOU CALCULATE THESE BASED ON ABOVE INPUTS
		System.out.print("Enter marathon time in hrs minutes seconds: "); // i.e. 3 49 37
		
		double hrs = kbd.nextInt();
		double mins = kbd.nextInt();
		double secs = kbd.nextInt();
		double totaltimehours = hrs + (mins/60.0) + (secs/3600.0);
		aveMPH = MILES_PER_MARATHON / totaltimehours;
		double totaltimesecs = hrs*3600 + mins*60 + secs;
		double secsPerMile = totaltimesecs/MILES_PER_MARATHON;
		aveSecsPerMile = secsPerMile % 60;
		aveMinsPerMile = (int)secsPerMile/60;

		System.out.println();
		System.out.format("Average MPH was: %.2f mph\n", aveMPH  );
		System.out.format("Average mile split was %.0f mins %.1f seconds per mile", aveMinsPerMile, aveSecsPerMile );
		System.out.println();

	}
}

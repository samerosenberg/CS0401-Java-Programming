import java.io.*;
import java.util.*;

// DO NOT!! IMPORT JAVA.LANG

public class Project9
{
  	// JUST FOR YOUR DEBUGGING - DLETE THIS METHOD AND ALL CLASS FOR HANDIN
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	}
	// --YOU-- WRITE THIS METHOD (LOOK AT PRINTSWAMP FOR CLUES)
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		// OPEN UP A SCANNER USING THE INCOMING FILENAME
		// THE FIRST NUMBER ON THE FIRST LINE WILL BE THE NUMBER OF ROWS & COLS
		// THE SECOND & THIRD NUMBER ON 1st LINE WILL BE THE DROP IN POINT X,Y
		// STORE SEOND NUMBER INTO dropInPt[0] THIRD # INTO dropInPt[1]
		// USING ROW, COL DEFINE A 2D ARRAY OF INT
		// USE A NESTED LOOP. OUTER LOOP ROWS, INNER LOOP COLS
		// READ IN THE GRID OF VALUES FROM THE INPUT FILE
		// CLOSE THE SCANNER
		// RETURN THE 2D ARRAY WITH VALUES LOADED INTO IT
		Scanner scan = new Scanner(new File(infileName));
		int swampSize = scan.nextInt();
		int dropInRow = scan.nextInt();
		int dropInCol = scan.nextInt();
		dropInPt[0]= dropInRow;
		dropInPt[1] = dropInCol;
		int[][] swamp = new int[swampSize][swampSize];
		for(int row=0;row<swamp.length;row++){
				for(int col=0;col<swamp[row].length;col++){
						swamp[row][col] = scan.nextInt();
				}
		}
			return swamp;
	}
	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];
		String path = ""; // "[2,3][3,4][3,6][4,6]"
		depthFirstSearch( swamp, row, col, path );

	} // END MAIN

	static void depthFirstSearch( int[][] swamp, int r, int c, String path )
	{
		path+="["+r+","+c+"]";
		if(r==0 || r==swamp.length-1 || c==0 || c==swamp[0].length-1){
			System.out.println(path);
			return;
		}

		//North
		if(swamp[r-1][c]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r-1,c,path);
			swamp[r][c]=1;
		}

		//North East
		if(swamp[r-1][c+1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r-1,c+1,path);
			swamp[r][c]=1;
		}

		//East
		if(swamp[r][c+1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r,c+1,path);
			swamp[r][c]=1;
		}

		//South East
		if(swamp[r+1][c+1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r+1,c+1,path);
			swamp[r][c]=1;
		}

		//South
		if(swamp[r+1][c]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r+1,c,path);
			swamp[r][c]=1;
		}

		//South West
		if(swamp[r+1][c-1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r+1,c-1,path);
			swamp[r][c]=1;
		}

		//West
		if(swamp[r][c-1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r,c-1,path);
			swamp[r][c]=1;
		}

		//North West
		if(swamp[r-1][c-1]==1){
			swamp[r][c]=-1;
			depthFirstSearch(swamp,r-1,c-1,path);
			swamp[r][c]=1;
		}

		return;
		// IMPLEMENT THE DFS ALGORITHM IN HERE
	} // END DFS
}
//boolean inThere = false;
			/*for(int i=0; i<dictionary2.size();i++){
							if(word.length()<dictionary2.get(i).length())
											if(dictionary2.get(i).substring(0,word.length()).equals(word)){
															inThere = true;
															break;
											}
			}
			if(!inThere)
							return;*/
			/*Iterator<String> it = dictionary.iterator();
			String otherWord;
			while(it.hasNext()){
							otherWord = it.next();
							if(word.length()<otherWord.length()){
											if(otherWord.substring(0,word.length()).equals(word)){
															inThere = true;
															break;
											}
							}
			}*/

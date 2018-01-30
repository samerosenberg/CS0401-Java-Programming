import java.util.*;
import java.io.*;

public class Lab4{
  public static void main(String[] args) throws Exception{
    if (args.length < 1 )
    {
      System.out.println("ERROR: Must enter an int on cmd line (i.e. # of random ints to put in array)\n");
      System.exit(0);
    }
    ArrayList<String> wordList = new ArrayList<String>();
    BufferedReader read = new BufferedReader(new FileReader(args[0]));

    while(read.ready()){
      String word = read.readLine();
      wordList.add(word);
    }
    Collections.sort(wordList);


    for(String word: wordList){
      System.out.println(word + " "+canonical(word));
    }


  }
  static String canonical(String word){
    char[] letters = word.toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}

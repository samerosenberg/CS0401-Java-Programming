import java.util.*;
import java.io.*;

public class Project4{
  public static void main(String[] args) throws Exception{
    long startTime = System.currentTimeMillis();
    if (args.length < 1 )
    {
      System.out.println("ERROR: Enter arrays for dictionary and jumbled words\n");
      System.exit(0);
    }
    BufferedReader diction = new BufferedReader(new FileReader(args[0]));
    BufferedReader jumble = new BufferedReader(new FileReader(args[1]));

    ArrayList<String> dictionary= new ArrayList<String>();
    ArrayList<String> jumbled = new ArrayList<String>();
    ArrayList<Integer> index = new ArrayList<Integer>();

    while(diction.ready()){
      dictionary.add(diction.readLine());
    }
    while(jumble.ready()){
      String word = jumble.readLine();
      jumbled.add(word);
      index.add(word.length());
    }

    for(int i=0;i<jumbled.size();i++){
      jumbled.set(i,canonical(jumbled.get(i))+" "+jumbled.get(i)+" ");
    }

    Collections.sort(dictionary);

    for(int i =0; i<dictionary.size();i++){
      for(int j=0; j<jumbled.size();j++){
        if(jumbled.get(j).startsWith(canonical(dictionary.get(i))+" ")){
          jumbled.set(j, jumbled.get(j) +" "+ dictionary.get(i)+ " ");
          break;
        }
      }
    }

    for(int i=0;i<jumbled.size();i++){
      jumbled.set(i, jumbled.get(i).substring(index.get(i)+1,jumbled.get(i).length()));
    }

    Collections.sort(jumbled);

    for(int i=0; i<jumbled.size();i++){
      System.out.println(jumbled.get(i));
    }

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);

  }
  static String canonical(String word){
    char[] letters = word.toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}

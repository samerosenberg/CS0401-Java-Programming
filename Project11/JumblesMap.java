import java.util.*;
import java.io.*;

public class JumblesMap{
  public static void main(String[] args) throws Exception{

    if (args.length < 1 )
    {
      System.out.println("ERROR: Enter arrays for dictionary and jumbled words\n");
      System.exit(0);
    }
    BufferedReader diction = new BufferedReader(new FileReader(args[0]));
    BufferedReader jumble = new BufferedReader(new FileReader(args[1]));

    TreeSet<String> tempdic = new TreeSet<String>();
    TreeMap<String, String> dictionary = new TreeMap<String,String>();
    HashMap<String, String> jumbled = new HashMap<String, String>();


    while(diction.ready()){
      tempdic.add(diction.readLine());
    }

    for(String word: tempdic){
      if(dictionary.containsKey(canonical(word))){
        dictionary.put(canonical(word),dictionary.get(canonical(word))+" "+word);
      }
      else
        dictionary.put(canonical(word),word);
    }

    while(jumble.ready()){
      String word = jumble.readLine();
      jumbled.put(canonical(word),word);
    }



    for(String dic: dictionary.keySet()){
        if(jumbled.containsKey(dic)){
          jumbled.put(dic, jumbled.get(dic)+" "+dictionary.get(dic));
      }
    }


    TreeSet<String> answer = new TreeSet<String>(jumbled.values());

    for(String str: answer){
      System.out.println(str);
    }

  }
  static String canonical(String word){
    char[] letters = word.toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}

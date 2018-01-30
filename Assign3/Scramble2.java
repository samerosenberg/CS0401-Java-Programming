import java.util.*;
import java.io.*;

public class Scramble2 {
  private ArrayList<String> initialList = new ArrayList<String>();
  private ArrayList<String> workingList = new ArrayList<String>();
  private Random rand = new Random();
  private String word;

  public Scramble2(String str) throws Exception{
    Scanner scan = new Scanner(new File(str));
    while(scan.hasNextLine()){
      initialList.add(scan.nextLine());
    }
    for(int i=0;i<initialList.size();i++){
      workingList.add(initialList.get(i));
    }
  }
  public void reset(){
    while(workingList.size()>0){
      workingList.remove(workingList.size()-1);
    }
    for(int i=0; i <initialList.size();i++)
      workingList.add(initialList.get(i));
  }
  public String getRealWord(){
    int num;
    if(workingList.size()>=1){
      num = rand.nextInt(workingList.size());
    }
    else return null;
    word = workingList.get(num);
    workingList.remove(num);
    return word;
  }
  public String getScrambledWord(){
    return getScrambledWord(word);
  }
  public String getScrambledWord(String word){
    if(word==null)
      return null;
    else if(word.length()<=1)
      return word;

    int scramblifier = word.length()/2;
    String temp1= getScrambledWord(word.substring(0,scramblifier));
    String temp2= getScrambledWord(word.substring(scramblifier));

    if(Math.random()>.5)
      return temp1+temp2;
    else
      return temp2+temp1;
  }
}

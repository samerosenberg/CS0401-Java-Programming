import java.util.TreeSet;
import java.util.Scanner;
import java.io.*;

public class Lab10{
 public static void main(String[] args)throws Exception{
       Scanner scan = new Scanner(new File(args[0]));
       boolean unique = true;
       TreeSet<String> tree = new TreeSet<String>();
       while(scan.hasNextLine()){
           if(!tree.add(scan.nextLine())){
            unique= false;
            break;
           }
       }
       if(unique)
         System.out.println("UNIQUE");
      else
         System.out.println("NOT UNIQUE");
   }
}

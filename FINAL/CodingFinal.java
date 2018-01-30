// FALL 2017 CS401 CODING FINAL EXAM PROBLEM
// my Pitt ID: SER79
// my name: Samuel Rosenberg

import java.util.*;
import java.io.*;

public class CodingFinal
{
	public static void main( String args[] ) throws Exception
	{
			Scanner scan = new Scanner(new File("student2CourseNums.txt"));
			Scanner scan2 = new Scanner(new File("courseNum2CourseName.txt"));
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> classNums = new ArrayList<String>();
			ArrayList<String> classes = new ArrayList<String>();
			ArrayList<String> classesNums = new ArrayList<String>();
			ArrayList<String> studentClasses = new ArrayList<String>();

			String temp="";
			while(scan.hasNextLine()){
				temp = "";
				String[] tokens = scan.nextLine().split(" ");
				ArrayList<String> stuffs = new ArrayList<String>(Arrays.asList(tokens));
				names.add(stuffs.get(0));
				stuffs.remove(0);
				for(String str:stuffs){
					studentClasses.add(str);
					temp += str + " ";
				}
				classNums.add(temp);
			}
			ArrayList<String> both = new ArrayList<String>();
			for(int i=0;i<names.size();i++)
				both.add(names.get(i)+" "+classNums.get(i));
				Collections.sort(both);
			//Step 1
			for(int i=0; i<names.size();i++){
				System.out.print(names.get(i) + " " +classNums.get(i));
			}
			System.out.println("");
			//Step 2
			for(int i=0; i<names.size();i++){
				System.out.println(both.get(i));
			}

			while(scan2.hasNextLine()){
				temp = "";
				String[] tokens = scan2.nextLine().split(" ");
				ArrayList<String> stuffs2 = new ArrayList<String>(Arrays.asList(tokens));
				classesNums.add(stuffs2.get(0));
				stuffs2.remove(0);
				classes.add(stuffs2.get(0));
			}
			ArrayList<String> both2 = new ArrayList<String>();
			for(int i=0;i<classes.size();i++)
				both2.add(classes.get(i)+" "+classesNums.get(i));
				Collections.sort(both2);
			//Step 3
			for(int i=0; i<both2.size();i++){
				System.out.println(both2.get(i));
			}

			for(int i=0; i<classesNums.size();i++){
				temp = "";
				String[] tokens = classNums.get(i).split(" ");
				ArrayList<String> stuffs = new ArrayList<String>(Arrays.asList(tokens));

			}








	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END CodingFinal

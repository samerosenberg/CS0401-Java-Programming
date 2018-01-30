
import java.io.*;
import java.util.*;
//2.4
public class Boggle{
private static TreeSet<String> hits = new TreeSet<String>();
private static HashSet<String> dictionary = new HashSet<String>();

public static void main(String[] args) throws Exception {
        String word = "";
        Scanner s= new Scanner(new File(args[0]));
        while(s.hasNextLine()) {
                dictionary.add(s.nextLine());
        }

        Scanner scan = new Scanner(new File(args[1]));
        int size = scan.nextInt();
        String[][] boggle = new String[size][size];
        for(int row=0; row<boggle.length; row++) {
                for(int col=0; col<boggle[row].length; col++) {
                        boggle[row][col] = scan.next();
                }
        }
        for(int row=0; row<boggle.length; row++) {
                for(int col=0; col<boggle[row].length; col++) {
                        depthFirstSearch(boggle,row,col,word);
                }
        }
        for(String str: hits)
                System.out.println(str);
        

}
private static void depthFirstSearch(String[][] board, int r, int c, String word){
        word += board[r][c];
        if(word.length()>9 )
                return;
        if(word.length()>=3) {
                if(dictionary.contains(word)){
                        hits.add(word);
                        dictionary.remove(word);
                  }
        }


        //North
        if(r>0) {
                if(Character.isLowerCase(board[r-1][c].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r-1,c,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //North East
        if(r>0 && c<board.length-1) {
                if(Character.isLowerCase(board[r-1][c+1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r-1,c+1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }


        //East
        if(c<board.length-1) {
                if(Character.isLowerCase(board[r][c+1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r,c+1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //South East
        if(r<board.length-1 && c<board.length-1) {
                if(Character.isLowerCase(board[r+1][c+1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r+1,c+1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //South
        if(r<board.length-1) {
                if(Character.isLowerCase(board[r+1][c].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r+1,c,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //South West
        if(r<board.length-1 && c>0) {
                if(Character.isLowerCase(board[r+1][c-1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r+1,c-1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //West
        if(c>0) {
                if(Character.isLowerCase(board[r][c-1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r,c-1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        //North West
        if(r>0 && c>0) {
                if(Character.isLowerCase(board[r-1][c-1].charAt(0))) {
                        board[r][c]=board[r][c].toUpperCase();
                        depthFirstSearch(board,r-1,c-1,word);
                        board[r][c]=board[r][c].toLowerCase();
                }
        }

        return;
}




}

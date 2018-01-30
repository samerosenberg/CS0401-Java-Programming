import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BoggleGUI{
private static TreeSet<String> hits = new TreeSet<String>();
private static HashSet<String> dictionary = new HashSet<String>();
JFrame window;
Container content;
JTextArea boggleName,answer;
JButton clearButton, runButton;
JScrollPane words;
JPanel boggleBoard,topPanel;
private static int size;
private static ArrayList<String> boggleLetters = new ArrayList<String>();
ArrayList<JTextField> boggleLabels = new ArrayList<JTextField>();
private static String[][] boggle;


public BoggleGUI(){
        window = new JFrame("Boggle GUI");
        content= window.getContentPane();
        content .setLayout(new GridLayout(2,1));
        ButtonListener listener = new ButtonListener();

        //Splits into 2x2 grid
        topPanel= new JPanel();
        topPanel.setLayout(new GridLayout(1,2));

        JPanel topLeft = new JPanel();
        topLeft.setLayout(new GridLayout(2,1));

        boggleName = new JTextArea();
        boggleName.setFont(new Font("verdana",Font.PLAIN, 14));
        boggleName.setText("erase and type boggle file name here and hit run button ");
        boggleName.setLineWrap(true);
        boggleName.setWrapStyleWord(true);

        clearButton = new JButton();
        clearButton.setFont(new Font("verdana",Font.BOLD,20));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(listener);


        boggleBoard = new JPanel();
        boggleBoard.setLayout(new GridLayout(size,size));
        for(int i=0; i<boggleLetters.size();i++){
                boggleLabels.add(new JTextField(boggleLetters.get(i)));
                boggleLabels.get(i).setHorizontalAlignment(JTextField.CENTER);
                boggleBoard.add(boggleLabels.get(i));
        }

        //add text field and button to top left panel of gui
        topLeft.add(boggleName);
        topLeft.add(clearButton);

        //add top left panel and place for boggle board to topPanel
        topPanel.add(topLeft);
        topPanel.add(boggleBoard);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));

        runButton= new JButton();
        runButton.setFont(new Font("verdana",Font.BOLD,20));
        runButton.setText("RUN");
        runButton.addActionListener(listener);

        answer = new JTextArea();
        answer.setFont(new Font("verdana",Font.BOLD,16));
        answer.setText("");
        //words = new JScrollPane(answer);

        //add run button and place for answers to bottom panel
        bottomPanel.add(runButton);
        //bottomPanel.add(words);
        bottomPanel.add(answer);

        //add top panel and bottom panel to screen
        content.add(topPanel);
        content.add(bottomPanel);

        window.setSize(750, 600);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                Component whichButton = (Component) e.getSource();
                if(whichButton==runButton){
                        String word="";
                        for(int row=0; row<boggle.length; row++) {
                                for(int col=0; col<boggle[row].length; col++) {
                                        depthFirstSearch(boggle,row,col,word);
                                }
                        }
                        /*for(String str: hits){
                                answer.setText(answer.getText()+"\n"+ str);
                        }*/
                }
                if(whichButton==clearButton){
                        for(int i=0; i< boggleLetters.size();i++){
                                answer.setText(answer.getText()+ " " + boggleLetters.get(i));
                        }
                        for(int i=0;i<boggleLetters.size();i++){
                                boggleLetters.set(i,"");
                                boggleLabels.add(new JTextField(boggleLetters.get(i)));
                                boggleBoard.add(boggleLabels.get(i));
                        }
                        topPanel.add(boggleBoard);

                }
        }
}

public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(new File(args[0]));
        while(s.hasNextLine()) {
                dictionary.add(s.nextLine());
        }

        Scanner scan = new Scanner(new File(args[1]));
        size = scan.nextInt();
        boggle = new String[size][size];
        for(int row=0; row<boggle.length; row++) {
                for(int col=0; col<boggle[row].length; col++) {
                        String word = scan.next();
                        boggle[row][col] = word;
                        boggleLetters.add(word);
                }
        }
        new BoggleGUI();
        /*for(int row=0; row<boggle.length; row++) {
                for(int col=0; col<boggle[row].length; col++) {
                        depthFirstSearch(boggle,row,col,word);
                }
        }*/
        //for(String str: hits)
        //        System.out.println(str);


}
public static void depthFirstSearch(String[][] board, int r, int c, String word){
        word += "" + board[r][c];
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

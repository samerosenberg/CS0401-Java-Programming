
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoggleGUI
{
	JFrame window;  // the main window which contains everything
	Container content ;
	JTextArea wordsFound; // list of valid dictionary words found in grid
	JButton randomize; // if clicked a random boggle board will be generated
	JButton go; // if clicked a random boggle board will be generated
	JTextField dimension;	// this field must have a nmber in it if the used clecikd Randomize
	JTextField inputFile;
	JPanel leftPanel,boardPanel; 
	// YOU CAN CHANGE THIS TO INCLUE "qu" IF YOU WISH
	String[] alphabet = {	"a","b","c","d","e","f","g","h","i",
								"j","k","l","m","n","o","p","q","r",
								"s","t","u","v","w","x","y","z" };
	JButton[][] boardButtons;
	
	public BoggleGUI()
	{
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(1,3)); // 
		ButtonListener listener = new ButtonListener();

		wordsFound = new JTextArea();
		randomize = new JButton("Randomize"); 
		go = new JButton("GO!"); 
		dimension = new JTextField("DEFAULT DIMENSION: 4x4");	// defaults ot 4
		inputFile =  new JTextField("type boggle filename here");	
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(4,1));
		leftPanel.add( randomize );
		leftPanel.add( inputFile );
		leftPanel.add( dimension );
		leftPanel.add( go );
		
		boardPanel = new JPanel();
		boardButtons = new JButton[4][4]; // YOU CHANGE THIS IF NOT DOING A 4x4
		boardPanel.setLayout(new GridLayout(4,4)); // CHANGE THIS IF NOT DOING A DEFAULT / RANDOMIZED
		int i=0;
		for ( int r=0 ; r < boardButtons.length ; ++r )
			for ( int c=0 ; c < boardButtons.length ; ++c )
			{	boardButtons[r][c] = new JButton( alphabet[i++] ); // JUST A SAMPLE YOU MUSt CHANGE
				boardPanel.add( boardButtons[r][c] );
			}
	
		content.add( leftPanel );
		content.add( boardPanel );
		content.add( wordsFound );
		
		window.setSize( 640,480);
		window.setVisible( true );
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
		}
	}

	public static void main(String [] args)
	{
		new BoggleGUI();
	}
}


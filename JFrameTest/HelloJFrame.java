// CS 401 Fall 2011  adapted from john ramirez' example

// Simple example to show a label in a window
import java.awt.*; // needed for the Component and Font classes
import javax.swing.*; // needed for the JFrame and JLabel classes

public class HelloJFrame
{
	public static void main(String [] args)
	{
		// Create a JFrame object for the window
		JFrame window = new JFrame("my First JFrame");

		// Set it to terminate the program when the window closes
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Create a JLabel object for the message.  Set the font and the
		// color of the JLabel to make it more interesting

		JLabel message = new JLabel("Hello GUI World");
		message.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		message.setForeground(Color.RED);

		// The content pane of a JFrame is the "part" of the JFrame that
		// is used to store other components.  We don't add stuff directly to the JFrame
		// we add stuff to the content pane.

		// create a contentPane ref var and bind it to our window's pane

		Container content = window.getContentPane();
		content.add(message);

		// Size the window to be 400 pixels wide by 150 pixels high
		// Then show it so it is actually displayed

		window.setSize(400, 150);

		// Alternatively, we can size the window to be big enough to contain
		// whatever is inside it -- this is what pack() does
		//window.pack();

		window.setVisible(true);
	}
}

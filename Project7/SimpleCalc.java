// Demonstrates JPanel, GridLayout and a few additional useful graphical features.
// adapted from an example by john ramirez (cs prof univ pgh)
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import javax.swing.*;

public class SimpleCalc
{
    JFrame window;  // the main window which contains everything
    Container content ;
    JButton[] digits = new JButton[12];
    JButton[] ops = new JButton[4];
    JTextField expression;
    JButton equals;
    JTextField result;

    public SimpleCalc()
    {
        window = new JFrame( "Simple Calc");
        content = window.getContentPane();
        content.setLayout(new GridLayout(2,1)); // 2 row, 1 col
        ButtonListener listener = new ButtonListener();

        // top panel holds expression field, equals sign and result field
        // [4+3/2-(5/3.5)+3]  =   [3.456]

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3)); // 1 row, 3 col

        expression = new JTextField();
        expression.setFont(new Font("verdana", Font.BOLD, 16));
        expression.setText("");

        equals = new JButton("=");
        equals.setFont(new Font("verdana", Font.BOLD, 20 ));
        equals.addActionListener( listener );

        result = new JTextField();
        result.setFont(new Font("verdana", Font.BOLD, 16));
        result.setText("");

        topPanel.add(expression);
        topPanel.add(equals);
        topPanel.add(result);

        // bottom panel holds the digit buttons in the left sub panel and the operators in the right sub panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2)); // 1 row, 2 col

        JPanel  digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4,3));

        for (int i=0 ; i<10 ; i++ )
        {
            digits[i] = new JButton( ""+i );
            digitsPanel.add( digits[i] );
            digits[i].addActionListener( listener );
        }
        digits[10] = new JButton( "C" );
        digitsPanel.add( digits[10] );
        digits[10].addActionListener( listener );

        digits[11] = new JButton( "CE" );
        digitsPanel.add( digits[11] );
        digits[11].addActionListener( listener );

        JPanel opsPanel = new JPanel();
        opsPanel.setLayout(new GridLayout(4,1));
        String[] opCodes = { "+", "-", "*", "/" };
        for (int i=0 ; i<4 ; i++ )
        {
            ops[i] = new JButton( opCodes[i] );
            opsPanel.add( ops[i] );
            ops[i].addActionListener( listener );
        }
        bottomPanel.add( digitsPanel );
        bottomPanel.add( opsPanel );

        content.add( topPanel );
        content.add( bottomPanel );

        window.setSize( 640,480);
        window.setVisible( true );
    }

    // We are again using an inner class here so that we can access
    // components from within the listener.  Note the different ways
    // of getting the int counts into the String of the label

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            Component whichButton = (Component) e.getSource();

            //initialize array for final answer
            ArrayList<String> answer = new ArrayList<String>();

            //Check if number button is pressed and assign value of button to expression
            for (int i=0 ; i<10 ; i++ )
                if (whichButton == digits[i])
                    expression.setText( expression.getText() + i );

            //Check is C or CE button is pressed and change expression text accordingly
            if(whichButton==digits[10]){
                expression.setText("");
                result.setText("");
            }
            if(whichButton==digits[11]){
                expression.setText(expression.getText().substring(0,expression.getText().length()-1));
            }

            //Check if any operator is pressed and add to end of expression
            if (whichButton == ops[0])
                    expression.setText(expression.getText() + "+");
            else if(whichButton == ops[1])
                    expression.setText(expression.getText()+"-");
            else if(whichButton == ops[2])
                    expression.setText(expression.getText()+"*");
            else if(whichButton == ops[3])
                    expression.setText(expression.getText()+"/");

            //Check if equals button is pressed and start process to solve equation
            if(whichButton==equals){
                //split string into parts separating at operands and then assign each value to an element in an array
                StringTokenizer input = new StringTokenizer( expression.getText(),"+-*/", true );
                while(input.hasMoreElements()){
                    String temp = input.nextToken();
                    answer.add(temp);
                }
                //check if expression is valid or not
                if(answer.size()%2==0) {
                    result.setText("INVALID EXPRESSION");
                }
                else {
                    //call evaluate function to simplify expression and set result text as the answer
                    result.setText(evaluate(answer));
                }
            }

        }

    }
    public static String evaluate(ArrayList<String> answer){
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals("*")) {
                answer.set(i, Double.parseDouble(answer.get(i - 1)) * Double.parseDouble(answer.get(i + 1)) + "");
                answer.remove(i + 1);
                answer.remove(i - 1);
                i = 0;
            } else if (answer.get(i).equals("/")) {
                answer.set(i, Double.parseDouble(answer.get(i - 1)) / Double.parseDouble(answer.get(i + 1)) + "");
                answer.remove(i + 1);
                answer.remove(i - 1);
                i = 0;
            }
        }
        //solve equation for addition and subtraction symbols
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals("+")) {
                answer.set(i, Double.parseDouble(answer.get(i - 1)) + Double.parseDouble(answer.get(i + 1)) + "");
                answer.remove(i + 1);
                answer.remove(i - 1);
                i = 0;
            } else if (answer.get(i).equals("-")) {
                answer.set(i, Double.parseDouble(answer.get(i - 1)) - Double.parseDouble(answer.get(i + 1)) + "");
                answer.remove(i + 1);
                answer.remove(i - 1);
                i = 0;
            }
        }
        return answer.get(0);

    }
    public static void main(String [] args)
    {
        new SimpleCalc();
    }
}

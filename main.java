import javax.swing.*;
import java.awt.*;

/** This is the main class
 * This class contains the game logic.
*
* @author Matthew Webster
* @version 1.0 November 28, 2014
*/
public class main 
{
	
	
	
	public static void main(String[] args) 
	{
		JFrame gameWindow = new JFrame("Mortgage!");
		
		JButton newGame = new JButton();
		newGame.setText("New Game!");
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Player Name:");
		
		JTextField nameField = new JTextField();
		nameField.setText("Player One");

		JLabel turnLabel = new JLabel();
		turnLabel.setText("Turn:");
		
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(0,255,0));
		panel1.setVisible(true);
		
		
		
		
		gameWindow.setSize(1024,768);
		gameWindow.setLayout(null);
		
		
		JButton board[] = new JButton[14];
		
		//add icons and buttons to the game board
		for(int i = 0; i<14; i++)
		{
			board[i] = new JButton();
			board[i].setText("I'm " +i);
			gameWindow.add(board[i]);
		}
		
		panel1.add(turnLabel);
		
		
		
		
		gameWindow.add(turnLabel);
		gameWindow.add(newGame);
		gameWindow.add(nameLabel);
		gameWindow.add(nameField);
		//gameWindow.add(turnLabel);
		
		
		//Set the positions of the icons and  buttons
		//top row
		board[0].setBounds(400+120*0, 5+0, 120, 120);
		board[1].setBounds(400+120*1, 5+0, 120, 120);
		board[2].setBounds(400+120*2, 5+0, 120, 120);
		board[3].setBounds(400+120*3, 5+0, 120, 120);
		board[4].setBounds(400+120*4, 5+0, 120, 120);
		//right side
		board[5].setBounds(400+120*4, 5+120*1, 120, 120);
		board[6].setBounds(400+120*4, 5+120*2, 120, 120);
		//bottom row
		board[7].setBounds(400+120*4, 5+120*3, 120, 120);
		board[8].setBounds(400+120*3, 5+120*3, 120, 120);
		board[9].setBounds(400+120*2, 5+120*3, 120, 120);
		board[10].setBounds(400+120*1, 5+120*3, 120, 120);
		board[11].setBounds(400+120*0, 5+120*3, 120, 120);
		//left side
		board[12].setBounds(400+120*0, 5+120*2, 120, 120);
		board[13].setBounds(400+120*0, 5+120*1, 120, 120);
		
		newGame.setBounds(5, 30, 250, 30);
		
		nameLabel.setBounds(5, 5, 95, 20);

		nameField.setBounds(100, 5, 120, 20);
		
		panel1.setBounds(0, 0, 400, 500);
		
		turnLabel.setBounds(5, 65, 50, 20);

		gameWindow.setVisible(true);
		
		
		
	}
	
}

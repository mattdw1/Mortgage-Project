import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

/** This is the main class
 * This class contains the game logic.
*
* @author Matthew Webster
* @version 1.0 November 28, 2014
*/
public class mortgage
{
	


	

	public static void main(String[] args)
	{
		//GUI fields, and player data item initialization 
		Player player[] = new Player[4];
		
		
		JFrame gameWindow;
		JButton newGame = new JButton();
		JLabel nameLabel = new JLabel();
		JTextArea propertyTextArea = new JTextArea();
		JTextField nameField = new JTextField();
		JLabel turnLabel = new JLabel();
		JLabel turnNumberLabel = new JLabel();
		JButton helpButton = new JButton();
		JButton rollDice = new JButton();
		JButton buyButton = new JButton();
		JButton dontBuyButton = new JButton();
                JButton chance = new JButton();
		
		//The current turn number.
		int turn = 1;
		
		//Whose turn it is currently.
		int playerTurn = 1;
		
		gameWindow = new JFrame("Mortgage!");
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the text on certian buttons -----------------------------------------------------------------
		
		newGame.setText("New Game!");
		
		nameLabel.setText("Player Name:");
		
		propertyTextArea.setText("Mortgage Prototype - Alpha 1.0\n"
								+"To Play: Purchase investments to gain profit over time. Don't go bankrupt as the market fluctuates.");
		propertyTextArea.setBackground(new Color(200,255,255));
		propertyTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		nameField.setText("Player");

		turnLabel.setText("Turn:");

		turnNumberLabel.setText(Integer.toString(turn));
		
		helpButton.setText("Help");
		
		rollDice.setText("Roll Dice");
		
		buyButton.setText("Purchase");
		
		dontBuyButton.setText("Ignore Investment");
                
                chance.setText("*TEST* Draw Chance Card");
		
		
		gameWindow.setSize(1024,768);
		gameWindow.setLayout(null);
		
		
		//buttons and the properties
		JButton board[] = new JButton[14];
		Property property[] = new Property[14];
		
		//add icons and buttons to the game board ------------------------------------------------------------------
		for(int i = 0; i<14; i++)
		{
			int[] rentPrice = {(i+1)*20, (i+1)*30, (i+1)*40, (i+1)*60, (i+1)*90};
			int[] upgradePrice = { (i+1)*60, (i+1)*70, (i+1)*100, (i+1)*150};
			property[i] = new Property((i+1)*100, "Property "+Integer.toString(i), rentPrice , upgradePrice);
			board[i] = new JButton();
			board[i].setText("I'm " +i);
			gameWindow.add(board[i]);
		}
		
		
		gameWindow.add(turnLabel);
		gameWindow.add(newGame);
		gameWindow.add(nameLabel);
		gameWindow.add(propertyTextArea);
		gameWindow.add(nameField);
		gameWindow.add(turnLabel);
		gameWindow.add(turnNumberLabel);
		gameWindow.add(helpButton);
		gameWindow.add(rollDice);
		gameWindow.add(buyButton);
		gameWindow.add(dontBuyButton);
                gameWindow.add(chance);
		
		
		//Set the positions of the icons and  buttons--------------------------------------------------
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
		
		newGame.setBounds(5, 30, 240, 30);
		
		nameLabel.setBounds(5, 5, 95, 20);
		
		propertyTextArea.setBounds(5, 510, 598, 200);

		nameField.setBounds(100, 5, 120, 20);

		turnLabel.setBounds(5, 65, 30, 20);

		turnNumberLabel.setBounds(40, 65, 50, 20);
		
		helpButton.setBounds(250, 5, 90, 55);		
		
		rollDice.setBounds(5, 90, 240, 50);
		//disabled until new game is pressed
		rollDice.setEnabled(false);
		
		buyButton.setBounds(10+598, 510, 240, 50);
		//disabled until new game is pressed
		buyButton.setEnabled(false);
		
		dontBuyButton.setBounds(10+598, 565, 240, 50);
		//disabled until new game is pressed
		dontBuyButton.setEnabled(false);
                
                chance.setBounds(5, 150, 240, 50);
		
		
		

		
		
		
		//game logic -------------------------------------------------------------------------------------

		board[0].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(0, propertyTextArea, property);
		  }
		});

		board[1].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(1, propertyTextArea, property);
		  }
		});

		board[2].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(2, propertyTextArea, property);
		  }
		});

		board[3].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(3, propertyTextArea, property);
		  }
		});

		board[4].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(4, propertyTextArea, property);
		  }
		});

		board[5].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(5, propertyTextArea, property);
		  }
		});

		board[6].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(6, propertyTextArea, property);
		  }
		});

		board[7].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(7, propertyTextArea, property);
		  }
		});

		board[8].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(8, propertyTextArea, property);
		  }
		});

		board[9].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(9, propertyTextArea, property);
		  }
		});

		board[10].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(10, propertyTextArea, property);
		  }
		});

		board[11].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(11, propertyTextArea, property);
		  }
		});

		board[12].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(12, propertyTextArea, property);
		  }
		});

		board[13].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(13, propertyTextArea, property);
		  }
		});
		
		
		newGame.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					propertyTextArea.setText("New Game started. The game board has been cleared.");
					for(int i = 0; i<14; i++)
					{
						int[] rentPrice = {(i+1)*20, (i+1)*30, (i+1)*40, (i+1)*60, (i+1)*90};
						int[] upgradePrice = { (i+1)*60, (i+1)*70, (i+1)*100, (i+1)*150};
						property[i] = new Property((i+1)*100, "Property "+Integer.toString(i), rentPrice , upgradePrice);
						board[i] = new JButton();
						board[i].setText("Property" +i);
					}
					
					player[0]=new Player();
					player[0].setName(nameField.getText());
					
					if(player[0].getName() == null)
						player[0] = new Player("Default", 0, 0);
					
					for(int i=1; i<4; i++)
					{
						player[i] = new Player();
					}
					
					rollDice.setEnabled(true);
				}
		});
		
		
		helpButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					propertyTextArea.setText("Mortgage Prototype - Alpha 1.0\n"
								+"To Play: Purchase investments to gain profit over time. Don't go bankrupt as the market fluctuates.");
				}
		});		
		
		rollDice.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					rollDice.setEnabled(false);
					
					
					
					//stuff
					
					//dice rolling
					
					//int playerLocation = (player[0].getCurrentSpace()+3)%14;
					
					int playerLocation = player[0].getCurrentSpace();
					
					playerLocation =(playerLocation+3)%14;
					
					player[0].setCurrentSpace(playerLocation);
					
					propertyTextArea.setText(player[0].getName()+" landed on "+property[playerLocation].getName());
					
					if(property[playerLocation].getOwner() == -1)
					{
						buyButton.setEnabled(true);
						dontBuyButton.setEnabled(true);
						propertyTextArea.setText(propertyTextArea.getText()+"\n\n"
												+property[playerLocation].getName()+" is unowned! Do you wish to purchase?\n"
												+"Investment Cost: "+Integer.toString(property[playerLocation].getPrice())+"\n"
												+"Investment Return: "+Integer.toString(property[playerLocation].getRent())+"\n"
												+"Upgrade Costs: "+Arrays.toString(property[playerLocation].getUpgradeCostArray())+"\n"
												+"Interest Income: "+Arrays.toString(property[playerLocation].getRentArray()));
					}
					else if(property[playerLocation].getOwner() != 0)
					{
						propertyTextArea.setText(propertyTextArea.getText()+"\n\n"
								+property[playerLocation].getName()+" has already been invested in by someone else...\n"								
								+"Property Owner: Player "+Integer.toString(property[playerLocation].getOwner())+"\n"
								+"Investment Cost: "+Integer.toString(property[playerLocation].getPrice())+"\n"
								+"Investment Return: "+Integer.toString(property[playerLocation].getRent())+"\n"
								+"Upgrade Costs: "+Arrays.toString(property[playerLocation].getUpgradeCostArray())+"\n"
								+"Interest Income: "+Arrays.toString(property[playerLocation].getRentArray()));
					}
				}
		});
		
		buyButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					buyButton.setEnabled(false);
					dontBuyButton.setEnabled(false);
					rollDice.setEnabled(true);
					propertyTextArea.setText("BuyButton pressed");
					
					//AI MOVES HERE
				}
		});		
		
		dontBuyButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					buyButton.setEnabled(false);
					dontBuyButton.setEnabled(false);
					rollDice.setEnabled(true);
					propertyTextArea.setText("dont buy pressed");
					
					//AI MOVES HERE
				}
		});
                
                chance.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
                                    Chance.pick_chance(propertyTextArea, property, player);
				}
		});
		
		
		
		

		gameWindow.setVisible(true);
		
	}
	
	public static void updatePropertyTextArea(int index, JTextArea propertyTextArea, Property[] property)
	{
		  propertyTextArea.setText("Property Selected\n"
	  				+"Property Name: "+ property[index].getName()+"\n"
	  				+"Property Owner: Player "+Integer.toString(property[index].getOwner())+"\n"
			  		+"Investment Cost: "+Integer.toString(property[index].getPrice())+"\n"
					+"Investment Return: "+Integer.toString(property[index].getRent())+"\n"
					+"Upgrade Costs: "+Arrays.toString(property[index].getUpgradeCostArray())+"\n"
					+"Interest Income: "+Arrays.toString(property[index].getRentArray()));
	}

	
}

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
		//int playerTurn = 1;
		
		gameWindow = new JFrame("Mortgage!");
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the text on certian buttons -----------------------------------------------------------------
		
		newGame.setText("New Game!");
		
		nameLabel.setText("Player Name:");
		
		propertyTextArea.setText("Mortgage Prototype - Alpha 1.0\n"
								+"To Play: Purchase investments to gain profit over time. Don't go bankrupt as the market fluctuates.\n"
								+"The Government takes your money every turn! Try to earn more then they take!");
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
		chance.setEnabled(false);
		
		

		
		
		
		//game logic -------------------------------------------------------------------------------------

		board[0].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(0, propertyTextArea, property, player);
		  }
		});

		board[1].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(1, propertyTextArea, property, player);
		  }
		});

		board[2].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(2, propertyTextArea, property, player);
		  }
		});

		board[3].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(3, propertyTextArea, property, player);
		  }
		});

		board[4].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(4, propertyTextArea, property, player);
		  }
		});

		board[5].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(5, propertyTextArea, property, player);
		  }
		});

		board[6].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(6, propertyTextArea, property, player);
		  }
		});

		board[7].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(7, propertyTextArea, property, player);
		  }
		});

		board[8].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(8, propertyTextArea, property, player);
		  }
		});

		board[9].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(9, propertyTextArea, property, player);
		  }
		});

		board[10].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(10, propertyTextArea, property, player);
		  }
		});

		board[11].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(11, propertyTextArea, property, player);
		  }
		});

		board[12].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(12, propertyTextArea, property, player);
		  }
		});

		board[13].addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  updatePropertyTextArea(13, propertyTextArea, property, player);
		  }
		});
		
		
		newGame.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					String[] names= {"Aaron","Adam","Alex", "Alice", "Amber", "Ashley",
							"Ben", "Bradley", "Blair", "Bella", "Brandy", "Brook",
							"Cody", "Cole", "Conner", "Chloe", "Christy", "Colette",
							"Dennis", "Derrick", "Diego", "Dakota", "Dawn", "Diane",
							"Tracy", "Brian", "Matthew"
						};
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
						int nnum = (int)(Math.random()*names.length);
						player[i].setName(names[nnum]);
					}
					
					rollDice.setEnabled(true);
					chance.setEnabled(true);
				}
		});
		
		
		helpButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					propertyTextArea.setText("Mortgage Prototype - Alpha 1.0\n"
							+"To Play: Purchase investments to gain profit over time. Don't go bankrupt as the market fluctuates.\n"
							+"The Government takes your money every turn! Try to earn more then they take!");
				}
		});		
		
		rollDice.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					rollDice.setEnabled(false);
					
					
					//clear text area for new roll
					propertyTextArea.setText("");
					int moveSpaces = dice_roll(propertyTextArea, player[0]);
                                        
                                        while(player[0].isDouble())
                                        {
                                            propertyTextArea.append("Rolling Again!: ");
                                            moveSpaces += dice_roll(propertyTextArea, player[0]);
                                        }
					
					int playerLocation = player[0].getCurrentSpace();
					
                                        int lastLoc = playerLocation;
					
                                        playerLocation =(playerLocation + moveSpaces)%14;
                                        
					
					player[0].setCurrentSpace(playerLocation);

					propertyTextArea.append( "then moves "+ moveSpaces + " spaces to "+property[playerLocation].getName());
                                        
					// if they moved to a lower location by going forward, then they must have passed go.
					if( lastLoc > playerLocation | moveSpaces > 14){ 
						propertyTextArea.append(player[0].getName()+" passed go, and collect $200!");
						player[0].setMoney( player[0].getMoney()+200 );
					}
					propertyTextArea.append("\n");

					propertyTextArea.append("Current Money: "+player[0].getMoney()+"\n");
					
					if(property[playerLocation].getOwner() == -1 && player[0].getMoney() > property[playerLocation].getPrice() )
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
					else if(property[playerLocation].getOwner() == -1)
					{
						buyButton.setEnabled(false);
						dontBuyButton.setEnabled(true);
						propertyTextArea.setText(propertyTextArea.getText()+"\n\n"
												+property[playerLocation].getName()+" is too expensive for you.\n"								
											//			+"Property Owner: Player "+Integer.toString(property[playerLocation].getOwner())+" ("+player[property[playerLocation].getOwner()].getName()+")"+"\n"
														+"Property Owner: Player number "+Integer.toString(property[playerLocation].getOwner())+"\n"
												+"Investment Cost: "+Integer.toString(property[playerLocation].getPrice())+"\n"
												+"Investment Return: "+Integer.toString(property[playerLocation].getRent())+"\n"
												+"Upgrade Costs: "+Arrays.toString(property[playerLocation].getUpgradeCostArray())+"\n"
												+"Interest Income: "+Arrays.toString(property[playerLocation].getRentArray()));
					}	
					else
					{
						buyButton.setEnabled(false);
						dontBuyButton.setEnabled(true);
						propertyTextArea.setText(propertyTextArea.getText()+"\n\n"
												+property[playerLocation].getName()+" is unavailable for purchase.\n"								
											//			+"Property Owner: Player "+Integer.toString(property[playerLocation].getOwner())+" ("+player[property[playerLocation].getOwner()].getName()+")"+"\n"
														+"Property Owner: Player number "+Integer.toString(property[playerLocation].getOwner())+"\n"
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
					if(player[0].getMoney()>property[player[0].getCurrentSpace()].getPrice())
					{
						player[0].setMoney(player[0].getMoney()-property[player[0].getCurrentSpace()].getPrice());
						property[player[0].getCurrentSpace()].setOwner(0);
						board[player[0].getCurrentSpace()].setBackground(new Color(200,255,255));
						propertyTextArea.setText("Property Purchased!");
						
					}
					else
						propertyTextArea.setText("Not enough funds to invest.");
					

					aiMove(propertyTextArea, property, player);
					turnOver(propertyTextArea, property, player, rollDice);
					

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
					
					aiMove(propertyTextArea, property, player);
					turnOver(propertyTextArea, property, player, rollDice);
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
	
	public static void updatePropertyTextArea(int index, JTextArea propertyTextArea, Property[] property, Player[] player)
	{
		  propertyTextArea.setText("Property Selected\n"
	  				+"Property Name: "+ property[index].getName()+"\n");
		  if(property[index].getOwner()==-1)
		  { propertyTextArea.append("Property Owner: Unowned!\n ");}
		  else
			  propertyTextArea.append("Property Owner: "+player[property[index].getOwner()].getName()+"\n");
		  propertyTextArea.append("Investment Cost: "+Integer.toString(property[index].getPrice())+"\n"
									+"Investment Return: "+Integer.toString(property[index].getRent())+"\n"
									+"Upgrade Costs: "+Arrays.toString(property[index].getUpgradeCostArray())+"\n"
									+"Interest Income: "+Arrays.toString(property[index].getRentArray()));
							  		
	}
	
	public static void aiMove(JTextArea propertyTextArea, Property[] property, Player[] player)
	{

		propertyTextArea.setText("AI turn.\n");
		
		for(int i=1; i<4;i++)
		{
			if(player[i].getMoney()>0)
			{
				int moveSpaces = dice_roll(propertyTextArea, player[i]);
                                
				while(player[i].isDouble())
				{
					moveSpaces += dice_roll(propertyTextArea, player[i]);
				}
				
				int playerLocation = player[i].getCurrentSpace();
				
				int lastLoc = playerLocation;
                                
				playerLocation =(playerLocation + moveSpaces)%14;
                                
				player[i].setCurrentSpace(playerLocation);
		
				propertyTextArea.append( "then moves "+ moveSpaces + " spaces to "+property[playerLocation].getName());
                                
				// if they moved to a lower location by going forward, then they must have passed go. also if they go over 14 spaces
				if( lastLoc > playerLocation | moveSpaces > 14 ){ 
					propertyTextArea.append("They collect $200.");
					player[0].setMoney( player[0].getMoney()+200 );
				}
				propertyTextArea.append("\n");
				//propertyTextArea.append("Current Money: "+player[0].getMoney()+"\n");
				
				if(property[playerLocation].getOwner() == -1)
				{
					if(player[i].getMoney()>property[playerLocation].getPrice())
					{
						player[i].setMoney(player[i].getMoney()-property[player[i].getCurrentSpace()].getPrice());
						property[player[i].getCurrentSpace()].setOwner(i);
						propertyTextArea.append(property[player[i].getCurrentSpace()].getName()+" was purchased by "+player[i].getName()+"\n");
					}
						
				}
				else if(property[playerLocation].getOwner() != 0)
				{
					propertyTextArea.append(player[i].getName()+" moved to " +property[player[i].getCurrentSpace()].getName()+"\n");
				}
			}
		}
	}
		
	
	public static void turnOver(JTextArea propertyTextArea, Property[] property, Player[] player, JButton rollDice)
	{
		
		for(int i = 0; i<property.length; i++)
		{
			if(property[i].getOwner()!=-1)
				if(player[property[i].getOwner()].getMoney()>=0)
				{
					player[property[i].getOwner()].setMoney(player[property[i].getOwner()].getMoney()+property[i].getRent());
				}
		}
		for(int i = 0; i<4; i++)
		{
			//TAX TO END THE GAME------------------------------------------------------------------------
			player[i].setMoney(player[i].getMoney()-350);
			if(player[i].getMoney()>=0)
				propertyTextArea.append(player[i].getName()+ " has "+ player[i].getMoney()+"\n");
		}
		
		
		
		
		
		//Game Win conditions
		if(player[0].getMoney()<0)
		{
			propertyTextArea.append("YOU LOST.");
			rollDice.setEnabled(false);
		}
		else if(player[1].getMoney()<0 && player[2].getMoney()<0 && player[3].getMoney()<0)
		{
			propertyTextArea.append("YOU WIN!.");
			rollDice.setEnabled(false);
		}
	}
        
        // Dice rolling function
        // Takes a player, and the log on the page, outputs the total for the roll (between 2 and 12)
        // also sets the players double indicator at true or false
        public static int dice_roll(JTextArea log, Player player)
        {
            int d6_1;
            int d6_2;
            int total;

            d6_1 = (int) (Math.random() * 6)+1;
            d6_2 = (int) (Math.random() * 6)+1;
            total = d6_1 + d6_2;
            
            log.append(player.getName() + " rolls : "+ d6_1 +" " + d6_2 + " ");
            
            if( d6_1 == d6_2)
            {
                log.append("(!) ");
                player.setDouble(true);
            }
            else
            {
                player.setDouble(false);
            }

            return total;
        }
	
}

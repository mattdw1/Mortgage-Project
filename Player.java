/** This is the Player class
 *
 * @author Tracey Glass
 * @version 1.0 November 27, 2014
 */

import java.util.*;

public class Player 
{
	private String 	name			= "";
	private int 	token			= 0;
	private int 	currentSpace	= 0;
	private int		money			= 0;
	private int 	playerNum		= 0;
	private boolean	doubleRoll 		= false;
	
	/** Initialize the Player class with a screen name, token, money, and the player number
	 * 
	 * @param _name			screen name
	 * @param _token		token (integer)
	 * @param _money		money 
	 * @param _playerNum	player's number
	 */
	public Player(String _name, int _token,  int _money, int _playerNum)
	{
		this.setName(_name);
		this.setToken(_token);
		this.setMoney(_money);
		this.setPlayerNum(_playerNum);
	}
	
	/** Initialize the Player class with a screen name, token, and the player number.
	 *  The initialized money will be $1500.
	 *  
	 * @param _name			screen name
	 * @param _token		token (integer)
	 * @param _playerNum	player's number
	 */
	public Player(String _name, int _token, int _playerNum)
	{
		this.setName(_name);
		this.setToken(_token);
		this.setMoney(1500);
		this.setPlayerNum(_playerNum);
	}
	
	/**	Initialize a basic player with a purse of $1500 only.
	 * 
	 */
	public Player()
	{
		this.setMoney(1500);
	}
	
	/** Get the player number for the player object.
	 * 
	 * @return playerNum	the current player number.
	 */
	public int getPlayerNum()
	{
		return playerNum;
	}
	
	/** Set the player number for the player object.
	 * 
	 * @param _playerNum	The new player number
	 */
	public void setPlayerNum(int _playerNum)
	{
		playerNum = _playerNum;
	}
	
	/** Return whether or not the roll was a double
	 * 
	 * @return	doubleRoll	true if the roll was double, otherwise false
	 */
	public boolean isDouble()
	{
		return doubleRoll;
	}
	
	/** Set whether or not the roll was a double
	 * 
	 * @param _doubleRoll	the outcome of whether the roll is double or not
	 */
	public void setDouble(boolean _doubleRoll)
	{
		doubleRoll = _doubleRoll;
	}
	
	/** Get the player's screen name for that player object
	 * 
	 * @return name		the player's current screen name.
	 */
	public String getName()
	{
		return name;
	}
	
	/** Set the screen name for the player object.
	 * 
	 * @param _name		The new screen name
	 */
	public void setName(String _name)
	{
		if(checkName(_name))
			name = _name;
		else
			name = null;
	}
	
	/** Get the amount of money owned by the current player number.
	 * 
	 * @return money	the player's current amount of money.
	 */
	public int getMoney()
	{
		return money;
	}
	
	/** Set the money amount that the player object has.
	 * 
	 * @param _money	The new money amount
	 */
	public void setMoney(int _money)
	{
		money = _money;
	}
	
	/** Get the game space for the player object.
	 * 
	 * @return currentSpace		the player's current space.
	 */
	public int getCurrentSpace()
	{
		return currentSpace;
	}
	
	/** Set the current space the player object is occupying
	 * 
	 * @param _currentSpace		The new current space number
	 */
	public void setCurrentSpace(int _currentSpace)
	{
		currentSpace = _currentSpace;
	}
	
	/** Get the token representing the calling player object.
	 * 
	 * @return token		the player's current token.
	 */
	public int getToken()
	{
		return token;
	}
	
	/** Set the token used by the player object.
	 * 
	 * @param _token	The new token 
	 */
	public void setToken(int _token)
	{
		token = _token;
	}
	
	/** Checks that the name is a maximum of 10 alphabetic characters only
	 * 
	 * @param _name			The player's screen name.
	 * @return boolean		true if the name fits the requirements.
	 * 						false if the name doesn't.
	 */
	private boolean checkName(String _name)
	{
		if(_name.length() > 0)
		{
			if( _name.length() <= 10)
			{
				for(int i = 0; i < _name.length(); i++)
				{
					if(!Character.isAlphabetic(_name.charAt(i)) && !(_name.charAt(i) == ' '))
						return false;				
				}
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
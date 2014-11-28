/** This is the Player class
 *
 * @author Tracey Glass
 * @version 1.0 November 27, 2014
 */

import java.util.*;

public class Player 
{
	private String 	name;
	private int 	token;
	private int 	currentSpace;
	private int		money;
	private int 	playerNum;
	
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
		if(_name.length() > 0 && _name.length() <= 10)
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
}

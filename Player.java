import java.util.*;

public class Player 
{
	private String name;
	private int token;
	private List<Property> properties = new ArrayList();
	private int currentSpace;
	private int money;
	
	public String getName()
	{
		return name;
	}
	
	//If _name doesn't fit criteria, name is set to null.
	public void setName(String _name)
	{
		if(checkName(_name))
			name = _name;
		else
			name = null;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setMoney(int _money)
	{
		money = _money;
	}
	
	//return true if change worked, false if otherwise.
	//choice is 0 if adding to the player's money (being paid)
	//		 is 1 if taking away from player's money (paying)
	public boolean changeMoney(int _money, int choice)
	{
		
		return false;
	}
	
	public int getCurrentSpace()
	{
		return currentSpace;
	}
	
	public void setCurrentSpace(int _currentSpace)
	{
		currentSpace = _currentSpace;
	}
	
	public int getToken()
	{
		return token;
	}
	
	public void setToken(int _token)
	{
		token = _token;
	}
	
	public List<Property> getProperties()
	{
		return properties;
	}
	
	public void setProperties(List<Property> _properties)
	{	
		properties = _properties;
	}
	
	//returns true if the property was added correctly, false otherwise
	public boolean addProperty(Property property)
	{
		try
		{
			List<Property> _properties = getProperties();
			_properties.add(property);
			setProperties(_properties);
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	//If the deletion occurred properly, true is returned, else false is 
	public boolean deleteProperty(Property property)
	{
		List<Property> _properties = getProperties();
		for(int i = 0; i < _properties.size(); i++)
		{
			if(property.equals(_properties.get(i)))
			{
				_properties.remove(i);
				setProperties(_properties);
				return true;
			}
		}
		return false;
	}
	
	//return true if trade went through, false if otherwise
	//trade property to a specified player
	public boolean tradeProperty(Player player, Property property)
	{
		try
		{
			int playerMoney = player.getMoney();
			int tradePrice = property.getTradePrice();
			
			//Make sure trading player can afford if
			if(playerMoney >= tradePrice)
			{
				player.setMoney(playerMoney - tradePrice);
				this.setMoney(this.getMoney() + tradePrice);
				if( player.addProperty(property) && this.deleteProperty(property))
					return true;
				return false;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			return false;	
		}
			
	}
	
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

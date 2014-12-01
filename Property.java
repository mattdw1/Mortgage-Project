/** This is the Property class
 *
 * @author Tracey Glass
 * @version 1.0 November 27, 2014
 */
public class Property 
{
	private int 	price				= 0;
	private String 	name				= "";
	private int 	tradePrice			= 0;
	private int 	owner				= -1;
	private int 	rent				= 0;
	private int[]	rentArray 			= {0,0,0,0,0};
	private int 	numOfUpgrades		= 0;
	private int		upgradeCost			= 0;
	private int[] 	upgradeCostArray	= {0,0,0,0};
	
	/** Initialize a property object with an initial price, the name, the array that
	 *  holds the multiple possible rent prices, and the array that holds the multiple
	 *  possible upgrade prices.
	 * 
	 * @param _price			The buying from the bank
	 * @param _name				The name of the property
	 * @param _rentArray		The array that holds the rent prices (5 values)
	 * @param _upgradeCostArray	The array that holds the upgrade prices (4 values)
	 */
	public Property(int _price, String _name, int[] _rentArray, int[] _upgradeCostArray)
	{
		this.setPrice(_price);
		this.setName(_name);
		this.setRentArray(_rentArray);
		this.setUpgradeCostArry(_upgradeCostArray);
		this.setRent();
		this.setUpgradeCost();
	}
	
	/** Get the current owner of the property object
	 * 
	 * @return owner	the current owner of the property
	 */
	public int getOwner()
	{
		return owner;
	}
	
	/** Set the owner of the property object.
	 * 
	 * @param _owner	The new owner. If 0, then the bank owns it.
	 * 					Otherwise the number represents the player number.
	 */
	public void setOwner(int _owner)
	{
		owner = _owner;
	}
	
	/** Trade a single property between players. May only trade property for money.
	 * 
	 * @return boolean		true if the trade went through, 
	 * 						false if the buying player couldn't afford it.
	 */
	public boolean tradeProperty(Player tradingPlayer, Player receivingPlayer)
	{
		int receivingMoney = receivingPlayer.getMoney();
		int tradingMoney = tradingPlayer.getMoney();
		
		if(receivingMoney >= this.getTradePrice())
		{
			receivingPlayer.setMoney(receivingMoney - this.getTradePrice());
			tradingPlayer.setMoney(tradingMoney + this.getTradePrice());
			this.setOwner(receivingPlayer.getPlayerNum());
			return true;
		}
		else
			return false;
	}
	
	/** Get the price to buy the property from the bank.
	 * 
	 * @return price		the property's initial buying price.
	 */
	public int getPrice()
	{
		return price;
	}
	
	/** Set the price of the property object if bought from the bank
	 * 
	 * @param _price	The new price of the property 
	 */
	public void setPrice(int _price)
	{
		price = _price;
	}
	
	/** Get the price of the property object if bought from another player
	 * 
	 * @return tradePrice		the property's trade price.
	 */
	public int getTradePrice()
	{
		return tradePrice;
	}
	
	/** Set the price of the property object if bought from another player
	 * 
	 * @param _tradePrice	The new trade price of the property
	 */
	public void setTradePrice(int _tradePrice)
	{
		tradePrice = _tradePrice;
	}
	
	/** Get the array of integers that stores the 5 possible rent values
	 * 
	 * @return rentArray	the integer array that stores the 5 possible rent values
	 */
	public int[] getRentArray()
	{
		return rentArray;
	}
	
	/** Set the array of integers to 5 possible rent values. Returns null if 
	 * 	_rentArray is less than or more than 5 values long.
	 * 
	 * @param _rentArray	the new integer array that has the 5 possible rent values.
	 */
	public void setRentArray(int[] _rentArray)
	{
		if(_rentArray.length == 5)
		{
			for(int i = 0; i < _rentArray.length; i++)
			{
				rentArray[i] = _rentArray[i];
			}
		}
		else
		{
			//Keep the previous value of rentArray
		}
	}
	
	/** Get the rent of the property object if landed on by a non-owning player
	 * 
	 * @return rent		the property's rent.
	 */
	public int getRent()
	{
		return rent;
	}
	
	/** Set the rent of the property object if landed on by a non-owning player
	 * 
	 * @param _rent		The new rent of the property
	 */
	private void setRent()
	{
		int[] rentArr = getRentArray();
		rent = rentArr[getNumOfUpgrades()];
	}
	
	/** Get the name of the property object.
	 * 
	 * @return name		the name of the property.
	 */
	public String getName()
	{
		return name;
	}
	
	/** Set the name of the property
	 * 
	 * @param _name		The new name of the property
	 */
	public void setName(String _name)
	{
		name = _name;
	}
	
	/** Get the current number of upgrades made to a property object
	 * 
	 * @return numOfUpgrades		the number of upgrades done to a property
	 */
	public int getNumOfUpgrades()
	{
		return numOfUpgrades;
	}
	
	/** Set the number of upgrades made to the property object. When set, update
	 *  the cost to upgrade and the new rent.
	 * 
	 * @param _numOfUpgrades		The new number of upgrades done to a property
	 */
	public void setNumOfUpgrades(int _numOfUpgrades)
	{
		numOfUpgrades = _numOfUpgrades;
		this.setUpgradeCost();
		this.setRent();
	}
	
	/** Gets the array that hold the 4 prices to upgrade the property object
	 * 
	 * @return upgradeCostArray		The array holding the 4 prices to upgrade
	 */
	public int[] getUpgradeCostArray()
	{
		return upgradeCostArray;
	}
	
	/** Sets the array that holds the 4 prices to upgrade the property object.
	 * 	Sets upgradeCostArray to null if _upgradeCostArray isn't 4 values.
	 * 
	 * @param _upgradeCostArray		the new upgradeCostArray
	 */
	public void setUpgradeCostArry(int[] _upgradeCostArray)
	{
		if(_upgradeCostArray.length == 4)
		{
			for(int i = 0; i < _upgradeCostArray.length; i++)
			{
				upgradeCostArray[i] = _upgradeCostArray[i];
			}
		}
		else
		{
			//Keep the array as is
		}
	}
	
	/** Get the cost of upgrading the property object
	 * 
	 * @return upgradeCost		the cost to upgrade the property
	 */
	public int getUpgradeCost()
	{
		return upgradeCost;
	}
	
	/** Called after setNumOfUpgrades gets changed. upgradeCost will be the array
	 *  index of the new numOfUpgrades + 1.
	 * 
	 */
	private void setUpgradeCost()
	{
		int upgradeNum = getNumOfUpgrades();
		int[] upgradeArray = getUpgradeCostArray();
		if(upgradeNum < 4)
			upgradeCost = upgradeArray[upgradeNum++];
		else
			upgradeCost = Integer.MAX_VALUE;
	}
	
	/** Upgrades the property, depending on the player's money and number of upgrades
	 * 
	 * @param player	the player doing the upgrade
	 * @return boolean	true if the player has enough money to upgrade and the
	 * 					property hasn't had 4 or more upgrades done
	 */
	public boolean upgradeProperty(Player player)
	{
		int currentUpgrades = this.getNumOfUpgrades();
		
		if(currentUpgrades < 4)
		{
			if(player.getMoney() > this.getUpgradeCost())
			{
				setNumOfUpgrades(++currentUpgrades);
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
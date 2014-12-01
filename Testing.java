
public class Testing 
{
	public static void main(String[] args)
	{
		Player player = new Player();
		Player player2 = new Player("Julia", 2, 1500, 2);
		Player player3 = new Player("Matt", 3, 3);
		
		player.setCurrentSpace(3);
		System.out.println(player.getCurrentSpace());
		System.out.println(player2.getToken());
		player3.setDouble(true);
		System.out.println(player3.isDouble());
		
		//One character
		player.setName("T");					//1 char - True
		System.out.println(player.getName());
		
		//Without spaces
		player.setName("TraceyKay");			//9 chars - True
		System.out.println(player.getName());
		
		player.setName("TraceyKaye");			//10 chars - True
		System.out.println(player.getName());
		
		player.setName("TraceyKayeG");			//11 chars - False
		System.out.println(player.getName());
		
		//With spaces
		player.setName("Tracey Ka");			//9 chars - True
		System.out.println(player.getName());
		
		player.setName("Tracey Kay");			//10 chars - True
		System.out.println(player.getName());
		
		player.setName("Tracey Kaye");			//11 chars - False
		System.out.println(player.getName());
		
		//With special characters
		player.setName("Tracey-Ka");			//9 chars - False
		System.out.println(player.getName());
		
		player.setName("Tracey$Kay");			//10 chars - False
		System.out.println(player.getName());
		
		player.setName("Tracey!Kaye");			//11 chars - False
		System.out.println(player.getName());
		
		//Checks that can't have numbers of any length, appropriate or not
		player.setName("123456789");			//9 chars - False
		System.out.println(player.getName());
		
		player.setName("0123456789");			//10 chars - False
		System.out.println(player.getName());
		
		player.setName("1");					//1 chars - False
		System.out.println(player.getName());
		
		player.setName("01234567890");			//11 chars - False
		System.out.println(player.getName());
		
		//Checks for empty string		
		player.setName("");						//0 chars - False
		System.out.println(player.getName());
		
		int[] rentArray = {25,50,75,150,300};
		int[] badRentArray = {25};
		int[] upgradeArray = {100,200,300,400};
		int[] badUpgradeArray = {100,200,300,400};
		Property prop = new Property(300, "Boardwalk", rentArray, upgradeArray);
		prop.setRentArray(badRentArray);
		prop.setUpgradeCostArry(badUpgradeArray);
		
		System.out.println(prop.getOwner());
		
		prop.setOwner(player.getPlayerNum());
		
		System.out.println(prop.getOwner());
		
		prop.setTradePrice(1800);
		prop.tradeProperty(player, player2);
		prop.setTradePrice(100);
		prop.tradeProperty(player, player2);
		
		System.out.println(prop.getName());
		System.out.println(prop.getPrice());
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
		System.out.println(prop.upgradeProperty(player));
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
		System.out.println(prop.upgradeProperty(player));
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
		System.out.println(prop.upgradeProperty(player));
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
		player.setMoney(0);
		System.out.println(prop.upgradeProperty(player));
		player.setMoney(1500);
		System.out.println(prop.upgradeProperty(player));
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
		System.out.println(prop.upgradeProperty(player));
		System.out.println(prop.getRent());
		System.out.println(prop.getUpgradeCost());
	}
}

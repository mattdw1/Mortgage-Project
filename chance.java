/** This is the Chance card class.
 *
 * @author Brian Fairbanks
 * @version 1.0 November 27, 2014
 */

 
 /*
	Unused chance ideas
	
	"IRS Audit Season.  Roll a die.  6 or less get audited, and loose their next turn.", // too much work too be done?
	"Ramshackle Shack Sale!  The bank will buy properties valued under $300 for double right now!",
*/

public class Chance {
    
    // Dice rolling function
    // Takes no input, outputs the total for the roll (between 2 and 12)
    // also sets the global variable for if doubles were just rolled.
    int dice_roll()
    {
        int d6_1;
        int d6_2;

        d6_1 = (int) (Math.random() * 5)+1;
        d6_2 = (int) (Math.random() * 5)+1;

        if( d6_1 == d6_2)
        {
            System.out.println("Rolled doubles");
            //player.setDouble(true);
        }
        else
        {
            //player.setDouble(false);
        }
        return d6_1 + d6_2;
    }

    // Picks a random chance card, and plays it
    void pick_chance()
    {
        int choice = (int) (Math.random() * (6 + 1)); 

        switch (choice) {
            case 1:
                chance_1();
                break;
            case 2:
                chance_2();
                break;
            case 3:
                chance_3();
                break;
            case 4:
                chance_4();
                break;
            case 5:
                chance_5();
                break;
        }
    }
    
    // Chance Card
    // The stock market plummeted!  All players lose (5-25)% of their current funds!
    void chance_1(){
        int value;
        int percent;
        
        value = (int) (Math.random() * (25-5))+5;
        percent = (100-value)/100;
                
        System.out.println("The stock market plummeted!  All players lose "+value+"% of their current funds!");
        /*
        for each player in playerList{
            player.setMoney((int) player.getMoney * percent)
        }
        */
    }
    
    // Chance Card
    // Great month for the stock market!  All players earn an extra (5-20)% of their current funds!
    void chance_2(){
        int value;
        int percent;
        
        value = (int) (Math.random() * (20-5))+5;
        percent = ((value)/100)+1;
                
        System.out.println("Great month for the stock market!  All players earn an extra "+value+"% of their current funds!");
        /*
        for each player in playerList{
            player.setMoney((int) player.getMoney * percent)
        }
        */
    }
    
    
    // Chance Card
    // Flash Floods!  Renovations cost $(25-100) for each property owned!
    void chance_3(){
        int value;
        
        value = (int) (Math.random() * (100-25))+25;
                
        System.out.println("Flash Floods! Renovations cost $"+value+" for each property owned!");
        /*
        for (int x = 0; x < playerList.length; x++){
            int playCash = 0;
            for each property in propertyList{
                if (property.owner == x){
                    playCash += value;
                }
            }
            playerList[x].setMoney(playerList[x].getMoney - playCash);
        }
        */
    }
    
    // Chance Card
    // Bank Error!  Each player passes (5-20)% of their money to the player on the left!
    void chance_4(){
        int value;
        int percent;
        
        value = (int) (Math.random() * (20-5))+5;
        percent = ((value)/100);
                
        System.out.println("Bank Error!  Each player passes "+value+"% of their money to the player on the left!");
        /*
        int monArr [playerList.length];
        
        // get get percentages all at once
        for (int x = 0; x < playerList.length; x++){
            int curMoney;         
            player* curPlayer = playerList[x];
            curMoney = curPlayer.getMoney()*percent;
        
            monArr[x] = curMoney;
        }
        
        // add/take from all players
        for (int x = 0; x < playerList.length; x++){
            int leftNum = (x+1)%playerList.length;
            player* playLeft = playerList[leftNum];
            player* curPlayer = playerList[x];
            
            curPlayer.setMoney( curPlayer.getMoney() - monArr[x] )
            leftPlayer.setMoney( leftPlayer.getMoney() + monArr[x] )
        }
        */
    }
    
    // Chance Card
    // Zombie Scare! All players leave, the city, and return to the start position when safe. (move all players back to start)
    void chance_5(){
        
        System.out.println("Zombie Scare! All players leave, the city, and return to the start position when safe.");

        /*
        for each player in playerList{
            player.setCurrentSpace(0);
        }
        */
    }
    
}
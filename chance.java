
import javax.swing.JTextArea;

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
    
    public static void pick_chance(JTextArea log, Property[] properties, Player[] players)
        {
            int choice = (int) (Math.random() * (3)+1);
            
            log.append("Chance card rolled: " + choice + "\n");

            switch (choice) {
                case 1:
                    Chance.chance_1(log, players);
                    break;
                case 2:
                    Chance.chance_2(log, players);
                    break;
                case 3:
                    Chance.chance_3(log, players, properties);
                    break;
                case 4:
                    //chance_4();
                    break;
                case 5:
                    //chance_5();
                    break;
            }
        }
    
           // Chance Card
        // The stock market plummeted!  All players lose (5-25)% of their current funds!
        static void chance_1(JTextArea log, Player[] players){
            int value;
            int percent;

            value = (int) (Math.random() * (25-5))+5;
            percent = (100-value)/100;

            log.append("The stock market plummeted!  All players lose "+value+"% of their current funds!\n");
            
            // for each player, decrease money for rolled ammount
            for (Player player:players){
                player.setMoney((int) player.getMoney() * percent);
                log.append(player.getName()+" now has $" + player.getMoney() + "\n");
            }
        }
        
        // Chance Card
        // Great month for the stock market!  All players earn an extra (5-20)% of their current funds!
        static void chance_2(JTextArea log, Player[] players){
            int value;
            int percent;

            value = (int) (Math.random() * (20-5))+5;
            percent = ((value)/100)+1;

            log.append("Great month for the stock market!  All players earn an extra "+value+"% of their current funds!");
            
            // for each player, increase money for rolled ammount
            for (Player player:players){
                player.setMoney((int) player.getMoney() * percent);
                log.append(player.getName()+" now has $" + player.getMoney() + "\n");
            }
        }
        
        // Chance Card
        // Flash Floods!  Renovations cost $(25-100) for each property owned!
        static void chance_3(JTextArea log, Player[] players, Property[] properties){
            int value;

            value = (int) (Math.random() * (100-25))+25;

            log.append("Flash Floods! Renovations cost $"+value+" for each property owned!");

            for (int x = 0; x < players.length; x++){
                int playCash = 0;
                for (Property property:properties){
                    if (property.getOwner() == x){
                        playCash += value;
                    }
                }
                players[x].setMoney(players[x].getMoney() - playCash);
            }
        }
}
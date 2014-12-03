
import javax.swing.JTextArea;

/**
 *
 * @author Akuma
 */
public class Britesting {
        public static void test(){
            
            JTextArea req = new JTextArea();
            
            // setting up default property list
            Property properties[] = new Property[10];
            for(int i = 0; i<10; i++)
            {
                int[] rentPrice = {(i+1)*20, (i+1)*30, (i+1)*40, (i+1)*60, (i+1)*90};
                int[] upgradePrice = { (i+1)*60, (i+1)*70, (i+1)*100, (i+1)*150};
                properties[i] = new Property((i+1)*100, "Property "+Integer.toString(i), rentPrice , upgradePrice);
            }
            

            // testing player array creation
            Player players[] = new Player[4];
            for(int x = 0; x < 4; x++)
            {
                    players[x] = new Player();
                    players[x].setName("Player");
                    players[x].setMoney(1000+x*500);
            }
            printData(players);
            

            // testing dice rolls 500 times
            System.out.println("Testing dice rolling.  Will put any out of bounds errors on a new line");
            for (int rollnum = 1; rollnum <= 500; rollnum++)
            {
                    int curroll = mortgage.dice_roll(req, players[0]);
                    // Testing roll values
                    System.out.printf(" %2d",curroll);

                    // testing going out of expected range
                    if (curroll < 2 | curroll > 12)
                    {
                            System.out.printf("\n ERROR!  SHOULD NOT ROLL %d !\n",curroll);
                    }
                    // testing doubles
                    if (players[0].isDouble())
                    {
                            System.out.print("(D)");
                    }
                    else {
                            System.out.print("   ");	// match the same character number, for double or not for spacing purposes.
                    }
                    if(rollnum%25==0){System.out.println();};
            }
            
            
            //testing chance 1 5 times
            for (int x = 0; x < 5; x++)
            {
                System.out.println("running chance card 1, percent decrease");
                Chance.chance_1(req, players);
                printData(players);
            }

            //testing chance 2 5 times
            for (int x = 0; x < 5; x++)
            {
                    System.out.println("running chance card 2, percent increase");
                    Chance.chance_2(req, players);
                    printData(players);
            }

            System.out.println("Giving 0 property to player 0");
            
            properties[0].setOwner(1);
            System.out.println("Giving 1 property to player 0");
            
            properties[1].setOwner(2);
            properties[2].setOwner(2);
            System.out.println("Giving 2 property to player 0");
            
            properties[3].setOwner(3);
            properties[4].setOwner(3);
            properties[5].setOwner(3);
            System.out.println("Giving 3 property to player 0");
            
            //testing chance 3 5 times
            for (int x = 0; x < 5; x++)
            {
                System.out.println("running chance card 3, cost per property");
                Chance.chance_3(req, players, properties);
                printData(players);
            }

            //testing chance 4 5 times
            for (int x = 0; x < 5; x++)
            {
                System.out.println("running chance card 4, rotating player cash");
                Chance.chance_4(req, players);
                printData(players);
            }
            
            for(int x = 0; x < 4; x++)
            {
                players[x].setCurrentSpace(2*x);
                System.out.printf("Moved player%d to space %d\n", x, 2*x);
            }
            printData(players);
            System.out.println("running chance card 5, moving players");
            Chance.chance_5(req, players);
            printData(players);
    }


    public static void printData(Player[] players){
            System.out.println("");
            for(Player player:players){
                    System.out.printf("%s $%5d - property %d\n", player.getName(), player.getMoney() , player.getCurrentSpace());
            }
            System.out.println("");
    }
}
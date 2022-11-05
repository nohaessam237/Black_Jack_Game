
package blackjack;
import java.util.Scanner;
public class BlackJack {

    static Game game = new Game();
    
    public static void main(String[] args) {
    GUI gui = new GUI();
     game.generate();
        
        
        
    game.setPlayersInfo();
   
    gui.runGUI( game.Deck,
            game.players[0].hand,
            game.players[1].hand, 
            game.players[2].hand,
            game.players[3].hand);
    playerTurns( gui);
   game. updateScore( 0);
   game. updateScore( 1);
   game. updateScore( 2);
   game. updateScore( 3);


    DealerTurns(gui);
  
     game. updateScore( 3);

   

    check();
    
    
    
    }

    public static void playerTurns(GUI gui) {

        Scanner scanner = new Scanner(System.in);
        int input = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("player " + game.players[i].name + "'S turn");
             


            while(game.players[i].Score < 21){

            System.out.println("your score now is " + game.players[i].Score);
            System.out.println("********************************");
            System.out.println("If you want to HIT press 1");
            System.out.println("If you want to STAND press 2");
            input = scanner.nextInt();

               
                if (input == 1) 
                    {
                        //game.draw(i);
                        
                         gui.updatePlayerHand(game.draw(i),i);
                         
                        //game.players[i].addCard(card);
                        if (game.players[i].Score > 21)
                        {
                            game.players[i].busted = true;
                            System.out.println("BUSTED and your score is " + game.players[i].Score);
                            System.out.println("********************************");

                            break;
                        } 
                        else if (game.players[i].Score == 21)
                        {
                            game.players[i].blackJack = true;
                            System.out.println(game.players[i].name+" get Blackjack and your score is " + game.players[i].Score);
                             break;
                        }

                    }
                else
                    {
                        System.out.println("STAND " + game.players[i].name + "'s score is " + game.players[i].Score);
                        break;
                    }

                
            }
            

        }
        System.out.println("######################################################################");

    }
    public static void DealerTurns(GUI gui)
    {
      while (true) {
                //game.draw(3);
                gui.updateDealerHand(game.draw(3), game.Deck);
             if (game.players[3].blackJack || game.players[3].busted || game.players[3].Score > game.updateGameScore()) {
                System.out.println("Dealer's score is "+game.players[3].Score);

                    break;
                
            }
            
      }
             
            if (game.players[3].Score>21) {
                System.out.println("Dealer is BUSTED");
               
            } 
            
            else {
                if (game.players[3].Score == game.updateGameScore()) {
                    System.out.println("Dealer is PUSHED");
                    
                }

            }
            
        
}

    /*public static int highScore() {
        int highScore = 0;
        for (int i = 0; i < 3; i++) {
            if (game.highScores[i] > highScore && game.highScores[i] <= 21) {
                highScore = game.highScores[i];
            }
        }
        return highScore;
    }*/
   

    public static void check() {
//
//        //all busted
//        for (int i = 0; i < 4; i++) {
//            if (game.highScores[i] > 21) {
//                System.out.println("The player " + game.players[i].name + "is BUSTED");
//            }
//        }
//
//        //one wins
//        int win = 0;
//        int x = 0;
//        for (int i = 0; i < 4; i++) {
//            if (game.highScores[i] > x && game.highScores[i] <= 21) {
//                x = game.highScores[i];
//                win = i;
//                System.out.println("333333333333333333333333333333333333333333333333333333333333333333333333");
//            }
//
//        }
//        if (win >= 0) {
//            System.out.println(game.players[win].name + " is the winner with the highest Score " + game.players[win].Score);
//        }

        //one to one  
        
        
      int winner=0;
      int winnerNum=0;
      
      for(int i=0;i<4;i++)
      {
          
         if(game.players[i].Score==game.updateGameScore())
         {winner++;
         winnerNum=i;
         }
         
         
      }
      if(winner==1)
      {System.out.println(game.players[winnerNum].name+" IS WINNER ");}
      else if(winner>1)
      {System.out.println("PUSHED ");}
  
    }

}
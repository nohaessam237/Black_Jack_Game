
package blackjack;



import java.util.Random;
import java.util.Scanner;

public class Game {
    
    
    public Player[] players=new Player[4];//عدد اللاعبين
    public Card[]Deck=new Card[52];//الكوتشينة
    public int []highScores=new int [4];//سكور التلاتة والديلر
    
    public void generate()//تكوين الكوتشينة
    {
      int k =0;
        for (int i=0; i<4; i++)
       {
           for(int j=0; j<13 ; j++)
           {
               int value=0;
               if(j>=10){
                   value=10;
               }
               
               else 
               {
                   value=j+1;
               }
               Deck[k] =new Card (i,value,j);
              k++;
           }
           
       }

    
   }
    
    
  
    public Card draw(int i) //intial card draw
  {
//        Random rand =new Random();
//         C card =null;
//         int randomNo = 0;
//          while(card==null)
//         {   randomNo = rand.nextInt(52);
//         
//            card=Deck[randomNo];
//       }
//        Deck[randomNo]=null;
//        players[i].addCard(card);
//       return card;
       Random rand =new Random();
       Card card =null;
       int randomNo = 0;
         while (true)
         {
             
        randomNo = rand.nextInt(52); 
        if (Deck[randomNo]!=null)
        {
            
             card =Deck[randomNo];
              Deck[randomNo]=null;
              
              break;
        }
         }
        players[i].addCard(card);
         return card;
    }
      public void setPlayersInfo()
    {players[0]=new Player();
     players[1]=new Player();
     players[2]=new Player();
     players[3]=new Player();//dealer
     
    
    System.out.println("What is first player's name?");     
    Scanner scan =new Scanner(System.in); 
    players[0].name=scan.next();
    draw(0);
    draw(0);

    System.out.println("What is seconed player's name?");     
    players[1].name=scan.next();
    draw(1);
    draw(1);

    System.out.println("What is Thired player's name?");     
    players[2].name=scan.next();
    draw(2);
    draw(2);
    
    players[3].name = "Dealer";
    draw(3);
    draw(3);

    }
     
    public int updateGameScore()
    {
        for(int i=0;i<3;i++)
            {
         
            if (players[i].Score>21)
                 players[i].bustedScore = 0;
             else
                 players[i].bustedScore = players[i].Score;
        }
        
        return Math.max(players[0].bustedScore, Math.max(players[1].bustedScore, players[2].bustedScore));
        

    }
    public void updateScore(int x)
    {
    int score=0;
    for(int i=0;i<players[x].i;i++)
    {
        score+=players[x].hand[i].getValue();
    }
    players[x].Score = score;
    }

}
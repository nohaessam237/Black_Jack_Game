/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Player {
    
   public String name;
   public int Score=0;
   Card[]hand=new Card[11];
   boolean busted = false;
   boolean blackJack = false;
   int bustedScore;
   int i =0;
  public void addCard (Card card)
      {
          if(i<11){
              hand[i]=card;
              Score+=card.getValue();
            i++;
          }
      }

  
   public Card []getHand ()
   {return this.hand;}
}


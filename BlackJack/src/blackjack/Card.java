/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Card {
       
    
    private final int suit;
    private final int value;
    private final int  Rank;
    
    
    
   /* int[] rank=new int[13];
    int[]value=new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};*/
    public Card(int s,int v,int r)
    {
        suit=s;
        value=v;
        Rank=r;
        
    }
    public Card(Card c)//parmeter of the same type of class
    {
      this.Rank=c.Rank;
      this.suit=c.suit;
      this.value=c.value;
        
        
    }
    
    public int getSuit()
    {return this.suit;}
    
    public int getValue()
    {return this.value;}
    
    public int getRank()
    {return this.Rank;}
    
  
    
    
}

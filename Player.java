import java.util.ArrayList; 
import java.util.Scanner;  
import java.util.Random;

public class Player{
   protected ArrayList<Card> hand = new ArrayList<Card>();
   
   
   public player()
   {
      for(int i=0;i<8;i++)
      fish();
            
    }
    
    public ArrayList<Card> giveCard(Card cardType)
    {
    //count all cards computer ask and give them to computer remove from hand
    
    
    }
    
    protected boolean askFor (Card cardType)
    {
     //ask for cards if computer have them add to the hand
    
    }
    
    protected void draw()
    {
    //draw card? when?
    
    }
    
    public int getSet()
    {
      return numSet;
    }
    
    protected Card checkForSet()
    {
    //count all same card in hand if them number equal to 4 they are a set and remove from hand
      ArrayList<Card> set = new ArrayList<Card>(); 
        for(int i=0;i<hand.size();i++)
            if (hand.get(i) == cardType)
              set.add(hand.get(i));
              
        for(int j=0;j<set.size();j++)
            hand.remove(cardType);
            
        return set;
    }
    
    

}
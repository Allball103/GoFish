
import java.util.HashSet;
import java.util.Scanner;  
import java.util.Random;

public class Player{
	
//variables
	Card[] hand;
	
//methods
 
   public Player(Card[] mine) {
	   hand = mine;
	}

public void player()
   {
     
            
    }
   
 
   //Print out what cards are in a hand
   public void printHand() {
	   System.out.println("hand:");
   	  	int count = 0;
   		for(int i = 0; i < hand.length; i++) {
   		info(hand[i]);
   		if(hand[i] != null) {
   		count++;
   		}
   		}
   		System.out.println("Number of cards: "+count+"\n");	
   		}

   //Print out the information about a card
   public void info(Card card) {
   	//if the card object is null, print nothing
   	if (card != null) {
   	
   	String s = card.getSuit();
   	int r = card.getRank();
   	
   	// number   1    11   12   13 
   	// rank     A    J    Q    K
   	
   	switch(r) {
   		case 1:
   			System.out.println(s+" "+"A");	
   			break;
   		case 11:
   			System.out.println(s+" "+"J");	
   			break;
   		case 12:
   			System.out.println(s+" "+"Q");	
   			break;
   		case 13:
   			System.out.println(s+" "+"K");
   			break;
   		default:
   			System.out.println(s+" "+r);	
   	}
   	}
   }


   //Draw a card by making the pool hand object null, and creating a same
   //object in the same index for either my hand or computer hand
   public void drawACard(Card[] from) {
   	for(int i = 0; i < from.length; i++) {
   		if(from[i] != null) {
   			hand[i] = new Card(from[i].getSuit(),from[i].getRank());
   			//from[i] = null;
   			i = from.length;
   			}
   		}			
   			
   	}


   //Sort the hand in ascending order as the hand changes
   public void sort() {
       for(int i=0;i<hand.length;i++){
           for(int j=0;j<hand.length;j++){
           	if(hand[i] != null && hand[j] != null && hand[i].getRank()<hand[j].getRank()){
                   int tempr=hand[i].getRank();
                   String temps=hand[i].getSuit();           
                   hand[i].setRank(hand[j].getRank());
                   hand[i].setSuit(hand[j].getSuit());
                   hand[j].setRank(tempr);
                   hand[j].setSuit(temps);
                   
               }

           }
       }
   }

   //Ask the other side what rank is needed
    public String askRank() {
   	HashSet<Integer> set = new HashSet<Integer>();
   	for(int i = 0; i < hand.length; i++) {
   		if(hand[i] != null) {
   		set.add(hand[i].getRank());
   	}}
   	System.out.println("What rank do you want to ask for?");
   	for(int i : set) {
   		switch(i) {
   		case 1:		System.out.println('A');break;
   		case 11:	System.out.println('J');break;
   		case 12:	System.out.println('Q');break;
   		case 13:	System.out.println('K');break;
   		default:	System.out.println(i);
   		}
   	}
   	
    Scanner in = new Scanner(System.in);
   	String card = in.nextLine();
   	System.out.println("\n");
   	return card;
   }

	public Card checkHand(String currentCard) {
		
		int card = 0;
		if (currentCard.equals("A")) {
			card = 1;
		}
		
		else if (currentCard.equals("J")) {
			card = 11;
		}
		
		else if (currentCard.equals("Q")) {
			card = 12;
		}
		
		else if (currentCard.equals( "K")) {
			card = 13;
		}
		
		else {
			
		card = Integer.parseInt(currentCard);
		}
		
		
	   	for(int i = 0; i < hand.length; i++) {
	   		if(hand[i] != null) {
	   			if (hand[i].getRank()==card) {
	   				
	   				return hand[i];
	   				
	   				
	   	}}}
		return null;
	     		
		
	}

	public void addCard(Card card) {
		
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {	
		
			 hand[i] = card;
			 i = hand.length;
			}
		}
			}

	public void removeCard(Card card) {
		for(int i = 0; i < hand.length; i++) {
	   		if(hand[i] != null) {
	   			if (hand[i].equals(card)) {
	   				hand[i] = null;
	}
	   		}}}

    

}
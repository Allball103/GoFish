import java.util.HashSet;
import java.util.Scanner;  
import java.util.Random;
import java.io.*;

public class Player{
	
//variables
	Card[] hand;
        int sets;
	
//methods
//Constructors 
 public Player(Card[] mine) {
	   hand = mine;
}

public void player()
   {
     
            
    }
   
 
   //Print out what cards are in the player's hand (will never be called for computer)
   public void printHand() {
       
	   System.out.println("Your Hand:");
           GoFish.pause(500);
   	   int count = 0;
   		for(int i = 0; i < hand.length; i++) {
   		info(hand[i]);
   		if(hand[i] != null) {
   		count++;
   		}
   		}
                //add a blank line for clarity and then print number of cards
                System.out.println();
   		System.out.println("Number of cards: "+count+"\n");	
   		}
   
   //same as printHand() but saves to a file instead of to the console
   public void saveHand(boolean computer) {
       try{
           PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"), true)); 
           if(computer == true){
                pw.println("Computer's hand:");
           } else {
                pw.println("Player's hand:");
           }    
           pw.close();
           int count = 0;
   		for(int i = 0; i < hand.length; i++) {
   		saveInfo(hand[i]);
   		if(hand[i] != null) {
   		count++;
   		}
   		}
                //add a blank line for clarity
                pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"), true)); 
                pw.println();
                pw.close();

        } catch(IOException e) {
            System.out.println("Could not print to file");
        }
        
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
   			System.out.print(s+" "+"A ");	
   			break;
   		case 11:
   			System.out.print(s+" "+"J ");	
   			break;
   		case 12:
   			System.out.print(s+" "+"Q ");	
   			break;
   		case 13:
   			System.out.print(s+" "+"K ");
   			break;
   		default:
   			System.out.print(s+" "+r+" ");	
   	}
   	}
   }
   
   //same as info but saves to a file instead of printing
   public void saveInfo(Card card){
       //if the card object is null, print nothing
   	if (card != null) {
         try{
            PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"), true)); 

           String s = card.getSuit();
           int r = card.getRank();

           // number   1    11   12   13 
           // rank     A    J    Q    K

           switch(r) {
                   case 1:
                           pw.print(s+" "+"A ");	
                           break;
                   case 11:
                           pw.print(s+" "+"J ");	
                           break;
                   case 12:
                           pw.print(s+" "+"Q ");	
                           break;
                   case 13:
                           pw.print(s+" "+"K ");
                           break;
                   default:
                           pw.print(s+" "+r+" ");	
           }
           pw.close();
   	} catch (IOException e) {
            System.out.println("Could not print to file");
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
   //Made by Tau
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
       checkForSet();
   }
   
//check for set and remove from hand
//made by Will Wuttke
public void checkForSet(){
    //this array has one element for each rank (1-13) that will count how many of each rank are in the hand
      int[] data  = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      int set = 0;
      boolean isSet = false;
      
      for(int i = 0;i < hand.length; i++){
          if(hand[i] != null){
         int current = hand[i].getRank();
         if(data[current] < 3){
            data[current] +=1;
         }else{
             set = current;
             isSet = true;
             }
         }
      }
      if(isSet == true){
        sets+=1;
        System.out.println("Current player has a new set!");
        for(int i = 0;i < hand.length; i++){
            if(hand[i] != null){
              if(hand[i].getRank() == set){
                removeCard(hand[i]);
            }
        }}
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

    //checks a players hand and returns a card if that card is in the players hand
	public Card checkHand(String currentCard) {
		
		int card = 0;
		//converts letters to rank
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
		
		//loop that checks
	   	for(int i = 0; i < hand.length; i++) {
	   		if(hand[i] != null) {
	   			if (hand[i].getRank()==card) {
	   				
	   				return hand[i];
	   				
	   				
	   	}}}
		return null;
	     		
		
	}
//adds a card to the hand
	public void addCard(Card card) {
		hand[51] = card;
                sort();
                
        }
		/*for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {	
		
			 hand[i] = card;
			 i = hand.length;
			}
		}
			}*/
//removes a card from the hand
public void removeCard(Card card) {
	for(int i = 0; i < hand.length; i++) {
	   if(hand[i] != null) {
	   	if (hand[i].equals(card)) {
	   	hand[i] = null;
	}
	   		}}}

    

}

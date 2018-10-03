
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.ArrayList;;

//The Computer class is responsible for all the actions that the Computer can make and extends the Player class
//Made by Aaron Wise

public class Computer extends Player {

	//variables
	Card[] hand;
    boolean smart;
   
  //methods
  //Constructors 
	public Computer(Card[] mine, boolean diff) {
		
		super(mine);
		hand = mine;
        smart = diff;
       
	}

	//Ask the other side what rank is needed
	 //Made by Aaron Wise and Tao Xu
	 public String askRank() {
		 
	
		 
		 //if Hard difficulty was set in the settings
		 if (smart) {
		 
		//read in turn data
		 Vector<String> inPlayerHand = new Vector();
		 boolean pFished = false;
	        try{
	        File file = new File("GoFishTurnData.txt");
	        Scanner sc = new Scanner(file);
	       
	        
	        while (sc.hasNextLine()) {
	        	String[] sInput = sc.nextLine().split(",");
	       
	        	
	    		//converts letters to rank
	    		if (sInput[0].equals("A")) {
	    			sInput[0] = "1";
	    		}
	    		
	    		else if (sInput[0].equals("J")) {
	    			sInput[0] = "11";
	    		}
	    		
	    		else if (sInput[0].equals("Q")) {
	    			sInput[0] = "12";
	    		}
	    		
	    		else if (sInput[0].equals("K")) {
	    			sInput[0] = "13";
	    		}
	    		
	        	
	    		//seperates turn data into what the computer thinks is in the players hand
	        	if(sInput[1].equals("False") && sInput[2].equals("False") ) {
	        		inPlayerHand.add(sInput[0]);
	        		
	        		pFished = true;
	        	}
	        	else if(sInput[1].equals("False") && sInput[2].equals("True") ) {
	        		inPlayerHand.add(sInput[0]);
	        		
	        		pFished = false;
	        	}
	        	else if(sInput[1].equals("True") && sInput[2].equals("False") ) {
	        		
	        		
	        	}
	        	else if(sInput[1].equals("True") && sInput[2].equals("True") ) {
	        		for(int i = 0; i < inPlayerHand.size();i++) {
	        			if(inPlayerHand.get(i).equals(sInput[0])) {
	        				inPlayerHand.remove(i);
	        				i = inPlayerHand.size();
	        			}
	        		}
	        		
	        	}
	    	
	        }
	        
	        //start of computer picking choices to ask
	        Vector<Integer> smartChoices = new Vector();
	        
	        //Checks player hand against what it thinks the player has and if there are matches adds them to smartChoices
	        for(int i = 0; i < inPlayerHand.size();i++) {
	        	for(int j = 0; j < hand.length;j++) {
	        		if(hand[j] != null) {
	        			
	        		if(inPlayerHand.get(i).equals(hand[j].getRank()+"")) {
	        			
		        		smartChoices.add((hand[j].getRank()));
	        		
		        	}
	        		}
	        	}
	        }
	        
	        //If player went fishing checks hand for multiples and adds to smart choices. (only if smartChoices is still empty)
	        if(pFished) {
	        
	        	
	        if(smartChoices.isEmpty()) {
	        	
	        	for(int i = 0; i < hand.length;i++) {
	        		
	        		int flag = 0;
	        		for(int j = 0; j < hand.length;j++) {
	        			if(hand[i]!=null) {
	        				if(hand[j]!=null) {
	        			if(hand[i].getRank() == hand[j].getRank() ) {
	        				
	        				if (i != j) {
	        				
	        					
	        				smartChoices.add(hand[i].getRank());
	        				
	        				}
	        			}
	        				}
	        		}
	        		}
	        	}
	        	
	        }
	        //Default hand added to smartChoices if still empty
	        if(smartChoices.isEmpty()) {
	        	for(int i = 0; i < hand.length; i++) {
			   		if(hand[i] != null) {
			   		smartChoices.add(hand[i].getRank());
			   		
			   		}
	        	
	        }
	        	
	        }
	       
	        }
	        
	        
	        else {
	        	
	        	if(smartChoices.isEmpty()) {
	        	for(int i = 0; i < hand.length;i++) {
	        		
	        		int flag = 0;
	        		for(int j = 0; j < hand.length;j++) {
	        			if(hand[i]!=null) {
	        				if(hand[j]!=null) {
	        			if(hand[i].getRank() == hand[j].getRank() ) {
	        				
	        				if (i != j) {
	        				
	        				
	        				smartChoices.add(hand[i].getRank());
	        				
	        				}
	        			}
	        		}
	        		}
	        		}
	        		}
	        	for(int i = 0; i < hand.length; i++) {
			   		if(hand[i] != null) {
			   		smartChoices.add(hand[i].getRank());
			   		
			   		}
	        	}
	        }
	   
	        }
	       
	      	//A choice is randomly picked from smartChoice and returned
 	        Random rand = new Random();
 		   	
 		   	int output = rand.nextInt(smartChoices.size());
 		   	return smartChoices.get(output)+"";
	        }
	        catch(IOException e){
	            System.out.println("Could not open file");
	        }
		 }
		 
		 
		 //When Difficulty is set to easy
		 
		//A choice is randomly picked from hand and returned
		 Vector<Integer> choices = new Vector();
		   	for(int i = 0; i < hand.length; i++) {
		   		if(hand[i] != null) {
		   		choices.add(hand[i].getRank());
		   	}}
		 	
			
		   	Random rand = new Random();
		   	
		   	int output = rand.nextInt(choices.size());
		   	return choices.get(output)+"";
	 }
		   
		   
	//checks a players hand and returns a card if that card is in the players hand
	//Made by Aaron Wise
public Card checkHand(String currentCard, int percentLying) {
	
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
   				
   				Random rand = new Random();
   				int chance = rand.nextInt(101);
   				
   				if(chance > percentLying)
   					return hand[i];
   				
   				
   	}}}
	return null;
     		
	
}
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.ArrayList;;

public class Computer extends Player {

	Card[] hand;
    boolean smart;
   
        
	public Computer(Card[] mine, boolean diff) {
		
		super(mine);
		hand = mine;
        smart = diff;
       
	}

	 public String askRank() {
		 
	
		 
		 
		 if (smart) {
		 
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
	        
	     
	        Vector<Integer> smartChoices = new Vector();
	        
	        for(int i = 0; i < inPlayerHand.size();i++) {
	        	for(int j = 0; j < hand.length;j++) {
	        		if(hand[j] != null) {
	        			
	        		if(inPlayerHand.get(i).equals(hand[j].getRank()+"")) {
	        			
		        		smartChoices.add((hand[j].getRank()));
	        		
		        	}
	        		}
	        	}
	        }
	        
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
	        System.out.println(smartChoices.size()); 	
 	        Random rand = new Random();
 		   	
 		   	int output = rand.nextInt(smartChoices.size());
 		   	return smartChoices.get(output)+"";
	        }
	        catch(IOException e){
	            System.out.println("Could not open file");
	        }
		 }
		 
		 
		 
		 
		 Vector<Integer> choices = new Vector();
		   	for(int i = 0; i < hand.length; i++) {
		   		if(hand[i] != null) {
		   		choices.add(hand[i].getRank());
		   	}}
		 	
			
		   	Random rand = new Random();
		   	
		   	int output = rand.nextInt(choices.size());
		   	return choices.get(output)+"";
	 }
		   // Scanner in = new Scanner(System.in);
		   	//String card = in.nextLine();
		   	//System.out.println("\n");
		   	//return card;
		   

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

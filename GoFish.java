import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class GoFish {

	public static void main(String[] args) {
		System.out.println("Welcome to Gofish Game!\n");
//************************ Start********************************
		
		//************************ Check Start********************************
//		System.out.println("*************************** Game started ***********************"
//				+ " \n\nPool deck:");
//		printArray(deck);
//		System.out.println("Computer deck:");
//		printArray(comp);
//		System.out.println("My deck:");
//		printArray(mine);
//		reset(deck,mine,comp);
//		System.out.println("Reseted pool deck:");
//		printArray(deck);
//		System.out.println("Reseted my deck:");
//		printArray(mine);
//		System.out.println("Reseted computer deck:");
//		printArray(comp);
		


	//************************ Check End********************************
		
		
		
		runInterface();
//*********************** End**********************************
	}
	
//*************************** Methods ********************************
	
//Run interface method loop that asks for user input on what to do next
public static void runInterface() {
		
		String nextState = "";
		boolean cont = true;
		
		while(cont==true) {
		nextState = mainMenu();
		
		if(nextState.equals("Exit")) {
			cont = false;
		}
		
		else if(nextState.equals("Play")) {
			game();
		}
		
		else if(nextState.equals("Settings")) {
			settings();
		}
		
		else {
			System.out.println("INVALID COMMAND");
		}
			
		}
	}

	

//Settings console interface
public static void settings() {
	System.out.println("What would you like to do?");
    //basically same as mainMenu except using player getter and setters to change behaviour
	
}

//start game
public static void game() {
		
//setting up decks for the players
	Card[] deck = new Card[52];
	Card[] mine = new Card[52];
	Card[] comp = new Card[52];
	
	reset(deck,mine,comp);
//	System.out.println("Unshuffled pool deck:");
//	printArray(deck);
//	System.out.println("Shuffled pool deck:");
	shuf(deck);
//	printArray(deck);
	
	//Have 7 cards for each side
	for(int i = 0; i < 7; i++) {
		drawACard(mine,deck);
		drawACard(comp,deck);
	}
	
			// setting up variables
			Player player = new Player(mine);
			Computer computer = new Computer(comp);
			String currentCard;
			Card card;
			
			//for loop for ten turns
			for(int i = 0; i < 10; i++) {
				
			//start of players turn
			player.sort();
			player.printHand();
			currentCard = player.askRank();
			card = computer.checkHand(currentCard);
			System.out.println("You ask for " + currentCard );
			//if card found
			if (card != null) {
				System.out.println("Computer had that card!");
				player.addCard(card);
				computer.removeCard(card);
				
			}
			//if card not found
			else {
			System.out.println("Computer says Go Fish");
			player.drawACard(deck);
			for(int j = 0; j < deck.length; j++) {
		   		if(deck[j] != null) {
			   			
			   				deck[j] = null;
			   				j = deck.length;
			   				
		   	}}
			}
			
			
			//start of computers turn
			computer.sort();
			//computer.printHand();
			currentCard = computer.askRank();
			System.out.println("Computer asks for any " + currentCard );
			card = player.checkHand(currentCard);
			//if card found
			if (card != null) {
				System.out.println("You Had It. Computer took your " + currentCard);
				computer.addCard(card);
				player.removeCard(card);
				
			}
			//if card not found
			else {
				System.out.println("You dont have it. Computer Goes Fishing");
				computer.drawACard(deck);
				for(int k = 0; k < deck.length; k++) {
					if(deck[k] != null) {
			   			
		   				deck[k] = null;
		   				k = deck.length;
		   				
					}}
				
			}
			
			}
			

	}

//shuffle a card deck
public static void shuf(Card[] arr) {
		  int ran, tempr;
		  String temps;
		  Random random = new Random();
		  for (int i = arr.length - 1; i > 0 ; i--){
//			  get a random integer number from 0 to 51 for 51 times
		      ran = random.nextInt(i+1);
//		      switch the value of that index with each value on the array   
		      tempr = arr[ran].getRank();
		      temps = arr[ran].getSuit();
		      arr[ran].setRank(arr[i].getRank());
		      arr[ran].setSuit(arr[i].getSuit());
		      arr[i].setRank(tempr); 
		      arr[i].setSuit(temps);
		  }
	}



//Make the pool deck unsorted, my deck and computer deck have nothing
public static void reset(Card[] p,Card[] m,Card[] c) {
	for(int i = 0; i < 13; i++) {	
		p[i] = new Card("Diamond",i+1);
		p[i+13] = new Card("Club",i+1);
		p[i+26] = new Card("Spade",i+1);
		p[i+39] = new Card("Heart",i+1);
	}
	for(int j = 0; j < p.length; j++) {
		m[j] = null;
		c[j] = null;
	}
}


//Draw a card by making the pool deck object null, and creating a same
//object in the same index for either my deck or computer deck
public static void drawACard(Card[] to, Card[] from) {
	for(int i = 0; i < from.length; i++) {
		if(from[i] != null) {
			to[i] = new Card(from[i].getSuit(),from[i].getRank());
			from[i] = null;
			i = from.length;
			}
		}			
			
	}



//main menu
public static String mainMenu(){
   
    	System.out.println("What would you like to do?");
        System.out.println("Type 'Play' to play game");
        System.out.println("Type 'Exit' to exit");
        System.out.println("Type 'Setting' to change settings");
        
        Scanner in = new Scanner(System.in);
               
        String nextState = in.nextLine();
        
        
        return nextState;
}
}

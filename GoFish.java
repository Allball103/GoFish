import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

//main game class
public class GoFish {
        public static boolean SmartComp = false;
        public static int percentLying = 0;
        
	public static void main(String[] args) {
		System.out.println("Welcome to Go Fish!\n");
                pause(1000);
                System.out.println("This program will allow you to play Go Fish against a computer opponent.");
                pause(1000);
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
//Made by Will Wuttke
public static void settings() {
	String nextState = "";
		boolean cont = true;
		
		while(cont==true) {
		nextState = settingsMenu();
		
		if(nextState.equals("Exit")) {
                        cont = false;
                        runInterface();
		}
		
		else if(nextState.equals("Difficulty")) {
                        System.out.println("Type 'Hard' to give the computer perfect memory.");
                        System.out.println("Type 'Easy' to give the computer no memory. This is the default game setting.");
                        
			Scanner in = new Scanner(System.in);
        
                        String difficulty = in.nextLine();
                        if(difficulty.equals("Hard")){
                            GoFish.SmartComp = true;
                        } else if(difficulty.equals("Easy")){
                            GoFish.SmartComp = false;
                        } else{
                            System.out.println("Command not recognized, computer difficulty is unchanged");
                        }
		}
		
		else if(nextState.equals("Lying")) {
			 System.out.println("Enter an integer value 0 to 100");
			 Scanner in = new Scanner(System.in);
                         int liechance = in.nextInt();
                         
                         if(liechance>=0 && liechance <= 100){
                            percentLying = liechance;
                         } else {
                             System.out.println("Command not recognized, lying chance is unchanged");
                         }			
		}
		
		else {
			System.out.println("Command not recognized, please try again!");
		}
			
		}
	
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
			Computer computer = new Computer(comp,GoFish.SmartComp);
			String currentCard;
			Card card;
                        
                        //create the PrintWriter file; will either make a new file or delete the contents of the old file and start fresh
                        try{
                        PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"))); 
                        pw.println("Welcome to Go Fish!");
                        pw.close();
                        } catch(IOException e){
                            System.out.println("Could not print to file");
                        }
                        
                        //create the PrintWriter file; will either make a new file or delete the contents of the old file and start fresh
                        try{
                        PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishTurnData.txt"))); 
                        //pw.println("Welcome to Go Fish!");
                        pw.close();
                        } catch(IOException e){
                            System.out.println("Could not print to file");
                        }
                        
			//for loop for ten thousand turns
			for(int i = 0; i < 10000; i++) {
				
			//start of players turn
			player.sort();
                        gameOver(player,computer);
			player.printHand();
                        player.saveHand(false);
                        
			currentCard = player.askRank();
			card = computer.checkHand(currentCard, percentLying);
			System.out.println("You ask for any " + currentCard+"s" );
                        pause(500);
                        
			//if card found
			if (card != null) {
				System.out.println("Computer had " + currentCard+"s!");
                                pause(500);
				player.addCard(card);
                                saveMove(currentCard,false,true);
				computer.removeCard(card);
                                gameOver(player,computer);
			}
			//if card not found
			else {
			System.out.println("Computer says Go Fish");
                        pause(500);
                        saveMove(currentCard,false,false);
			player.drawACard(deck);
			for(int j = 0; j < deck.length; j++) {
		   		if(deck[j] != null) {
			   			
			   				deck[j] = null;
			   				j = deck.length;
			   				
		   	}}
			}
			
			
			//start of computers turn
			computer.sort();
                        gameOver(player,computer);
			computer.printHand();
                        computer.saveHand(true);
			currentCard = computer.askRank();
			System.out.println("Computer asks for any " + currentCard+"s" );
                        pause(500);
			card = player.checkHand(currentCard);
			//if card found
			if (card != null) {
				System.out.println("You Had It. Computer took your " + currentCard+"s");
                                pause(500);
				computer.addCard(card);
                                saveMove(currentCard,true,true);
				player.removeCard(card);
                                gameOver(player,computer);
				
			}
			//if card not found
			else {
				System.out.println("You dont have it. Computer Goes Fishing");
                                pause(500);
                                saveMove(currentCard,true,false);
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
   
//saves a move to the file (asking for a card and whether the card was found)
//made by Will Wuttke
public static void saveMove(String card, boolean computer, boolean found){
    try{
        
        PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"), true)); 
        PrintWriter pw2 = new PrintWriter(new FileOutputStream( new File("GoFishTurnData.txt"), true));
        
        if(computer == true && found == true ){
            pw.println("Computer successfully asked the player if they had any "+card+"s");
            pw2.println(card+",True,True");
        } else if(computer == true && found == false){
            pw.println("Computer asked the player if they had any "+card+"s, but was told to Go Fish");
        	pw2.println(card+",True,False");
        } else if(computer == false && found == true){
            pw.println("Player successfully asked the Computer if they had any "+card+"s");
            pw2.println(card+",False,True");
        } else{
            pw.println("Player asked the Computer if they had any "+card+"s, but was told to Go Fish");
            pw2.println(card+",False,False");
        }
        pw.println();
        
        pw.close();
        pw2.close();
        
    } catch(IOException e){
        System.out.println("Could not print to file");    }
}

//main menu
//made by Aaron Wise
public static String mainMenu(){
   
    	System.out.println("What would you like to do?");
        System.out.println("Type 'Play' to start a game of Go Fish");
        System.out.println("Type 'Exit' to exit");
        System.out.println("Type 'Settings' to change various game settings, such as difficulty");
        
        Scanner in = new Scanner(System.in);
               
        String nextState = in.nextLine();
        
        
        return nextState;
}

//submenu from the main menu
//made by Will Wuttke
public static String settingsMenu(){
        System.out.println("What would you like to change?");
        System.out.println("Type 'Difficulty' to change the Computer's memory ability");
        System.out.println("Type 'Lying' to set the Computer's ability to lie");
        System.out.println("Type 'Exit' to go back to the main menu");
        
        Scanner in = new Scanner(System.in);
        
        String nextState = in.nextLine();
        
        return nextState;
}

//method that pauses between prints to increase readability.
//made by Will Wuttke
public static void pause(int time){
    try {
        Thread.sleep(time); 
    } catch (Exception e) {
        e.printStackTrace();
    }    

}

public static void gameOver(Player player, Player computer){
    boolean gameOver = false;
    boolean playerWins = false;
    
    if(player.sets >=7){
        gameOver = true;
        playerWins = true;
    }else if(computer.sets >=7 ){
        gameOver = false;
        playerWins = false;
}
    if(gameOver == true){
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream( new File("GoFishData.txt"), true)); 
       
            if(playerWins == true){
                System.out.println("You win!");
                pw.println("You win!");
            } else{
                System.out.println("The computer wins!");
                pw.println("The computer wins!");
        }
         } catch(IOException e){
            System.out.println("Could not print to file");
            
        }
        runInterface();
    }
}
}

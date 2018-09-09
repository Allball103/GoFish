import java.util.Random;
public class GoFish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Gofish Game!\n");
		
		
//***************   52 cards into array and shuffle them ************
		
		Card[] deck = new Card[52];
		Card[] mine = new Card[52];
		Card[] comp = new Card[52];
		
		reset(deck,mine,comp);
		System.out.println("Unshuffled pool deck:");
		printArray(deck);
		System.out.println("Shuffled pool deck:");
		shuf(deck);
		printArray(deck);
		

		
//****************** Get cards ready ************************************

		
		//Have 7 cards for each side
		for(int i = 0; i < 7; i++) {
			drawACard(mine,deck);
			drawACard(comp,deck);
		}
//************************ Check ********************************
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
		
		
	}
	
	
	
	
	
	
	
//*************************** Methods ********************************

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

//Print out what cards are in a deck
public static void printArray(Card[] arr) {
	  	int count = 0;
		for(int i = 0; i < arr.length; i++) {
		info(arr[i]);
		if(arr[i] != null) {
		count++;
		}
		}
		System.out.println("Number of cards: "+count+"\n");	
		}

//Print out the information about a card
public static void info(Card card) {
	//if the card object is null, print nothing
	if (card == null) {
		return;
	}
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

}

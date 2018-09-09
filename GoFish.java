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
		//Check
		System.out.println("*************************** Game started ***********************"
				+ " \n\nPool deck:");
		printArray(deck);
		System.out.println("Computer deck:");
		printArray(comp);
		System.out.println("My deck:");
		printArray(mine);
		reset(deck,mine,comp);
		System.out.println("Reseted pool deck:");
		printArray(deck);
		System.out.println("Reseted my deck:");
		printArray(mine);
		System.out.println("Reseted computer deck:");
		printArray(comp);
	}
	
	
	
	
	
	
	
//*************************** Methods ********************************
	
	static void shuf(Card[] arr) {
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
	
	static void printArray(Card[] arr) {
	  	int count = 0;
		for(int i = 0; i < arr.length; i++) {
		info(arr[i]);
		if(arr[i] != null) {
		count++;
		}
		}
		System.out.println("Number of cards: "+count+"\n");	
		}
	
	



public static void info(Card card) {
		// TODO Auto-generated method stub
	if (card == null) {
		return;
	}
	String s = card.getSuit();
	int r = card.getRank();
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

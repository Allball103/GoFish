import java.util.Random;
import java.util.ArrayList;
public class GoFish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Gofish Game!\n");
		
		
//***************   52 cards into array and shuffle them ************
		
		Card[] deck = new Card[52];
		for(int i = 0; i < 13; i++) {	
			deck[i] = new Card("Diamond",i+1);
			deck[i+13] = new Card("Club",i+1);
			deck[i+26] = new Card("Spade",i+1);
			deck[i+39] = new Card("Heart",i+1);
		}
		
		
		printArray(deck);
		shuf(deck);
		printArray(deck);
		

		
//****************** Get cards ready ************************************
		ArrayList<Card> mine = new ArrayList<Card>();
		ArrayList<Card> comp = new ArrayList<Card>();

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
		count++;
		}
		System.out.println("Number of cards: "+count+"\n");	
		}
	
	



public static void info(Card card) {
		// TODO Auto-generated method stub
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
}

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Computer extends Player {

	Card[] hand;
        boolean smart;
        
	public Computer(Card[] mine, boolean diff) {
		super(mine);
		hand = mine;
                smart = diff;
	}

	 public String askRank() {
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
		   }

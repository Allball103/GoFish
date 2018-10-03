//Card representation with suits, ranks, getters, and setters
//Class by Tao Xu
public class Card {

	private String suit;
	private int rank;
	Card(){
		suit = "";
		rank = 0;
	}
	Card(String s, int r){
		suit = s;
		rank = r;
	}
	public String getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
	public void setSuit(String s) {
		this.suit = s;
	}
	public void setRank(int r) {
		this.rank = r;
	}
}

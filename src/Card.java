/*********
 * カードクラス
*********/


public class Card{
	//Range of value and suit the Card can take
	public static final int[] av_num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	public static final String[] av_suit = {"Spade", "Heart", "Diamond", "Club"};
	
	private int num;
	private String suit;
	
	//Constructor
	public Card(int n, String s){
		num = n;
		suit = s;
	}
	
	
	public int getSuitRate(){
		
		for(int i = 0; i < av_suit.length; i++){
			if(this.suit.equals(av_suit[i])){
				return i;
			}
		}
		return 999;
	}
	
	//getter function
	public int getNum(){
		return this.num;
	}
	
	//Override the Object.toString()
	public String toString(){
		return (num + " of " + suit);
	}
}
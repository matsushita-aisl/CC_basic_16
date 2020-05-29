


public class Deck {
	
	public static final int INIT_SIZE = Card.av_suit.length * Card.av_num.length;
	
	public Card[] cards;
	
	//Constructor
	public Deck(){
		
		cards = new Card[INIT_SIZE];
		int i = 0;
		
		for(String suit: Card.av_suit){
			for(int num: Card.av_num){
				
				cards[i] = new Card(num, suit);
				i++;
			}
		}
		this.shuffle();
	}
	
	
	public void shuffle(){
		
		for(int i = 0; i < INIT_SIZE; i++){
			
			int r = (int)(Math.random()*(double)INIT_SIZE);
			Card buf = this.cards[i];
			
			this.cards[i] = this.cards[r];
			this.cards[r] = buf;
		}	
	}
	
	
	public Card Draw(){
		
		Card res = this.cards[0];
		Card[] n_cards = new Card[this.cards.length - 1];
		
		for(int i = 0; i < n_cards.length; i++){
			n_cards[i] = cards[i + 1];
		}
		
		this.cards = n_cards;
		
		return res;
	}
}

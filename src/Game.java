import java.util.Scanner;



public class Game {
	
	static final int MIN_BET = 1, MAX_BET = 20;
	
	static Scanner scanner = new Scanner(System.in);
	
	private Player player;
	private Card hand, field;
	private Deck deck;
	public static int bet, earn, handStrength, fieldStrength;
	
	
	public Game(){
		
		player = new Player(0, 10);
		deck = new Deck();
		hand = deck.Draw();
		System.out.println("********Num. of Chip and Your Hand********\n"
				+ player.getStatus() + "\n"
				+ "Hand : " + hand + "\n"
				+ "************************************");
	}


	public Game(Player p){
		
		player = p;
		deck = new Deck();
		hand = deck.Draw();
		System.out.println("********Num. of Chip and Your Hand********\n"
				+ player.getStatus() + "\n"
				+ "Hand : " + hand + "\n"
				+ "************************************");
	}

	
	public void betChip(){
		
		String str;
		System.out.println();
		
		while(true){
			
			System.out.print("Input BET amount (Min:" + MIN_BET + " - Max:" + MAX_BET + ") > ");
			str = scanner.next();
			
			try{
				bet = Integer.parseInt(str);
			}catch(NumberFormatException e){
				System.out.println("[Err] Invalid!! Please input number");
				continue;
			}
			
			if(MIN_BET <= bet && bet <= MAX_BET){
				player.earn(-bet);
				break;
			}else{
				System.out.println("[Err] Out of Range!! Please input again");
			}
		}
	}
	
	
	public int play(){
		
		String str;
		boolean choice;	
		field = deck.Draw();
		System.out.println();
		
		while(true){
			System.out.print("Choice Big or Small !! (0:Big, 1:Small) > ");
			str = scanner.next();
			
			if(str.equals("0")){
				choice = true;
				break;
			}else if(str.equals("1")){
				choice = false;
				break;
			}else{
				System.out.println("[Err] Invalid!! Please input again");
			}
		}
		
		if(!printResult(choice)){
			System.out.println("\n******** YOUR SCORE ********\n" + player.getStatus());
			return confirmNewGame();

		}else if(player.getScore() == 0){
			player.earn(earn);
			System.out.println("Congratulations!!\n" + player.getStatus());
			return 2;
			
		}else if(confirmContinue()){
			return 1;
		}
		
		return confirmNewGame();
	}
	
	
	public boolean printResult(boolean choice){
		
		boolean res = false;
		String BoS = null, sentence = null;
		
		String choiceDisp = choice ? "Big" : "Small";
		
		handStrength = hand.getNum();
		fieldStrength = field.getNum();
		
		if(hand.getNum() == field.getNum()){
			handStrength += hand.getSuitRate();
			fieldStrength += field.getSuitRate();
		}
		
		if((handStrength < fieldStrength && choice) ||
				(handStrength > fieldStrength && !choice)){
			earn = bet*2;
			BoS = "Bigger";
			sentence = "Win!!!\n" + "You earned " + bet + " chip!";
			res = true;
		}else{
			earn = 0;
			BoS = "Smaller";
			sentence = "Lose...";
			res = false;
		}
		
		System.out.println("\n******** Big or Small ********\n"
				+ "BET : " + "bet\n"
				+ "CHOICE : " + choiceDisp + "\n"
				+ "HAND : " + hand + "\n"
				+ "DREW : " + field + "\n"
				+ field + " is " + BoS + " than " + hand + "\n"
				+ "********************************\n"
				+ sentence);
		
		bet = 0;
		return res;
		
	}
	
	private boolean confirmContinue(){
		
		String str;
		System.out.println();
		
		
		while(true){
			System.out.print("Continue this game with the " + earn + " Chip you earned?? (0:Yes, 1:No) > ");
			str = scanner.next();
			
			if(str.equals("0")){
				return true;
			}else if(str.equals("1")){
				player.earn(earn);
				return false;
			}else{
				System.out.println("[Err] Invalid!! Please input again");
			}
		}
	}
	
	
	private int confirmNewGame(){
		
		String str;
		System.out.println();
		
		while(true){
			System.out.print("Continue with new deck ?? (0:Yes, 1:No) > ");
			str = scanner.next();
			
			if(str.equals("0")){
				return 1;
			}else if(str.equals("1")){
				return 2;
			}else{
				System.out.println("[Err] Invalid!! Please input again");
			}
		}
	}
	
	//getter
	public Player getPlayer(){
		return player;
	}
}

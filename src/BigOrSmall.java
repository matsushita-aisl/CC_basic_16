
public class BigOrSmall{

	
	public static void main(String[] args){
		
		Game game = new Game();
		int res;

		while(true){
			game.betChip();
			res = game.play();
			
			if(res == 1){
				game = new Game(game.getPlayer());
			}else if(res == 2){
				break;
			}
		}	
	}
}

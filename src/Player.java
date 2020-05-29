
public class Player {
	
	static final int SMALL = 1, BIG = 10;
	
	private int chip_s, chip_b, score;
	
	
	public Player(int s, int b){
		this.chip_s = s;
		this.chip_b = b;
		score = this.chip_b*BIG + this.chip_s*SMALL;
	}
	
	
	public void update(){
		this.chip_b += this.chip_s/BIG;
		this.chip_s = this.chip_s%BIG;
		score = this.chip_b*BIG + this.chip_s*SMALL;
	}
	
	
	public void earn(int e){
		this.chip_b += e/BIG;
		this.chip_s += e%BIG;
		
		if(this.chip_s < 0){
			this.chip_b --;
			this.chip_s += BIG;
		}
		update();
	}
	
	//getter functions
	public int getChip_b(){
		return this.chip_b;
	}
	public int getChip_s(){
		return this.chip_s;
	}
	public int getScore(){
		return this.score;
	}
	public String getStatus(){
		return "score : " + this.score
				+ ", [" + BIG + "] : " + this.chip_b
				+ ", [" + SMALL + "] : " + this.chip_s;
	}
}

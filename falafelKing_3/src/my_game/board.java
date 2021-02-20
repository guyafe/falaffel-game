package my_game;
import game.Game;
import shapes.TextLabel;

public class board {
	private int saladAmount;
	private int hummusAmount;
	private int falafelAmount;
	private int friesAmount;
	private final int maxAmount=3;
	private int delay=20;
	private int currentDelay=0;
	private final int minDelay=6;
	
	public board() {
		
	
	}

	public void generateDish(){
		this.falafelAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.saladAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.friesAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.hummusAmount=(int) ((Math.random())*this.maxAmount)+1;

		TextLabel txt =(TextLabel) Game.UI().canvas().getShape("hummusAmount");
		txt.getLabel().setText(String.valueOf(this.hummusAmount)); 

		txt =(TextLabel) Game.UI().canvas().getShape("saladAmount");
		txt.getLabel().setText(String.valueOf(this.saladAmount)); 

		txt =(TextLabel) Game.UI().canvas().getShape("friesAmount");
		txt.getLabel().setText(String.valueOf(this.friesAmount)); 

		txt =(TextLabel) Game.UI().canvas().getShape("falafelAmount");
		txt.getLabel().setText(String.valueOf(this.falafelAmount)); 

		Game.UI().canvas().hide("full");
	}

	public int getDelay(){
		return this.delay;
	}

	public int getCurrentDelay(){
		return this.currentDelay;
	}
	
	public int getMinDelay(){
		return this.minDelay;
	}

	public void setDelay(int delay){
		this.delay=delay;
	}

	public void setCurrentDelay(int currentDelay){
		this.currentDelay=currentDelay;
	}

	public int getHummusAmount(){
		return this.hummusAmount;
	}

	public int getSaladAmount(){
		return this.saladAmount;
	}

	public int getFriesAmount(){
		return this.friesAmount;
	}

	public int getFalafelAmount(){
		return this.falafelAmount;
	}

	public int reduceHummus(){
		if (this.hummusAmount>0){ 
		this.hummusAmount--;
		}
		return this.hummusAmount;
	}

	public int reduceSalad(){
		if(this.saladAmount>0){
		this.saladAmount--;
		}
		return this.saladAmount;
	}

	public int reduceFries(){
		if(this.friesAmount>0){
		this.friesAmount--;
		}
		return this.friesAmount;
	}

	public int reduceFalafel(){
		if(this.falafelAmount>0){
		this.falafelAmount--;
		}
		return this.falafelAmount;
	}

	public boolean isComplete(){
		if (this.hummusAmount==0 && this.saladAmount==0 && this.friesAmount==0 && this.falafelAmount==0){
			return true;
		}
		return false;
	}
	
}

package my_game;
import game.Game;
import my_game.Topping.top;
import shapes.TextLabel;

public class board {

	public enum amountLabel{
		falafel (270,530),  
		salad (485,473),
		fries (302,455),
		hummus (495,540);
		private final int xLocation, yLocation;
		private amountLabel(int xLocation, int yLocation) {
			this.xLocation = xLocation;
			this.yLocation = yLocation;
		
		}
		public int xLocation() {
			return xLocation;
		}
		public int yLocation() {
			return yLocation;
		}
		public amountLabel next() {
			if (this.ordinal()==amountLabel.values().length-1){
				return null;
			}
			return amountLabel.values()[this.ordinal()+1]; 
			
		}
    }
	
	
	private int[] amount= new int[top.values().length];
	private final int maxAmount=3;
	private int delay=20;
	private int currentDelay=0;
	private final int minDelay=6;
	
	public board() {
		
	
	}

	public void generateDish(){

		for (int i = 0; i < amount.length; i++) {
			this.amount[i]=(int) ((Math.random())*this.maxAmount)+1;
			TextLabel txt =(TextLabel) Game.UI().canvas().getShape(top.values()[i].toString()+"Amount");
			txt.getLabel().setText(String.valueOf(this.amount[i])); 
		} 

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

	public int[] getAmount(){
		return this.amount;
	}
	public int reduceToppingAmount(top t){	 
		if (this.amount[t.ordinal()]>0){
			this.amount[t.ordinal()]--;
		}
		return this.amount[t.ordinal()];
	}

	public boolean isComplete(){
		boolean complete=true;
		for (int i = 0; i < amount.length; i++) {
			if(this.amount[i]!=0){
				complete =false;
			}
		}
		return complete;
	}
	
}

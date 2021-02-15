package my_game;

import javax.imageio.ImageIO;

import DB.ExcelTable;
import game.ShapeListener;
import main.MyContent;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import shapes.TextLabel;

public class board implements ShapeListener,BoardListener {
	private final String sprayImg = "resources/spray.png";
	private final String sprayImgID = "spray";
	private int fliesTimes = 0;
	private final int fliesArrival = 5;
	private int saladAmount;
	private int hummusAmount;
	private int falafelAmount;
	private int friesAmount;
	private final int maxAmount = 3;
	private int delay = 42;
	private int currentDelay = 0;
	private final int minDelay = 25;
	
	
	public board() {//הגדרנו מקבל מהמחלקה שחקן שמקבל את הנתונים הרלוונטיים - צריך אחר כך לשלב את זה במחלקת הלוח//
		
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

	public String getSprayImg(){
		return this.sprayImg;
	}

	public String getSprayImgID(){
		return this.sprayImgID;
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

	public int getFliesTime(){
		return this.fliesTimes;
	}

	public int getFliesArrival(){
		return this.fliesArrival;
	}

	public void setFliesTime(int time){
		this.fliesTimes=time;
	}

	public void playerLostTheGame(){//למה צריך את זה?
		Game.UI().canvas().deleteShape("lives");
		Image img = new Image("over", "resources/game_over.jpg", 500, 500, 200, 300);
		Game.UI().canvas().addShape(img);

	}

	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		Game.UI().canvas().hide("flies");
		this.fliesTimes=0;
		Game.UI().canvas().show("gas");
	}





	@Override
	public void shapeRightClicked(String shapeID, int x, int y) {
		// 
	}
	@Override
	public void mouseEnterShape(String shapeID, int x, int y) {
		//

	}
	@Override
	public void mouseExitShape(String shapeID, int x, int y) {
		//

	}
	@Override
	public void shapeMoved(String shapeID, int dx, int dy) {
		//
	}
	@Override
	public void shapeStartDrag(String shapeID) {
		//

	}
	@Override
	public void shapeEndDrag(String shapeID) {
		// 

	}
	
	
}

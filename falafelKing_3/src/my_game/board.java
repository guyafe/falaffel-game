package my_game;

import javax.imageio.ImageIO;

import DB.ExcelTable;
import game.ShapeListener;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;

public class board implements ShapeListener,BoardListener {
	private final String sprayImage;
	private final String sprayImageID;
	private int saladAmount;
	private int hummusAmount;
	private int falafelAmount;
	private int friesAmount;
	private final int maxAmount=3;
	
	public board() {//הגדרנו מקבל מהמחלקה שחקן שמקבל את הנתונים הרלוונטיים - צריך אחר כך לשלב את זה במחלקת הלוח//
	
		generateDish();
		
		// costomers... (myplayer)
	   this.sprayImage = "resources/1.png";
	   this.sprayImageID = "spray"; 
	}

	public void generateDish(){
		this.falafelAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.saladAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.friesAmount=(int) ((Math.random())*this.maxAmount)+1;
		this.hummusAmount=(int) ((Math.random())*this.maxAmount)+1;
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

	public void reduceHummus(){
		if (this.hummusAmount>0){ 
		this.hummusAmount--;
		}
	}

	public void reducesalad(){
		if(this.saladAmount>0){
		this.saladAmount--;
		}
	}

	public void reducefries(){
		if(this.friesAmount>0){
		this.friesAmount--;
		}
	}

	public void reducefalafel(){
		if(this.falafelAmount>0){
		this.falafelAmount--;
		}
	}

	public boolean isComplete(){
		if (this.hummusAmount==0 && this.saladAmount==0 && this.friesAmount==0 && this.falafelAmount==0){
			return true;
		}
		return false;
	}
	   public void playerLostTheGame(){

	   }//המימוש של הפונקציה יהיה ציור על המסך שנגמר - הליסטנר של הבורד// 
	   //צריך להוסיף תמונה של gameover//


	
	// public String getBGid(){
	// 	return this.BGimageID;
	// }

	// public String getBGimg(){
	// 	return this.BGimage;
	// }
	

	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		//
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

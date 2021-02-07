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

	
	public board() {//הגדרנו מקבל מהמחלקה שחקן שמקבל את הנתונים הרלוונטיים - צריך אחר כך לשלב את זה במחלקת הלוח//
	
		
		
		// costomers... (myplayer)
	   this.sprayImage = "resources/1.png";
	   this.sprayImageID = "spray"; 
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

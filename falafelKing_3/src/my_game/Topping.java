package my_game;

import DB.ExcelTable;
import game.MouseHandler;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import game.ShapeListener;
import gui.GameCanvas;
import main.MyContent;

public class Topping implements ShapeListener {
	//  private GameCanvas canvas = Game.UI().canvas();
	// private MyContent content = new MyContent();

	public enum top{
		falafel (300,510),  //סתם ערכים כרגע. לשנות ככה שיתאים בלוח
		Salad (490,410),
		fries (300,410),
		hummus (500,510);
		private final int xLocation, yLocation;
		private top(int xLocation, int yLocation) {
			this.xLocation = xLocation;
			this.yLocation = yLocation;
		}
		public int xLocation() {
			return xLocation;
		}
		public int yLocation() {
			return yLocation;
		}
		public top next() {
			if (this.ordinal()==top.values().length-1){
				return null;
			}
			return top.values()[this.ordinal()+1]; //לוודא שעובד
		}
    }
	
	private final top location;
	private final String img;
	private final String imgID;
	private final int initialQuantity=10;
	private int quantity;
	private boolean visible;
	// private GameCanvas canvas;

	public Topping(top location) {
		this.location=location;
		this.imgID = location.toString();
		img="resources/" + imgID +".png";
		this.quantity = this.initialQuantity;
		this.visible=true;	
		// this.canvas = canvas;
		// Image img2 = new Image(this.imgID,this.img,100,100,this.location.xLocation(), this.location.yLocation());
		// // img2.setShapeListener(listener);
		// img2.setzOrder(3);
		// img2.setDraggable(false);
		// canvas.addShape(img2);	
	}

	public top getLocation() {
		return this.location;
	}
		
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}


	public String getImage() {
		return this.img;
	}

	public String getImageID() {
		return this.imgID;
	}

	public boolean getVisibility() {
		return this.visible;
	}
	
	public void setVisibility(Boolean visible,GameCanvas canvas) {
		this.visible = visible;
		if(this.visible==true){
			canvas.show(this.imgID);
		}
		else {
			canvas.hide(imgID);
		}
		
	}
	
	public void refill(){
		this.quantity = this.initialQuantity;
	}

	public void reduceQuantity(){
		this.quantity = this.quantity--;
	}
	
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		if (this.visible==true){
			reduceQuantity();
		//גם שיוריד מהכמות שנדרשת להכין מנה
		}
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

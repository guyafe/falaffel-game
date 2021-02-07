package my_game;

import DB.ExcelTable;
import game.MouseHandler;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import game.ShapeListener;

public class Topping implements ShapeListener {
	private Point location;
	private final String img;
	private final String imgID;
	private final int initialQuantity=10;
	private int quantity;
	private boolean visible;


	public Topping(String imgID) {
		this.imgID = imgID;
		img="resources/" + imgID +".png";
		this.quantity = this.initialQuantity;
		this.visible=true;
		
		}

	public Point getLocation() {
		return this.location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
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
	
	public void setVisibility(Boolean visible) {
		this.visible = visible;
	}
	
	public void refill(){
		this.quantity = this.initialQuantity;
	}

	public void reduceQuantity(){
		this.quantity = this.quantity--;
	}
	
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		reduceQuantity();
		//גם שיוריד מהכמות שנדרשת להכין מנה

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

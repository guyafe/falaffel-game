package my_game;

import DB.ExcelTable;
import game.MouseHandler;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import shapes.TextLabel;
import game.ShapeListener;
import gui.GameCanvas;
import main.MyContent;

public class Topping implements ShapeListener {
	//  private GameCanvas canvas = Game.UI().canvas();
	// private MyContent content = new MyContent();

	public enum top{
		falafel (300,510),  //סתם ערכים כרגע. לשנות ככה שיתאים בלוח
		salad (490,410),
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
	private MyContent content;
	// private GameCanvas canvas;

	public Topping(top location,  MyContent content) {
		this.location=location;
		this.imgID = location.toString();
		img="resources/" + imgID +".png";
		this.quantity = this.initialQuantity;
		this.visible=true;	
		this.content=content;
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
	
	public void setVisibility(Boolean visible) {
		this.visible = visible;
		if(this.visible==true){
			Game.UI().canvas().show(this.imgID);
		}
		else {
			Game.UI().canvas().hide(imgID);
		}
		
	}
	
	public void refill(){
		this.quantity = this.initialQuantity;
	}

	public void reduceQuantity(){
		this.quantity--;
	}
	
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		int quant;
		if (this.visible==true){
			reduceQuantity(); //מחסר מהכמות שיש במלאי
			TextLabel txt =(TextLabel) Game.UI().canvas().getShape(shapeID+"Amount");
			if(shapeID=="salad"){   //מחסיר 1 מהכמות שנשארה כדי להשלים מנה ומציג
				quant=content.board().getSaladAmount();
				txt.getLabel().setText(String.valueOf(content.board().reduceSalad()));
			}
			else if(shapeID=="fries"){
				quant=content.board().getFriesAmount();
				txt.getLabel().setText(String.valueOf(content.board().reduceFries()));
			}
			else if(shapeID=="falafel"){
				quant=content.board().getFalafelAmount();
				txt.getLabel().setText(String.valueOf(content.board().reduceFalafel()));
			}
			else{
				quant=content.board().getHummusAmount();
				txt.getLabel().setText(String.valueOf(content.board().reduceHummus())); 

			}
			if(quant>0){  //מעדכן את הניקוד
				content.player().setScore(5);
			}
			else{
				content.player().setScore(-5);
			}
			content.score().getLabel().setText(String.valueOf(content.player().getScore()));
		}
		if(content.board().isComplete()==true){
			content.customers().changeSelection(true);
		}
		setVisibility(this.quantity>0);
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

package my_game;

import game.Game;
import shapes.TextLabel;
import game.ShapeListener;
import main.MyContent;

public class Topping implements ShapeListener {

	public enum top{
		falafel (380,600,200,60),  
		salad (583,520,150,90),
		fries (390,515,200,80),
		hummus (592,608,200,50);
		private final int xLocation, yLocation,width,height;
		private top(int xLocation, int yLocation, int width, int height) {
			this.xLocation = xLocation;
			this.yLocation = yLocation;
			this.width=width;
			this.height=height;
		}
		public int xLocation() {
			return xLocation;
		}
		public int yLocation() {
			return yLocation;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
		public top next() {
			if (this.ordinal()==top.values().length-1){
				return null;
			}
			return top.values()[this.ordinal()+1]; 
			
		}
    }
	
	private final top location;
	private final String img;
	private final String imgID;
	private final int initialQuantity=10;
	private int quantity;
	private boolean visible;
	private MyContent content;

	public Topping(top location,  MyContent content) {
		this.location=location;
		this.imgID = location.toString();
		img="resources/" + imgID +".png";
		this.quantity = this.initialQuantity;
		this.visible=true;	
		this.content=content;	
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
		this.setVisibility(true);
	}

	public void reduceQuantity(){
		this.quantity--;
	}
	
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		int toppingAmount;
		if (this.visible==true && this.content.flow().getPausedStatus()==false){
			
			reduceQuantity(); //מחסר מהכמות שיש במלאי
			TextLabel txt =(TextLabel) Game.UI().canvas().getShape(shapeID+"Amount");
			top t = top.valueOf(shapeID);

			toppingAmount=content.board().getAmount()[t.ordinal()];//מחסיר 1 מהכמות שנשארה כדי להשלים מנה ומציג
			txt.getLabel().setText(String.valueOf(content.board().reduceToppingAmount(t)));	

			if(toppingAmount>0){  //מעדכן את הניקוד
				content.player().changeScore(1);
				Game.audioPlayer().play("resources/adding.wav", 1);
			}
			else{
				content.player().changeScore(-1);
				Game.audioPlayer().play("resources/wrong.wav", 1);
				
			}
			content.score().getLabel().setText(String.valueOf(content.player().getScore()));
		}
		if(content.board().isComplete()==true){
			content.customers().changeSelection(true);
			Game.UI().canvas().show("full");
		
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

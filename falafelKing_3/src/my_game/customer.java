package my_game;

import game.ShapeListener;
import main.MyContent;
import my_game.customers.customerLocation;
import game.Game;

public class customer implements ShapeListener {

	public enum level{
		none ("resources/none.png"),
		veryLow ("resources/very_low.png"),
		low ("resources/low.png"),
		medium ("resources/medium.png"),
		high ("resources/high.png"),
		angry ("resources/angry.png");

		private final String bar;
		private level(String bar) {
			this.bar = bar;
		}
		public String getBar() {
			return this.bar;
		}
		
		public level next() {
			if (this.ordinal()==level.values().length-1) {
				return null;
			}
			return level.values()[this.ordinal()+1]; 
		}
	}

	private final String img;
	private final String imgID;
	private final customerLocation location;
	private final int height;
	private final int barYLocation;
	private level patience = level.none;
	private String patienceIMG = patience.getBar();
	private boolean selection;
	private PlayerListener playerListener;
	private MyContent content;
	private int leavingCounter=0;
	
	public customer(String imgID, boolean selection, customerLocation location, PlayerListener pListener, MyContent content){
		this.imgID=imgID;
		this.img="resources/" +imgID+".png";
		this.selection=selection;
		this.playerListener = pListener;
		this.content=content;
		this.location = location;
		int x = Integer.valueOf(imgID);
		if (x==1 || x==2){
			this.height=300;
			this.barYLocation=location.getYLocation()-200;
		}
		else{
			this.height=200;
			this.barYLocation=location.getYLocation()-86;
		}
		
	}	
	
	public String getImage() {
		return this.img;
	}

	public String getImageID() {
		return this.imgID;
	}
	
	public level getPatience() {
		return this.patience;
	}

	public void setPatience (level patience){
		this.patience=patience;

	}

	public String getPatienceIMG() {
		return this.patienceIMG;
	}

	public void setPatienceIMG (String patienceIMG){
		this.patienceIMG=patienceIMG;
	}

	public boolean getSelection() {
		return this.selection;
	}

	public int getLeavingCounter() {
		return this.leavingCounter;
	}

	public void setLeavingCounter (int counter){
		this.leavingCounter=counter;

	}

	public int getHeight() {
		return this.height;
	}

	public int getBarYLocation() {
		return this.barYLocation;
	}

	public void increaseLeavingCounter (){
		this.leavingCounter++;

	}

	public customerLocation getCustomerLocation() {
		return this.location;
	}

	public void changeSelection(boolean selection){
		this.selection=selection;
	}

	public level upLevel(){ 
		if (this.patience.next()!=null) {
			this.patience=this.patience.next();
			this.patienceIMG=patience.getBar();
		}
		else
		{
			this.playerListener.customerLostPatience();
		}
		return this.patience;
	}

	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		if (this.selection==true && this.content.flow().getPausedStatus()==false) {
			Game.UI().canvas().deleteShape(imgID);
			Game.UI().canvas().deleteShape(imgID+"patience");
			content.customers().removeCustomer(shapeID);
			playerListener.playerSuccessInServing();
			content.score().getLabel().setText(String.valueOf(content.player().getScore()));
			content.customers().changeSelection(false);
			content.board().generateDish();
			Game.audioPlayer().play("resources/delivered.wav", 1);
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

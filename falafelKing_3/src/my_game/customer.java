// מה נשמע
//מחר נגמר הסגר אז בסדר//
package my_game;

import DB.ExcelTable;
import game.ShapeListener;
import main.MyContent;
import my_game.customers.customerLocation;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;

public class customer implements ShapeListener {

	private MyContent content = new MyContent();

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
			return level.values()[this.ordinal()+1]; //לוודא שעובד
		}
	}

	private final String img;
	private final String imgID;
	private final customerLocation location;
	private level patience;
	private String patienceIMG;
	private boolean selection;
	private PlayerListener playerListener;
	
	public customer(String imgID, boolean selection, customerLocation location, PlayerListener pListener) {
		this.imgID=imgID;
		this.img="resources/" + (int) ((Math.random())*5) +".png";
		this.selection=selection;
		this.patience = level.none;
		this.patienceIMG =patience.getBar();
		this.location = location;
		this.playerListener = pListener;

		
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

	public void setPatience (String patienceIMG){
		this.patienceIMG=patienceIMG;
	}

	public boolean getSelection() {
		return this.selection;
	}

	public customerLocation getCustomerLocation() {
		return this.location;
	}

	public void switchSelection(){
		this.selection=!this.selection;
	}

	public level upLevel(){
		this.patience.next();
		if (this.patience!=null){
			this.patienceIMG=patience.getBar();
		}
		else
		{
			this.playerListener.customerLostPatience();
		}
		return this.patience;//הוספנו החל מה else//
	}
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		if (this.selection==true){
			content.customers().removeCustomer(shapeID);
			playerListener.playerSuccessInServing();
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

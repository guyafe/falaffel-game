package my_game;

import DB.ExcelTable;
import game.ShapeListener;
import main.MyContent;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;

public class customers  {

	public enum customerLocation{
		a (400,400),  //סתם ערכים כרגע. לשנות ככה שיתאים בלוח
		b (500,400),
		c (600,400),
		d (700,400),
		e (800,400);
		private final int xLocation, yLocation;
		private customerLocation(int xLocation, int yLocation) {
			this.xLocation = xLocation;
			this.yLocation = yLocation;
		}
		public int xLocation() {
			return xLocation;
		}
		public int yLocation() {
			return yLocation;
		}
		public customerLocation next() {
			if (this.ordinal()==customerLocation.values().length-1){
				return null;
			}
			return customerLocation.values()[this.ordinal()+1]; //לוודא שעובד
		}
	}

	private MyContent content;

	public void setContent(MyContent content) {
		this.content = content;
	}


	private customer[] customers;
	private PlayerListener playerListener;

	public customers (PlayerListener pListener){
		customers = new customer[5];
		for (int i = 0; i < customers.length; i++) {
			customers[i]=null;
		}
		this.playerListener=pListener;
	}

	public customer[] getCustomers (){
		return customers;
	}

	public void addCustomer(){
		customerLocation loc = customerLocation.a;
		int i=(int) ((Math.random())*5);
		while (customers[i]!=null) {
			i=(int) ((Math.random())*5);
			loc.next();
		}
		this.customers[i]=new customer(String.valueOf(i),true, loc, playerListener);//לשנות את ה"אמת" לפונקציה שמקבלת אם המנה מוכנה
		content.addCharacter(i);
	}

	public void removeCustomer(String imgID){
		int i = Integer.valueOf(imgID);
		this.customers[i]=null;
	}

	public void changeSelection(boolean selection){
		for (int i = 0; i < customers.length; i++) {
			this.customers[i].switchSelection();
		}
	}

	public void upLevel(){
		for (int i = 0; i < customers.length; i++) {
			this.customers[i].upLevel();
		}
	}

}

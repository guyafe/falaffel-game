package my_game;

import DB.ExcelTable;
import game.ShapeListener;
import main.MyContent;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;

public class customers  {

	public enum customerLocation{
		a (350,300),  //סתם ערכים כרגע. לשנות ככה שיתאים בלוח
		b (500,300),
		c (650,300),
		d (800,300);
		// e (700,200);
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

	private final int numOfCustomers=4;
	private customer[] customers;
	private boolean[] imageVisible;
	private PlayerListener playerListener;

	public customers (PlayerListener pListener){
		customers = new customer[numOfCustomers];
		for (int i = 0; i < customers.length; i++) {
			customers[i]=null;
		}
		imageVisible = new boolean[numOfCustomers];
		for (int i = 0; i < imageVisible.length; i++) {
			imageVisible[i]=false;
		}
		this.playerListener=pListener;
	}

	public customer[] getCustomers (){
		return customers;
	}

	public void addCustomer(){
		int i=(int) ((Math.random())*numOfCustomers);
		while (customers[i]!=null) {
			i=(int) ((Math.random())*numOfCustomers);
		}
		int j=(int) ((Math.random())*numOfCustomers);
		while (imageVisible[j]!=false) {
			j=(int) ((Math.random())*numOfCustomers);
		}
		this.customers[i]=new customer(String.valueOf(j),content.board().isComplete(), customerLocation.values()[i], playerListener, content);//לשנות את ה"אמת" לפונקציה שמקבלת אם המנה מוכנה
		this.imageVisible[j]=true;
		content.addCharacter(i);

	}

	public void removeCustomer(String imgID){
		// int i = Integer.valueOf(imgID);
		for (int i = 0; i < this.customers.length; i++) {
			if(this.customers[i]!=null){
				if(this.customers[i].getImageID()==imgID){
					this.customers[i]=null;
				}
			}
		}
		this.imageVisible[Integer.valueOf(imgID)]=false;
	}

	public void changeSelection(boolean selection){
		for (int i = 0; i < customers.length; i++) {
			if(this.customers[i]!=null){
				this.customers[i].changeSelection(selection);
			}
		}
	}

	public void upLevel(){
		for (int i = 0; i < customers.length; i++) {
			this.customers[i].upLevel();
		}
	}

}

package my_game;

import main.MyContent;

public class customers{

	public enum customerLocation{
		a (350,342),
		b (500,342),
		c (650,342),
		d (800,342);
		
		private final int xLocation, yLocation;
		private customerLocation(int xLocation, int yLocation) {
			this.xLocation = xLocation;
			this.yLocation = yLocation;
		}

		public int getXLocation() {
			return xLocation;
		}

		public int getYLocation() {
			return yLocation;
		}
		public customerLocation next() {
			if (this.ordinal()==customerLocation.values().length-1){
				return null;
			}
			return customerLocation.values()[this.ordinal()+1];
		}
	}
	
	private final int numberOfCustomers = 4;
	private final int numOfImages = 5;
	private customer[] customers;
	private boolean[] imageVisible;
	private PlayerListener playerListener;
	private MyContent content;

	public customers (PlayerListener pListener){
		this.customers = new customer[numberOfCustomers];
		for (int i = 0; i < customers.length; i++) {
			this.customers[i]=null;
		}
		this.imageVisible = new boolean[numOfImages];
		for (int i = 0; i < imageVisible.length; i++) {
			this.imageVisible[i]=false;
		}
		this.playerListener=pListener;
	}

	public customer[] getCustomers() {
		return this.customers;
	}

	public int getNumOfImages() {
		return this.numOfImages;
	}

	public void setContent(MyContent content) {
		this.content = content;
	}

	public void addCustomer() {
		
		int i=(int)((Math.random())*numberOfCustomers);
		while (this.customers[i] != null) {
			i=(int)((Math.random())*numberOfCustomers);
		}
		int j=(int) ((Math.random())*numOfImages);
		while (imageVisible[j] == true) {
			j=(int) ((Math.random())*numOfImages);
		}
		this.customers[i] = new customer(String.valueOf(j), content.board().isComplete(), customerLocation.values()[i], playerListener, content);
		this.imageVisible[j] = true;
		this.content.addCharacter(i);
	}

	public void removeCustomer(String imgID) {
		for (int i = 0; i < this.customers.length; i++) {
			customer currentCustomer = this.customers[i];
			if(currentCustomer != null && currentCustomer.getImageID()==imgID) { 
					this.customers[i] = null;
			}
		}
		this.imageVisible[Integer.valueOf(imgID)] = false;
	}

	public void changeSelection(boolean selection){
		for (int i = 0; i < customers.length; i++) {
			if(this.customers[i] != null){
				this.customers[i].changeSelection(selection);
			}
		}
	}

	public void upLevel() {
		for (int i = 0; i < customers.length; i++) {
			if(this.customers[i] != null) {
				this.customers[i].upLevel();
			}
		}
	}

}

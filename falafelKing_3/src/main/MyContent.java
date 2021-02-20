package main;

import game.Game;
import game.GameContent;
import gui.GameCanvas;
import my_game.board;
import my_game.customer;
import my_game.customers;
import my_game.Point;
import my_game.Spray;
import my_game.Topping;
import my_game.player;
import my_game.refill;
import my_game.Topping.top;
import my_game.board.amountLabel;
import my_game.customers.customerLocation;
import shapes.Image;
import shapes.TextLabel;
import my_game.GameFlow;
import my_game.PlayerListener;

public class MyContent extends GameContent{
	private board board;
	private customers customers;
	private player player;

	private Topping[] toppings = new Topping[top.values().length];
	private shapes.TextLabel[] amountTXTlabel=new shapes.TextLabel[top.values().length];
	
	private shapes.TextLabel score;
	private shapes.TextLabel lives;
	private refill seller;
	private Spray spray;
	private GameFlow flow;


	@Override
	public void initContent() {
	
		this.player = new player(this);
		
		this.customers = new customers((PlayerListener)player);
		this.customers.setContent(this);
		this.board = new board();

		for (int i = 0; i < toppings.length; i++) {
			toppings[i]=new Topping(top.values()[i], this);

			amountLabel lbl = amountLabel.values()[i];
			this.amountTXTlabel[i] = new shapes.TextLabel(lbl.toString()+"Amount",String.valueOf(board.getAmount()[i]), lbl.xLocation(), lbl.yLocation());
		}

		this.score = new shapes.TextLabel("score", "10", 125, 135);
		this.lives = new shapes.TextLabel("lives", "10", 230, 135);

		this.seller = new refill(this);

		this.spray = new Spray(this);

		this.flow = new GameFlow();

	}	
	public player player() {
		return player;
	}

	public board board() {
		return board;
	}

	public customers customers() {
		return customers;
	}

	public Topping[] toppings() {
		return toppings;
	}

	public TextLabel[] amountLabel() {
		return amountTXTlabel;
	}

	public TextLabel score() {
		return score;
	}

	public TextLabel lives() {
		return lives;
	}

	public refill seller(){
		return this.seller;
	}
	
	public Spray spray(){
		return this.spray;
	}

	public GameFlow flow(){
		return this.flow;
	}

	public void addCharacter(int number) {
		
		GameCanvas canvas = Game.UI().canvas();
		//TODO
		//Add your character shape or image to the canvas using its addShape method
		//Use the properties of your character for the parameters of the shape.

		customer customer = this.customers.getCustomers()[number];
		customerLocation loc = customer.getCustomerLocation();

		Image img = new Image(customer.getImageID(),customer.getImage(),200,customer.getHeight(),loc.getXLocation(), loc.getYLocation());
		
		int x= Integer.valueOf(customer.getImageID());
		if(x!=1 && x!=2){//מנמיך בקנבס לקוחות נמוכים
			img.setPosY(img.getPosY()+50);
		}

		img.setShapeListener(customer);
		canvas.addShape(img);

		img = new Image(customer.getImageID()+"patience",customer.getPatienceIMG(),50,100,loc.getXLocation(), customer.getBarYLocation());
		img.setzOrder(4);
		canvas.addShape(img);
	
	}
	
}

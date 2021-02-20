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
import my_game.customers.customerLocation;
import shapes.Image;
import shapes.TextLabel;
import my_game.GameFlow;
import my_game.PlayerListener;

public class MyContent extends GameContent{
	private board board;
	private customers customers;
	private player player;
	private Topping hummus;
	private Topping salad;
	private Topping fries;
	private Topping falafel;
	private shapes.TextLabel score;
	private shapes.TextLabel lives;
	private shapes.TextLabel hummusAmount;
	private shapes.TextLabel saladAmount;
	private shapes.TextLabel friesAmount;
	private shapes.TextLabel falafelAmount;
	private refill seller;
	private Spray spray;
	private GameFlow flow;


	@Override
	public void initContent() {
	
		this.player = new player(this);
		
		this.customers = new customers((PlayerListener)player);
		this.customers.setContent(this);
		
		this.falafel = new Topping(top.falafel, this);
        this.salad = new Topping(top.salad, this);
        this.fries = new Topping(top.fries, this);
        this.hummus = new Topping(top.hummus, this);

		this.score = new shapes.TextLabel("score", "10", 125, 135);
		this.lives = new shapes.TextLabel("lives", "10", 230, 135);

		this.board = new board();

		this.hummusAmount = new shapes.TextLabel("hummusAmount",String.valueOf(board.getHummusAmount()), 495, 540);
		this.saladAmount = new shapes.TextLabel("saladAmount",String.valueOf(board.getSaladAmount()), 485, 473);
		this.friesAmount = new shapes.TextLabel("friesAmount",String.valueOf(board.getFriesAmount()), 302, 455);
		this.falafelAmount = new shapes.TextLabel("falafelAmount",String.valueOf(board.getFalafelAmount()), 270, 530);

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

	public Topping salad() {
		return salad;
	}

	public Topping fries() {
		return fries;
	}

	public Topping hummus() {
		return hummus;
	}

	public Topping falafel() {
		return falafel;
	}

	public TextLabel saladAmount() {
		return saladAmount;
	}

	public TextLabel friesAmount() {
		return friesAmount;
	}

	public TextLabel hummusAmount() {
		return hummusAmount;
	}

	public TextLabel falafelAmount() {
		return falafelAmount;
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

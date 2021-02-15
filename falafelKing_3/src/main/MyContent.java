package main;

import java.awt.Color;
import game.Game;
import game.GameContent;
import gui.GameCanvas;
import my_game.board;
import my_game.customer;
import my_game.customers;
import my_game.Point;
import my_game.Topping;
import my_game.Toppings;
import my_game.BoardListener;
import my_game.player;
import my_game.refill;
import my_game.Topping.top;
import my_game.customers.customerLocation;
import shapes.Image;
import shapes.TextLabel;
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
	//TODO
	//Declare your own character

	@Override
	public void initContent() {
		// GameCanvas canvas = Game.UI().canvas();

		
		this.player = new player("mor", (BoardListener)board);//לעשות אולי שאפשר להזין את השם שחקן
		this.customers = new customers((PlayerListener)player);
		this.customers.setContent(this);
		this.falafel = new Topping(top.falafel, this);
        this.salad = new Topping(top.salad, this);
        this.fries = new Topping(top.fries, this);
        this.hummus = new Topping(top.hummus, this);

		this.score = new shapes.TextLabel("score", "10", 125, 135);
		score.setFontSize(40);

		this.lives = new shapes.TextLabel("lives", "10", 230, 135);
		lives.setFontSize(40);

		this.board = new board();
		this.hummusAmount = new shapes.TextLabel("hummusAmount",String.valueOf(board.getHummusAmount()), 490, 540);
		hummusAmount.setzOrder(1);
		this.saladAmount = new shapes.TextLabel("saladAmount",String.valueOf(board.getSaladAmount()), 490, 470);
		saladAmount.setzOrder(1);
		this.friesAmount = new shapes.TextLabel("friesAmount",String.valueOf(board.getFriesAmount()), 300, 450);
		friesAmount.setzOrder(1);
		this.falafelAmount = new shapes.TextLabel("falafelAmount",String.valueOf(board.getFalafelAmount()), 270, 530);
		falafelAmount.setzOrder(1);

		this.seller = new refill(this);
		

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

	public void addCharacter(int number) {
		//TODO
		//Create an instance of your character and set its properties with
		//initial values
		//Make sure you set values to the location and imageID properties
		
		GameCanvas canvas = Game.UI().canvas();
		//TODO
		//Add your character shape or image to the canvas using its addShape method
		//Use the properties of your character for the parameters of the shape.
		
		
/*
		Image img = new Image("bg","resources/background.png",200,600,500,500);
		canvas.addShape(img);
		
		*/
		customer customer = this.customers.getCustomers()[number];
		customerLocation loc = customer.getCustomerLocation();

		Image img = new Image(customer.getImageID(),customer.getImage(),200,300,loc.getXLocation(), loc.getYLocation());
		img.setShapeListener(customer);
		canvas.addShape(img);
		int y;
		int x= Integer.valueOf(customer.getImageID());//למה לעזאזל הייתי צריך להמיר לint???
		if(x==1 || x==2){
			y = loc.getYLocation()-200;
		}
		else {
			y = loc.getYLocation()-100;
		}
		img = new Image(customer.getImageID()+"patience",customer.getPatienceIMG(),50,100,loc.getXLocation(), y);
		img.setzOrder(4);
		canvas.addShape(img);
	
	


	}
	
	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}

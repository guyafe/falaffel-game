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
	private shapes.TextLabel hummusAmount;
	private shapes.TextLabel saladAmount;
	private shapes.TextLabel friesAmount;
	private shapes.TextLabel falafelAmount;
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

		this.score = new shapes.TextLabel("score", "10", 80, 30);
		score.setFontSize(40);

		this.board = new board();
		this.hummusAmount = new shapes.TextLabel("hummusAmount",String.valueOf(board.getHummusAmount()), 400, 440);
		this.saladAmount = new shapes.TextLabel("saladAmount",String.valueOf(board.getSaladAmount()), 400, 370);
		this.friesAmount = new shapes.TextLabel("friesAmount",String.valueOf(board.getFriesAmount()), 210, 350);
		this.falafelAmount = new shapes.TextLabel("falafelAmount",String.valueOf(board.getFalafelAmount()), 180, 430);

		

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
		//Image img = new Image(, , 220, 430, loc.xLocation(), loc.yLocation());
		//canvas.addShape(img);

		Image img2 = new Image(customer.getImageID(),customer.getImage(),200,300,loc.xLocation(), loc.yLocation());
		img2.setShapeListener(customer);
		img2.setzOrder(3);
		img2.setDraggable(false);
		// if(canvas.getShape(customer.getImageID())==null) {//בודק אם יש דמות קיימת במיקום
			canvas.addShape(img2);
		// }
	


	}
	
	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}

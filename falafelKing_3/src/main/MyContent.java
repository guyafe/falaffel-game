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
import my_game.customers.customerLocation;
import shapes.Image;
import my_game.PlayerListener;

public class MyContent extends GameContent{
	private board board;
	private customers customers;
	private player player;
	private Toppings Toppings;
	//TODO
	//Declare your own character

	@Override
	public void initContent() {
		this.board = new board();
		this.player = new player("mor", (BoardListener)board);
		this.customers = new customers((PlayerListener)player);
		this.customers.setContent(this);
		
		// board.setLocation(new Point(100,100));	
	}	
	public board board() {
		return board;
	}

	public customers customers() {
		return customers;
	}

	public Toppings Toppings() {
		return Toppings;
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
		
		//Image img = new Image("bg","resources/background.png",800,600,500,500);
		//canvas.addShape(img);
		
		
		customer customer = this.customers.getCustomers()[number];
		customerLocation loc = customer.getCustomerLocation();
		Image img = new Image(customer.getImageID(), customer.getImage(), 220, 430, loc.xLocation(), loc.yLocation());
		canvas.addShape(img);

	}
	
	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}

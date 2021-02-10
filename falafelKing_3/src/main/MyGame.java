package main;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
import game.GameContent;
import game.PeriodicScheduler;
import gui.GameCanvas;
import gui.GameDashboard;
import my_game.Topping;
import my_game.board;
import my_game.Topping.top;
import shapes.Circle;
import shapes.Image;

public class MyGame extends Game {
	
	private MyContent content;

	@Override
	protected void initCanvas() {
		GameCanvas canvas = gameUI.canvas();
		//JFrame f = gameUI.frame();

		


		
		
		/*try {
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/background.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		Image img = new Image("bg","resources/background.png",1600,1200,410,300);
		img.setDraggable(false);
		canvas.addShape(img);
		/*
		Image img2 = new Image("2","resources/2.png",500,500,200,300);
		img2.setzOrder(3);
		img2.setDraggable(false);
		canvas.addShape(img2);
		*/
		// board board = content.board();
		// Image image = new Image(board.getBGid(), board.getBGimg(), 220,200, 200, 100);
		// image.setShapeListener(board);
		// image.setzOrder(3);
		// canvas.addShape(image);

		Topping salad = content.salad();
		Image img2 = new Image(salad.getImageID(),salad.getImage(),150,90,salad.getLocation().xLocation(), salad.getLocation().yLocation());
		img2.setShapeListener(salad);
		img2.setzOrder(3);
		img2.setDraggable(false);
		canvas.addShape(img2);
		
		Topping hummus = content.hummus();
		img2 = new Image(hummus.getImageID(),hummus.getImage(),200,90,hummus.getLocation().xLocation(), hummus.getLocation().yLocation());
		img2.setShapeListener(hummus);
		img2.setzOrder(3);
		img2.setDraggable(false);
		canvas.addShape(img2);

		Topping fries = content.fries();
		img2 = new Image(fries.getImageID(),fries.getImage(),200,90,fries.getLocation().xLocation(), fries.getLocation().yLocation());
		img2.setShapeListener(fries);
		img2.setzOrder(3);
		img2.setDraggable(false);
		canvas.addShape(img2);

		Topping falafel = content.falafel();
		img2 = new Image(falafel.getImageID(),falafel.getImage(),200,100,falafel.getLocation().xLocation(), falafel.getLocation().yLocation());
		img2.setShapeListener(falafel);
		img2.setzOrder(3);
		img2.setDraggable(false);
		canvas.addShape(img2);


	}
	
		//TODO
		// Add the ChangeButton button to the dashboard

	@Override
	public void setGameContent(GameContent content) {
		// Call the Game superclass to set its content 
		super.setGameContent(content);
		// point to the content with a variable of type MyContent so we have access to all
		// our game specific data
		this.content = (MyContent) content;
	}
	
	public MyContent getContent() {
		return this.content;
	}
	
	public static void main(String[] args) {
		MyGame game = new MyGame();
		game.setGameContent(new MyContent());
		PeriodicScheduler.periodicInterval = 5000;
		MyPeriodicLoop periodicLoop = new MyPeriodicLoop();
		periodicLoop.setContent(game.getContent());
		game.setPeriodicLoop(periodicLoop);
		game.setMouseHandler(new MyMouseHandler());
		game.setKeyboardListener(new MyKeyboardListener());
		game.initGame();
	}


}

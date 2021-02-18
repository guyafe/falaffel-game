package main;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.xmlbeans.impl.soap.Text;

import game.Game;
import game.GameContent;
import game.PeriodicScheduler;
import gui.GameCanvas;
import gui.GameDashboard;
import my_game.Topping;
import my_game.board;
import my_game.refill;
import my_game.Topping.top;
import shapes.Circle;
import shapes.Image;
import shapes.TextLabel;

public class MyGame extends Game {
	
	private MyContent content;

	@Override
	protected void initCanvas() {
		GameCanvas canvas = gameUI.canvas();
		
		//תמונת רקע
		Image img = new Image("bg","resources/background.png",812,1200,500,400);
		img.setzOrder(1);
		canvas.addShape(img);
		
		//מציג את התמונות של התוספות
		Topping salad = content.salad();
		img = new Image(salad.getImageID(),salad.getImage(),150,90,salad.getLocation().xLocation(), salad.getLocation().yLocation());
		img.setShapeListener(salad);
		canvas.addShape(img);
		
		Topping hummus = content.hummus();
		img = new Image(hummus.getImageID(),hummus.getImage(),200,50,hummus.getLocation().xLocation(), hummus.getLocation().yLocation());
		img.setShapeListener(hummus);
		canvas.addShape(img);

		Topping fries = content.fries();
		img = new Image(fries.getImageID(),fries.getImage(),200,80,fries.getLocation().xLocation(), fries.getLocation().yLocation());
		img.setShapeListener(fries);
		canvas.addShape(img);

		Topping falafel = content.falafel();
		img = new Image(falafel.getImageID(),falafel.getImage(),200,60,falafel.getLocation().xLocation(), falafel.getLocation().yLocation());
		img.setShapeListener(falafel);
		canvas.addShape(img);

		//מציג את הניקוד של השחקן
		shapes.TextLabel scoreTXT = content.score();
		scoreTXT.getLabel().setText(String.valueOf(content.player().getScore()));
		scoreTXT.setzOrder(1);
		scoreTXT.setFontName("times new roman");
		scoreTXT.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(scoreTXT);

		//מציג את החיים הנותרים לשחקן
		shapes.TextLabel livesTXT = content.lives();
		livesTXT.getLabel().setText(String.valueOf(content.player().getLives()));
		livesTXT.setzOrder(1);
		livesTXT.setFontName("times new roman");
		livesTXT.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(livesTXT);

		
		//כמות התוספות במסך
		canvas.addShape(content.saladAmount());
		canvas.addShape(content.hummusAmount());
		canvas.addShape(content.friesAmount());
		canvas.addShape(content.falafelAmount());
		content.board().generateDish();

		// תמונה של פיתה מלאה. מוסתרת כל עוד לא השלימו מנה
		img = new Image("full","resources/full.png",255,127,776,620);
		canvas.addShape(img);
		canvas.hide("full");

		//תמונת האיש במחסן
		refill seller = content.seller();
		img = new Image(seller.getImageID(),seller.getImage(),130,280,188, 502);
		img.setShapeListener(seller);
		img.setzOrder(4);
		canvas.addShape(img);

		//תמונת זבובים
		img = new Image("flies","resources/flies.png",255,127,576,420);
		canvas.addShape(img);
		img.setzOrder(5);
		canvas.hide("flies");

		//תמונת בקבוק ספריי
		img = new Image(content.board().getSprayImgID(),content.board().getSprayImg(),40,127,692,495);
		img.setShapeListener(content.board());
		img.setzOrder(4);
		canvas.addShape(img);

		//תמונת ספריי
		img = new Image("gas","resources/gas.png",250,520,560,400);
		img.setzOrder(6);
		canvas.addShape(img);	
		canvas.hide("gas");


		//כותרת לתוצאת השחקן
		shapes.TextLabel txt = new shapes.TextLabel("header", "score:        lives:", 120, 112);;
		txt.setzOrder(1);
		txt.setFontSize(20);
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		//קרדיט למאי
		txt = new shapes.TextLabel("credit", "graphic design by May Levi", 380, 715);;
		txt.setFontSize(20);
		txt.setFontName("david");
		txt.getLabel().setForeground(java.awt.Color.black);

		canvas.addShape(txt);
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
		PeriodicScheduler.periodicInterval = 250;
		MyPeriodicLoop periodicLoop = new MyPeriodicLoop();
		periodicLoop.setContent(game.getContent());
		game.setPeriodicLoop(periodicLoop);
		game.setMouseHandler(new MyMouseHandler());
		game.setKeyboardListener(new MyKeyboardListener());
		game.initGame();
	}


}

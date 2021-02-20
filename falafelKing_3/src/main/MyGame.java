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
		
		// הוספת עומק לרקע
		img = new Image("cash_up","resources/cash_up.png",20,30,895,418);
		img.setzOrder(4);
		canvas.addShape(img);
		
		img = new Image("cash","resources/cash.png",100,50,860,473);
		img.setzOrder(4);
		canvas.addShape(img);

		img = new Image("right_sign","resources/right_sign.png",55,38,488,480);
		img.setzOrder(4);
		canvas.addShape(img);

		img = new Image("left_sign","resources/left_sign.png",100,60,283,472);
		img.setzOrder(4);
		canvas.addShape(img);

		img = new Image("wall","resources/wall.png",191,280,187,312);
		img.setzOrder(4);
		canvas.addShape(img);
		
		img = new Image("pita","resources/pita.png",115,40,774,478);
		img.setzOrder(4);
		canvas.addShape(img);

		//מציג את התמונות של התוספות
		Topping salad = content.salad();
		img = new Image(salad.getImageID(),salad.getImage(),150,90,salad.getLocation().xLocation(), salad.getLocation().yLocation());
		img.setShapeListener(salad);
		img.setzOrder(4);
		canvas.addShape(img);
		
		Topping hummus = content.hummus();
		img = new Image(hummus.getImageID(),hummus.getImage(),200,50,hummus.getLocation().xLocation(), hummus.getLocation().yLocation());
		img.setShapeListener(hummus);
		img.setzOrder(4);
		canvas.addShape(img);

		Topping fries = content.fries();
		img = new Image(fries.getImageID(),fries.getImage(),200,80,fries.getLocation().xLocation(), fries.getLocation().yLocation());
		img.setShapeListener(fries);
		img.setzOrder(4);
		canvas.addShape(img);

		Topping falafel = content.falafel();
		img = new Image(falafel.getImageID(),falafel.getImage(),200,60,falafel.getLocation().xLocation(), falafel.getLocation().yLocation());
		img.setShapeListener(falafel);
		img.setzOrder(4);
		canvas.addShape(img);

		// תמונה של פיתה מלאה. מוסתרת כל עוד לא השלימו מנה
		img = new Image("full","resources/full.png",255,127,776,620);
		canvas.addShape(img);
		canvas.hide("full");

		//תמונת האיש במחסן
		refill seller = content.seller();
		img = new Image(seller.getImageID(),seller.getImage(),130,280,188, 502);
		img.setShapeListener(seller);
		img.setzOrder(5);
		canvas.addShape(img);

		//תמונת זבובים
		img = new Image("flies","resources/flies.png",160,110,576,420);
		canvas.addShape(img);
		img.setzOrder(5);
		canvas.hide("flies");

		//תמונת בקבוק ספריי
		img = new Image("spray","resources/spray.png",40,127,692,495);
		img.setShapeListener(content.spray());
		img.setzOrder(4);
		canvas.addShape(img);

		//תמונת ספריי
		img = new Image("gas","resources/gas.png",250,520,560,400);
		img.setzOrder(6);
		canvas.addShape(img);	
		canvas.hide("gas");

		//תמונת כפתור מוזיקה
		img = new Image("music","resources/music.png",65,42,870,120);
		img.setzOrder(4);
		img.setShapeListener(content.flow());
		canvas.addShape(img);	

		//תמונת כפתור עצירה
		img = new Image("pause","resources/pause.png",65,42,870,165);
		img.setzOrder(4);
		img.setShapeListener(content.flow());
		canvas.addShape(img);



		//מציג את הניקוד של השחקן
		shapes.TextLabel txt = content.score();
		txt.getLabel().setText(String.valueOf(content.player().getScore()));
		txt.setzOrder(1);
		txt.setFontSize(40);
		txt.setFontName("times new roman");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		//מציג את החיים הנותרים לשחקן
		txt = content.lives();
		txt.getLabel().setText(String.valueOf(content.player().getLives()));
		txt.setzOrder(1);
		txt.setFontSize(40);
		txt.setFontName("times new roman");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		//כמות התוספות במסך
		txt = content.falafelAmount();
		txt.setzOrder(1);
		txt.setFontName("david");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		txt = content.saladAmount();
		txt.setzOrder(1);
		txt.setFontName("david");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		txt = content.friesAmount();
		txt.setzOrder(1);
		txt.setFontName("david");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		txt = content.hummusAmount();
		txt.setzOrder(1);
		txt.setFontName("david");
		txt.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txt);

		content.board().generateDish();

		//כותרת לתוצאת השחקן
		txt = new shapes.TextLabel("header", "score:        lives:", 120, 112);;
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
		game.content.flow().switchMusicStatus();
	}


}

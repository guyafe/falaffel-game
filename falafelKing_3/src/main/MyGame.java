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
import my_game.board;
import shapes.Circle;
import shapes.Image;

public class MyGame extends Game {
	
	private MyContent content;

	@Override
	protected void initCanvas() {
		GameCanvas canvas = gameUI.canvas();
		JFrame f = gameUI.frame();

		


		//Image img = new Image("bg","resources/background.png",800,600,500,500);
		//canvas.addShape(img);
		
		try {
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/background.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

		// board board = content.board();
		// Image image = new Image(board.getBGid(), board.getBGimg(), 220,200, 200, 100);
		// image.setShapeListener(board);
		// image.setzOrder(3);
		// canvas.addShape(image);

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

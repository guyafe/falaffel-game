package main;
import java.lang.reflect.Array;

import game.Game;
import game.PeriodicLoop;
import gui.GameCanvas;
import my_game.customer;
import my_game.customers;
import my_game.customer.level;
import shapes.Image;

public class MyPeriodicLoop extends PeriodicLoop {

	private MyContent content;

	public void setContent(MyContent content) {
		this.content = content;
	}
	
	@Override
	public void execute() {
		// Let the super class do its work first
		super.execute();
		int counter=0;
		customer[] c = content.customers().getCustomers();
		int delay = content.board().getDelay();
		int currentDelay = content.board().getCurrentDelay();
		if(currentDelay<delay){
			content.board().setCurrentDelay(currentDelay+1);
			// if(currentDelay!=0 && delay/currentDelay==2){
			// 	for (int i = 0; i < c.length; i++) {
			// 		if(c[i]!=null && c[i].getPatience().ordinal()<5){
			// 				c[i].upLevel();
			// 				Game.UI().canvas().hide(c[i].getImageID()+"patience");
			// 				Game.UI().canvas().changeImage(c[i].getImageID()+"patience", c[i].getPatienceIMG(), 50, 50);
			// 				Game.UI().canvas().show(c[i].getImageID()+"patience");
						
			// 		}
			// 	}
			// }
		}
		else{
			
			for (int i = 0; i < c.length; i++) {
				if(c[i]!=null && c[i].getPatience().ordinal()<5){
						c[i].upLevel();
						Game.UI().canvas().hide(c[i].getImageID()+"patience");
						Game.UI().canvas().changeImage(c[i].getImageID()+"patience", c[i].getPatienceIMG(), 50, 50);
						Game.UI().canvas().show(c[i].getImageID()+"patience");
					
				}
			}
			for (int j = 0; j < c.length; j++) {//בודק אם יש תאים ריקים במערך הלקוחות ורק אם כן אז מפעיל את הפונקציה של הוספה
				if(c[j]==null){
					counter++;
				}
			}
			if(counter>0){
				this.content.customers().addCustomer();
			}
			content.board().setCurrentDelay(0);
			if(delay>6){
				content.board().setDelay(delay-1);
			}
		}
	
		//TODO
		//Redraw your character periodically by calling the correct method
		
	}
	


	private void redrawCharacter() {
		
		GameCanvas canvas = Game.UI().canvas();
		
		//TODO
		//Remove the comment from the next line so you can easily 
		//access your character

		//MyCharacter character = content.myCharacter();
		
		//Since this function is called every interval, it will also be called
		//before the character is created. Therefore, we check if the character 
		//exists and if not, we return without doing anything.
		
		//TODO: Remove comments from next 2 lines
//		if (character == null)
//			return;
		
		//TODO
		//Call the canvas to change the shape properties according to
		//its current property values
		//You can get the shape using canvas.getShape(id) with the id of your character
		//Then you can cast it so you can refer to its specific properties.
		//For example, if your shape is a Circle you can use:
		//Circle circle = (Circle) canvas.getShape(id)
		//and then change the specific Circle properties.
		
	}


}

package main;
import java.lang.reflect.Array;

import org.apache.poi.xddf.usermodel.chart.Shape;

import game.Game;
import game.PeriodicLoop;
import gui.GameCanvas;
import my_game.customer;
import my_game.customers;
import my_game.flies;
import my_game.customer.level;
import shapes.Image;
import shapes.Shape.STATUS;

public class MyPeriodicLoop extends PeriodicLoop {

	private MyContent content;

	public void setContent(MyContent content) {
		this.content = content;
	}
	
	@Override
	public void execute() {
		// Let the super class do its work first
		GameCanvas canvas = Game.UI().canvas();
		super.execute();
		boolean empty=false;
		customer[] c = content.customers().getCustomers();
		int delay = content.board().getDelay();
		int currentDelay = content.board().getCurrentDelay();
		int fliesTime=content.board().getFliesTime();
		if(currentDelay<delay){	//כל פרק זמן מאיץ את קצב המשחק
			content.board().setCurrentDelay(currentDelay+1);
		}
		else{
			
			for (int i = 0; i < c.length; i++) {//עובר על כל הלקוחות
				if(c[i]!=null){
					if(c[i].getPatience().ordinal()<5){//במידה והלקוח לא בקצה הסבלנות אז הוא מתעצבן יותר
							c[i].upLevel();
							canvas.hide(c[i].getImageID()+"patience");
							canvas.changeImage(c[i].getImageID()+"patience", c[i].getPatienceIMG(), 50, 50);
							canvas.show(c[i].getImageID()+"patience");
						
					}
					else if (c[i].getLeavingCounter()==3){//אחרי שלקוח מגיע לקצה הסבלנות הוא מחכה עוד 3 סבבים. אחר כך הוא עוזב ויורד לשחקן חיים
						canvas.deleteShape(c[i].getImageID());
						canvas.deleteShape(c[i].getImageID()+"patience");
						c[i].upLevel();//במידה ונגמרו החיים לשחקן - נגמר המשחק
						content.customers().removeCustomer(c[i].getImageID());
						content.score().getLabel().setText(String.valueOf(content.player().getScore()));
						content.lives().getLabel().setText(String.valueOf(content.player().getLives()));
						
					}
					else{
						c[i].increaseLeavingCounter();//מקדם את הלקוח שלב לקראת עזיבה
					}
				}
			}

			if (fliesTime<content.board().getFliesArrival()){
				content.board().setFliesTime(fliesTime+1);
			}
			else if (fliesTime>content.board().getFliesArrival()){//מוריד ניקוד כל 2 פרקי זמן אם יש זבובים
				content.player().changeScore(-1);
				content.score().getLabel().setText(String.valueOf(content.player().getScore()));
				content.board().setFliesTime(fliesTime+1);
			}
			else{
				canvas.show("flies");
				content.board().setFliesTime(fliesTime+1);

			}
			if(canvas.getShape("gas").getStatus()==STATUS.SHOW){//מסתיר את הכז במידה ומוצג
				canvas.hide("gas");
			}

			for (int j = 0; j < c.length; j++) {//בודק אם יש תאים ריקים במערך הלקוחות ורק אם כן אז מפעיל את הפונקציה של הוספה
				if(c[j]==null){
					empty=true;
				}
			}
			if(empty && content.player().getLives()!=0){//מוסיף לקוח רק אם יש מקום פנוי והמשחק לא נגמר
				this.content.customers().addCustomer();
			}
			content.board().setCurrentDelay(0);//מאפס את המונה עבור האצת קצב המשחק
			if(delay>content.board().getMinDelay()){//קובע קצב משחק מקסימלי
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

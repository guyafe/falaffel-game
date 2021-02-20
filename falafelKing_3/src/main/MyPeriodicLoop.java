package main;

import game.Game;
import game.PeriodicLoop;
import gui.GameCanvas;
import my_game.customer;
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
		int fliesTime=content.spray().getFliesTime();
		
		if(content.flow().getPausedStatus()==false){
			if(canvas.getShape("gas").getStatus()==STATUS.SHOW){//מסתיר את הכז במידה ומוצג
				canvas.hide("gas");
			}
			
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

				if (fliesTime<content.spray().getFliesArrival()){
					content.spray().setFliesTime(fliesTime+1);
				}
				else if (fliesTime>content.spray().getFliesArrival()){//מוריד ניקוד כל 2 פרקי זמן אם יש זבובים
					content.player().changeScore(-1);
					content.score().getLabel().setText(String.valueOf(content.player().getScore()));
					content.spray().setFliesTime(fliesTime+1);
				}
				else{
					canvas.show("flies");
					content.spray().setFliesTime(fliesTime+1);

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
		
	}
		
	}
	
}

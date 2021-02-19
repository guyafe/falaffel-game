package my_game;

import game.MouseHandler;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import game.ShapeListener;
import main.MyContent;

public class GameFlow implements ShapeListener{
    
    private boolean isPaused=false;
    private MyContent content;
    public GameFlow(MyContent content){
        this.content=content;
    }


    public boolean getPausedStatus(){
        return this.isPaused;
    }

    public void switchPausedStatus(){
        this.isPaused= !this.isPaused;
    }


    @Override
	public void shapeClicked(String shapeID, int x, int y) {
        if (y>144){
            this.switchPausedStatus();

        }
        else{

        }
		
	}





	@Override
	public void shapeRightClicked(String shapeID, int x, int y) {
		// 
	}
	@Override
	public void mouseEnterShape(String shapeID, int x, int y) {
		//

	}
	@Override
	public void mouseExitShape(String shapeID, int x, int y) {
		//

	}
	@Override
	public void shapeMoved(String shapeID, int dx, int dy) {
		//
	}
	@Override
	public void shapeStartDrag(String shapeID) {
		//

	}
	@Override
	public void shapeEndDrag(String shapeID) {
		// 

	}
}

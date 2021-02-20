package my_game;

import game.ShapeListener;
import main.MyContent;
import game.Game;

public class Spray implements ShapeListener{

	private final String sprayImgID = "spray";
	private int fliesTimes = 0;
	private final int fliesArrival = 5;
    private MyContent content;
    public Spray(MyContent content){
        this.content=content;
    }

	public String getSprayImgID(){
		return this.sprayImgID;
	}

    public int getFliesTime(){
		return this.fliesTimes;
	}

	public int getFliesArrival(){
		return this.fliesArrival;
	}

	public void setFliesTime(int time){
		this.fliesTimes=time;
	}

	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		if(this.content.flow().getPausedStatus()==false){
            Game.audioPlayer().play("resources/spray.wav", 1);
            Game.UI().canvas().hide("flies");
            this.fliesTimes=0;
            Game.UI().canvas().show("gas");
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
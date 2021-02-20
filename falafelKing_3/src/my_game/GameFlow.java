package my_game;

import game.AudioPlayer;
import game.ShapeListener;

public class GameFlow implements ShapeListener{
    
    private boolean isPaused=false;
    private boolean musicPaused=true;
    private AudioPlayer audio = new AudioPlayer();
    public GameFlow(){

    }

    public boolean getPausedStatus(){
        return this.isPaused;
    }

    public boolean getMusicStatus(){
        return this.isPaused;
    }

    public void switchMusicStatus(){
        if (this.musicPaused==true) {
            audio.play("resources/theme.wav", 0);
        }
        else {
            audio.stop();
        }
        this.musicPaused= !this.musicPaused;

    }

    public void switchPausedStatus(){
        this.isPaused= !this.isPaused;
    }


    @Override
	public void shapeClicked(String shapeID, int x, int y) {
        if (y>144){//לחיצה על כפתור העצירה
            this.switchPausedStatus();
            
            if(this.isPaused){
                audio.stop();
            }
            else if(this.musicPaused==false){
                audio.play("resources/theme.wav", 0);
            }
        }
        else if(this.isPaused==false){//לחיצה על כפתור המוזיקה במידה וניתן
            this.switchMusicStatus();
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

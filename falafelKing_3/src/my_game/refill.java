package my_game;

import DB.ExcelTable;
import game.MouseHandler;
import game.Game;
import game.PeriodicLoop;
import shapes.Image;
import shapes.TextLabel;
import game.ShapeListener;
import gui.GameCanvas;
import main.MyContent;

public class refill implements ShapeListener {

	private final String[] img = {"resources/sell_in.png", "resources/sell_out.png"};
	private final String imgID="seller";
	private  int index=0;
	private MyContent content;

	public refill(MyContent content) {
        this.content=content;
	}

    public int getIndex(){
        return this.index;
    }

    public String getImage() {
		return this.img[this.index];
	}

	public String getImageID() {
		return this.imgID;
	}

    public void switchImage() {
		this.setImage(1 - this.index);
	}

    public void setImage(int index) {
		this.index = index;
		if (index == 0) {
			Game.UI().canvas().changeImage(imgID, getImage(), 130, 280);
		}
		else {
			// Image g = (Image) Game.UI().canvas().getShape(imgID);
			
			Game.UI().canvas().changeImage(imgID, getImage(), 1000, 1000);
			// g = (Image) Game.UI().canvas().getShape(imgID);

		}
	}		
	@Override
	public void shapeClicked(String shapeID, int x, int y) {
		this.index=1-this.index;
		if(this.index==0){
			if(x>345 || y>465 && x>306){
				this.content.hummus().refill();
				this.content.salad().refill();
				this.content.fries().refill();
				this.content.falafel().refill();
			}
			else {
				Image g = (Image) Game.UI().canvas().getShape(shapeID);
				g.setBound(130, 280);
				Game.UI().canvas().changeImage(shapeID, getImage(), 130, 280);
				Game.UI().canvas().moveToLocation(shapeID, 123, 362);
				// this.switchImage();
			}

        }
        else {
			Image g = (Image) Game.UI().canvas().getShape(shapeID);
			// g.getImg().setBounds(g.getPosX(), g.getPosY(), 1000, 1000);
			g.setBound(430, 410);
            Game.UI().canvas().changeImage(shapeID, getImage(), 430, 410);
			Game.UI().canvas().moveToLocation(shapeID, 90, 240);
			// g = (Image) Game.UI().canvas().getShape(shapeID);
			// this.switchImage();
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

package my_game;

import org.apache.poi.ss.usermodel.Color;

import game.Game;
import shapes.Image;
import shapes.TextLabel;

public class player implements PlayerListener {
    public String userName;
    public int score;
    public int lives;
    BoardListener boardListener;

    public player (String name, BoardListener theBoard) {//זה הבנאי של המחלקה, השם בסוגריים כי זה פרמטר שמישהו אחר מביא לו, בהמשך יש את הדברים הקבועים שקורים עם תחילת מהחלקה//
        userName=name;
        score=0;
        lives=3;
        boardListener = theBoard;
    }
    public String getUserName(){
        return this.userName;
    }
    public int getScore(){
        return this.score;
    }
    public int getLives(){
        return this.lives;
    }
   
    public void customerLostPatience(){
        this.lives--;
        this.score-=5;
        if (this.lives==1){
            TextLabel txt =(TextLabel) Game.UI().canvas().getShape("lives");
            txt.getLabel().setForeground(java.awt.Color.red);

        }
        else if (this.lives==0){
            this.gameOver();
        }
    }
    public void playerSuccessInServing(){
         this.score = this.score+5;
     }

     public void changeScore(int diff){
         this.score+=diff;
     }
     public void gameOver (){
        // boardListener.playerLostTheGame();
        // Game.UI().canvas().getShape("lives").setzOrder(0);
        Image img = new Image("over", "resources/game_over.png", 1000, 500, 500, 450);
        img.setzOrder(6);
        Game.UI().canvas().addShape(img);
               
        TextLabel txt = (TextLabel) Game.UI().canvas().getShape("score");
        txt = new TextLabel("finalScore", "YOUR FINAL SCORE IS: "+txt.getLabel().getText(), 200, 600);
        txt.setzOrder(6);
        txt.setFontSize(45);
        // txt.setFontName("david");
        txt.getLabel().setForeground(java.awt.Color.black);
		Game.UI().canvas().addShape(txt);

        Game.UI().canvas().hide("lives");
        Game.UI().canvas().hide("score");
        Game.UI().canvas().hide("hummusAmount");
        Game.UI().canvas().hide("saladAmount");
        Game.UI().canvas().hide("friesAmount");
        Game.UI().canvas().hide("falafelAmount");
        Game.UI().canvas().hide("header");

        for (int i = 0; i < 4; i++) {//לשנות את ה-4 למשהו יותר אסוציאטיבי
            Game.UI().canvas().deleteShape(String.valueOf(i));
            Game.UI().canvas().deleteShape(String.valueOf(i)+"patience"); 
        }
        
        Game.endGame();
        
     }

}
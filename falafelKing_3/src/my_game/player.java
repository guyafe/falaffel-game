package my_game;

import game.Game;
import gui.GameCanvas;
import shapes.Image;
import shapes.TextLabel;

public class player implements PlayerListener {
    private String userName;
    private int score;
    private int lives;
    private BoardListener boardListener;

    public player (String name, BoardListener theBoard) {//זה הבנאי של המחלקה, השם בסוגריים כי זה פרמטר שמישהו אחר מביא לו, בהמשך יש את הדברים הקבועים שקורים עם תחילת מהחלקה//
        this.userName=name;
        this.score=0;
        this.lives=3;
        this.boardListener = theBoard;
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
        GameCanvas canvas = Game.UI().canvas();
        Image img = new Image("over", "resources/game_over.png", 1000, 500, 500, 450);
        img.setzOrder(6);
        canvas.addShape(img);
               
        TextLabel txtFinalScore = new TextLabel("finalScore", "YOUR FINAL SCORE IS: "+ this.score, 200, 600);
        txtFinalScore.setzOrder(6);
        txtFinalScore.setFontSize(45);
        txtFinalScore.getLabel().setForeground(java.awt.Color.black);
		canvas.addShape(txtFinalScore);

        canvas.hide("lives");
        canvas.hide("score");
        canvas.hide("hummusAmount");
        canvas.hide("saladAmount");
        canvas.hide("friesAmount");
        canvas.hide("falafelAmount");
        canvas.hide("header");

        for (int i = 0; i < 4; i++) {//לשנות את ה-4 למשהו יותר אסוציאטיבי
            canvas.deleteShape(String.valueOf(i));
            canvas.deleteShape(String.valueOf(i)+"patience"); 
        }
        Game.endGame();
     }

}
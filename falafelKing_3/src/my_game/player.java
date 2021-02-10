package my_game;

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
        lives = lives-1;
        if (lives==0)
        {boardListener.playerLostTheGame();
        }
    }
    public void playerSuccessInServing(){
         this.score = this.score+50;
     }

}
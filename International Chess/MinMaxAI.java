import java.util.Random;
import java.util.ArrayList;
public class MinMaxAI {
    int maxDepth;
    Random rand;

    public void makeMove(IChess game, Move move){
        game.makeMoveAI(move.getX0(),move.getY0(),move.getX1(),move.getY1());
    }


}

import java.util.Random;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class MinMaxAI {
    int maxDepth;
    Random rand = new Random();
    public MinMaxAI(int maxDepth, long seed){
        this.maxDepth = maxDepth;
        this.rand.setSeed(seed);
    }

    public void makeMove(IChess game, Move move){
        game.makeMoveAI(move.getX0(),move.getY0(),move.getX1(),move.getY1());
    }


    public Move generateNextMove(IChess game){
        ArrayList<Move> moves = game.getMoves();
        int index = rand.nextInt(moves.size());
        Move nextmove = moves.get(index);
        return nextmove;
    }


}

import java.awt.*;
import javax.swing.*;

/*represent a RookPiece*/
public class CastlePiece extends Piece{
  private ChessBoard chessBoard = getChessBoard();
  private boolean isMoved = false;
  private boolean isShifted = false;
  /*create a RookPiece*/
  public CastlePiece(ChessBoard board, Color color, String label, IChess.Side side, Icon icon){
    super(board, color, label, side, icon);
  }

  public boolean isMoved(){
      return isMoved;
  }
  
  
  /*check whether the piece can move to input position
   * while there is an empty square*/
  public boolean isLegalNonCaptureMove(int x, int y){
    boolean reachable = false;
    boolean hasObstacle = false;
    /*store the result*/
    if(x != this.getRow() || y != this.getColumn()) {
      if ((Math.abs(this.getRow() - x) > 0 && y == this.getColumn()) || (Math.abs(this.getColumn() - y) > 0 && x == this.getRow())) {
        reachable = true;
        if(Math.abs(this.getRow() - x) > 0){
          int i = this.getRow();
          int stepx = (x - i) / Math.abs(x - i);
          while (i != x && !hasObstacle) {
            if (chessBoard.hasPiece(i + stepx, y) && (i + stepx != x)) {
              hasObstacle = true;
            } else {
              i = stepx + i;
            }
          }
        }
        else{
          int j = this.getColumn();
          int stepy = (y - j) / Math.abs(y - j);
          while (j != y && !hasObstacle) {
            if (chessBoard.hasPiece(x, j + stepy) && j + stepy != y) {
              hasObstacle = true;
            } else {
              j = stepy + j;
            }
          }
        }

      } else {
        reachable = false;
      }
    }

    return !hasObstacle && reachable;
  }
  
}
      
    
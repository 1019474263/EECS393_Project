import java.awt.*;
import javax.swing.*;


/*represent a KnightPiece*/
public class IKnightPiece extends Piece{
  private ChessBoard chessBoard = getChessBoard();
  /*create a KnightPiece*/
  public IKnightPiece(ChessBoard board, Color color, String label, IChess.Side side, Icon icon){
    super(board, color, label, side, icon);
  }
  
  /*check whether the piece can move to input position
   * while there is an empty square*/
  public boolean isLegalNonCaptureMove(int x, int y){
    if((Math.abs(x - this.getRow()) == 2 && Math.abs(y - this.getColumn()) == 1) || (Math.abs(x - this.getRow()) == 1 && Math.abs(y - this.getColumn()) == 2)){
      return true;
    }
    else{
      return false;
    }
  }
}
    
import java.awt.*;
import javax.swing.*;

/*represent a KingPiece*/
public class IKingPiece extends Piece{
  /*create a KingPiece*/
  public IKingPiece(ChessBoard board, Color color, String label, IChess.Side side, Icon icon){
    super(board, color, label, side, icon);
  }
  
  /*check whether the piece can move to input position
   * while there is an empty square*/
  public boolean isLegalNonCaptureMove(int x, int y){
    /*store the result*/
        if(Math.abs(this.getRow() - x) <= 1 && Math.abs(this.getColumn() - y) <= 1){
          return true;
        }
        else{
          return false;
        }
  }
  
}
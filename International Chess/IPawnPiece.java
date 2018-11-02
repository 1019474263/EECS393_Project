import java.awt.*;
import javax.swing.*;

/*represent a PawnPiece*/
public class IPawnPiece extends Piece{
  /*check whether this pawn piece has evolved*/
  private boolean isEvolved = false;
  private ChessBoard chessboard = getChessBoard();
  /*create a PawnPiece*/
  public IPawnPiece(ChessBoard board, Color color, String label, IChess.Side side, Icon icon){
    super(board, color, label, side, icon);
  }
  
  /*check whether the piece can move to input position
   * while there is an empty square*/
  public boolean isLegalNonCaptureMove(int x, int y){
    boolean result=false;
    if(isEvolved==false){
      if(this.getSide()== IChess.Side.NORTH){
              if(this.getRow() == 3 && chessboard.hasPiece(3,y) && chessboard.getPiece(3,y).getSide() != IChess.Side.NORTH&& Math.abs(this.getColumn() - y) == 1 && x - this.getRow() == 1){
                  this.getChessBoard().removePiece(3,y);
                  result = true;
              }
              else {
                  if ((x - this.getRow() == 1 || ((x == 3) && x - this.getRow() == 2)) && y == this.getColumn()) {
                      result = true;
                  }
              }
      }
      else{
              if(this.getRow() == 4 && chessboard.hasPiece(4,y) && chessboard.getPiece(4,y).getSide() != IChess.Side.SOUTH && Math.abs(this.getColumn() - y) == 1 && x - this.getRow() == -1){
                  this.getChessBoard().removePiece(4,y);
                  result = true;
              }
              else{
                  if ((x - this.getRow() == -1 || ((x == 4) && x - this.getRow() == -2)) && y == this.getColumn()) {
                      result = true;
                  }
              }
      }
    }
    else{
        /*
      if(this.getSide()== IChess.Side.NORTH){
        if((x-this.getRow()==1&&y==this.getColumn())||(x==this.getRow()&&Math.abs(y-this.getColumn())==1)){
          result=true;
        }
      }
      else{
        if((x-this.getRow()==-1&&y==this.getColumn())||(x==this.getRow()&&Math.abs(y-this.getColumn())==1)){
          result=true;
        }
      }*/
    }
    return result;
  }
  
  /*check whether the pawn piece has crossed middle of board*/
  @Override
  public void moveDone(){
    if(this.getSide()== IChess.Side.NORTH&&this.getRow()==5){
    }
    
    else if(this.getSide()== IChess.Side.SOUTH&&this.getRow()==4){
    }
  }

    @Override
    public boolean isLegalCaptureMove(int x, int y) {
      if(this.getSide() == IChess.Side.NORTH) {
          if (this.getChessBoard().getPiece(x, y).getSide() != this.getSide() && x - this.getRow() == 1 && Math.abs(y - this.getColumn()) == 1) {
              return true;
          } else {
              return false;
          }
      }
      else{
          if (this.getChessBoard().getPiece(x, y).getSide() != this.getSide() && x - this.getRow() == -1 && Math.abs(y - this.getColumn()) == 1) {
              return true;
          } else {
              return false;
          }
      }
    }
}
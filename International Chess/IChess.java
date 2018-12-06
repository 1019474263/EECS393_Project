import java.awt.*;

/*a class represent chess game, Xiangqi!*/
public class IChess implements ChessGame{
  /*check whether game starts*/
  private boolean start = true;
  /*store the side which will start game(click firstly)*/
  private Side firstSide = null;
  /*store the current side which has moved its piece*/
  private Side currentSide = null;
  
  /*create a Xiangqi board and add all the pieces needed into it*/
  public IChess(){
  firstSide = Side.NORTH;
  
  /*create the board*/
  ChessBoard game = new ChessBoard(8,8,new Display(), this);
  
  /*add RookPiece*/
  game.addPiece(new CastlePiece(game,Color.RED, "C", IChess.Side.NORTH,null),0,0);
  game.addPiece(new CastlePiece(game,Color.RED, "C", IChess.Side.NORTH,null),0,7);
  game.addPiece(new CastlePiece(game,Color.WHITE, "C", IChess.Side.SOUTH,null),7,0);
  game.addPiece(new CastlePiece(game,Color.WHITE, "C", IChess.Side.SOUTH,null),7,7);

  /*add KingPiece*/
  game.addPiece(new IKingPiece(game,Color.RED,"Ki", IChess.Side.NORTH,null),0,4);
  game.addPiece(new IKingPiece(game,Color.WHITE,"Ki", IChess.Side.SOUTH,null),7,4);
  
  /*add GuardPiece*/
  game.addPiece(new QueenPiece(game,Color.RED,"Q", IChess.Side.NORTH,null),0,3);
  game.addPiece(new QueenPiece(game,Color.WHITE,"Q", IChess.Side.SOUTH,null),7,3);
  
  /*add ElephantPiece*/
  game.addPiece(new BishopPiece(game,Color.RED,"B", IChess.Side.NORTH,null),0,2);
  game.addPiece(new BishopPiece(game,Color.RED,"B", IChess.Side.NORTH,null),0,5);
  game.addPiece(new BishopPiece(game,Color.WHITE,"B", IChess.Side.SOUTH,null),7,2);
  game.addPiece(new BishopPiece(game,Color.WHITE,"B", IChess.Side.SOUTH,null),7,5);
  
  /*add KnightPiece*/
  game.addPiece(new IKnightPiece(game,Color.RED,"K", IChess.Side.NORTH,null),0,1);
  game.addPiece(new IKnightPiece(game,Color.RED,"K", IChess.Side.NORTH,null),0,6);
  game.addPiece(new IKnightPiece(game,Color.WHITE,"K", IChess.Side.SOUTH,null),7,1);
  game.addPiece(new IKnightPiece(game,Color.WHITE,"K", IChess.Side.SOUTH,null),7,6);

  /*add PawnPiece*/
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,0);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,1);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,2);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,3);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,4);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,5);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,6);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,7);

  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,0);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,1);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,2);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,3);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,4);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,5);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,6);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,7);
  
  }
  
  /*check whether it is the right side to play*/
  @Override
  public boolean legalPieceToPlace(Piece piece){
    if(start==true&&piece.getSide()==firstSide){
      return true;
    }
    else if(start==true&&piece.getSide()!=firstSide){
      return false;
    }
    else if(start==false&&piece.getSide()!=currentSide){
      return true;
    }
    else{
      return false;
    }
  }
  
  /*check whether it is legal to move and then move the piece*/
  public boolean makeMove(Piece piece,int x, int y){
    
    if(piece.isLegalMove(x,y)==true){
      piece.getChessBoard().removePiece(piece.getRow(),piece.getColumn());
      piece.getChessBoard().addPiece(piece,x,y);
      piece.moveDone();
      
      if(start==true){
        currentSide=firstSide;
        start=false;
      }
      else if(start==false){
        currentSide=piece.getSide();
      }
      return true;
      }
    else{
      return false;
    }
  }
    
}
   
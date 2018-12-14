import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class TigerPieceTester{
  
  /*test isLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    JungleChessBoard test = new JungleChessBoard(9,7,new JungleDisplay(), new Jungle());
    JunglePiece a = new TigerPiece(test,Color.RED, "R", Jungle.Side.NORTH,null);
    test.addPiece(a,2,2);
    
    test.addPiece(new TigerPiece(test, Color.WHITE, "R",Jungle.Side.SOUTH,null),2,1);
    assertFalse(a.isLegalNonCaptureMove(2,1));/*test 0*/
    test.addPiece(new TigerPiece(test, Color.WHITE, "R",Jungle.Side.SOUTH,null),2,3);
    assertTrue(a.isLegalNonCaptureMove(2,1));/*test 1*/
    test.addPiece(new TigerPiece(test, Color.WHITE, "R", Jungle.Side.SOUTH,null),2,4);
    assertFalse(a.isLegalCaptureMove(2,1));/*test many*/
    
    assertFalse(a.isLegalNonCaptureMove(3,2));/*river move*/
    assertTrue(a.isLegalNonCaptureMove(6,2));/*jump river*/
    
  }
}
                
import java.awt.Color;

import javax.swing.Icon;

import ChessGame.Side;

public class JungleElephantPiece extends Piece{
	/* create a Elephant Piece */
	public JungleElephantPiece(ChessBoard board, Color color, String label, Jungle.Side side, Icon icon) {
		super(board, color, label, side, icon);
	}

	/*
	 * check whether the piece can move to input position while there is an empty
	 * legal square
	 */
	public boolean isLegalNonCaptureMove(int x, int y) {
		boolean result = false;
		if (this.getSide() == Jungle.Side.NORTH) {
			if ((x - this.getRow() == 1 && y == this.getColumn()) || (x == this.getRow() && Math.abs(y - this.getColumn()) == 1)) {
				result = true;
			}
		} 
		else {
			if ((x - this.getRow() == -1 && y == this.getColumn()) || (x == this.getRow() && Math.abs(y - this.getColumn()) == 1)) {
				result = true;
			}
		}
		return result;
	}
}

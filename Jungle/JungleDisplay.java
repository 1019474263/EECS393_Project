import java.awt.Color;

import javax.swing.JButton;

public class JungleDisplay extends Display {
	
  public void displayRiverSquare(JButton j, int x, int y){
	    j.setIcon(null);
	    j.setBackground(Color.blue);
	    j.setText("");
  }
  
  public void displayBaseSquare(JButton j, int x, int y){
	  	j.setIcon(null);
	    j.setBackground(Color.black);
	    j.setText("Base");
  }
  
  public void displayTrapSquare(JButton j, int x, int y){
	  	j.setIcon(null);
	    j.setBackground(Color.green);
	    j.setText("Trap");
  }
}

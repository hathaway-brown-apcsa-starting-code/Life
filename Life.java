
/**
 * Life implements the game of Life, by 
 * <a href = "https://en.wikipedia.org/wiki/John_Horton_Conway">John Conway</a>.
 * <p>
 * More about the game of Life: 
 * <a href = "https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia</a>
 * 
 *
 * @author Michael Buescher and APCS @ HB
 * @version 2018
 */

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Life extends JFrame
{
  private LifeDisplayPanel gameDisplay;
  private LifeControlPanel controls;
  private LifeBoard gameBoard;
  
  public Life()
  {
    super("Life");

    gameBoard = new LifeBoard();
    gameDisplay = new LifeDisplayPanel(gameBoard);
    controls = new LifeControlPanel(gameBoard, gameDisplay);

    Container c = getContentPane();
    c.add(controls, BorderLayout.NORTH);  
    c.add(gameDisplay, BorderLayout.CENTER);
  }

  public LifeDisplayPanel getGameBoard () { return gameDisplay; }
  public LifeControlPanel getControlPanel () { return controls; }
  
  public static void main(String[] args)
  {
    Life window = new Life();
    int width = window.getGameBoard().getMaxX() + 5;
    int height = window.getGameBoard().getMaxY() + 63;
    window.setBounds(100, 100, width, height);
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

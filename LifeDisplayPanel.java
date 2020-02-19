
/**
 * Write a description of class LifeDisplayPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import java.util.ArrayList;

public class LifeDisplayPanel extends JPanel
  implements MouseListener
{
  private LifeBoard life;
  private int maxX, maxY;
  private int cellSize;
  private int selectedRow, selectedCol;
    
  public LifeDisplayPanel(LifeBoard l)
  {
    life = l;
    cellSize = 10;
    maxX = (cellSize + 1) * (life.getCols()) + 1;
    maxY = (cellSize + 1) * (life.getRows()) + 1;
    
    setBackground(Color.WHITE);

    addMouseListener(this);

  }    

  
  // ------------------ Accessor Methods ------------------------
  public int getMaxX () { return maxX; }
  public int getMaxY () { return maxY; }
  public int getCellSize () { return cellSize; }
  public int getSelectedRow () { return selectedRow; }
  public int getSelectedCol () { return selectedCol; }
  public LifeBoard getLifeBoard ()  { return life; }
  
  // ------------------ Methods for Drawing the Board -----------
  /**
  * Repaints the LifeBoard.
  */
  public void paintGrid (Graphics g)
  {
    setBackground(Color.WHITE);
    g.setColor(Color.LIGHT_GRAY);
    
    for (int r = 0; r <= life.getRows(); r++)
    {
        //Draw a gray horizontal grid line
        int y = r * (cellSize + 1);
        g.drawLine(0, y, maxX, y);
    }
    
    for (int c = 0; c <= life.getCols(); c++)
    {
        //Draw a gray vertical grid line
        int x = c * (cellSize + 1);
        g.drawLine(x, 0, x, maxY);
    }
  }
  
  public void paintCells (Graphics g)
  {
      g.setColor(Color.BLUE);
      for (int r = 0; r < life.getRows(); r++)
      {
          for (int c = 0; c < life.getCols(); c++)
          {
              if (life.getCell(r,c).getValue())
              {
                  int top = r * (cellSize + 1) + 1;
                  int left = c * (cellSize + 1) + 1;
                  g.fillRoundRect (left, top, cellSize, cellSize, 2, 2);
              }
          }
      }
          
  }
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    paintGrid(g);
    paintCells(g);
  }
  
  /** 
   * Determines the cell on the board that was clicked.
   */
  public void mouseClicked(MouseEvent e) 
  {
    int x = e.getX();
    int y = e.getY();
    
    selectedCol = x / (cellSize + 1);
    selectedRow = y / (cellSize + 1);
    
    life.toggleCell (selectedRow, selectedCol);
    repaint();
      
    /* String coordMsg = "Location Clicked: x = " + x + ", y = " + y +
                      "\n  Cell Clicked: Row " + selectedRow + ", Col " + selectedCol;
    JOptionPane.showMessageDialog(null, coordMsg,
                          "You Clicked Me", JOptionPane.INFORMATION_MESSAGE);
    */  
  }
  
  
  // Interface methods Not used:
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}

}

/**
 * The controll panel for the game of Life by 
 * <a href = "https://en.wikipedia.org/wiki/John_Horton_Conway">John Conway</a>.
 * <p>
 * More about the game of Life: 
 * <a href = "https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia</a>
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LifeControlPanel extends JPanel
{

  private JButton oneGenerationButton;
  private JButton runPauseButton;
  private JButton pauseButton;
  private JLabel delayText;
  private JTextField delayValue;
  
  private boolean isRunning;

  private LifeBoard life;
  private LifeDisplayPanel display;

  // Constructor
  public LifeControlPanel(LifeBoard l, LifeDisplayPanel d)
  {
      life = l;
      display = d;
      isRunning = false;
      
      // Sets up the GUI for the Life game
      oneGenerationButton = new JButton ("One Step");
      oneGenerationButton.addActionListener(new oneGenerationButtonListener());

      runPauseButton = new JButton ("Start");
      runPauseButton.addActionListener(new startButtonListener());

      pauseButton = new JButton ("Pause");
      pauseButton.setEnabled(false);
      pauseButton.addActionListener(new pauseButtonListener());

      delayText = new JLabel("Delay (ms): ");
      delayValue = new JTextField(10);
      delayValue.setText("1000");
      
      JLabel spacer = new JLabel("          ");
      
      add(oneGenerationButton);
      add(spacer);
  //    add(runPauseButton);
  //    add(pauseButton);
  //    add(spacer);
  //    add(delayText);
  //    add(delayValue);
  }

  // ------------------------------------------------------------------    
  // What happens when the buttons are pushed.
  // ------------------------------------------------------------------
  private class oneGenerationButtonListener
      implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      /*  JOptionPane.showMessageDialog(null, "One Step Button Pushed",
                          "It works", JOptionPane.INFORMATION_MESSAGE); */
      
      life.runOneGeneration();
      display.repaint();
    }
  }
  
  private class startButtonListener
      implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (isRunning)
      {
        oneGenerationButton.setEnabled(true);
        runPauseButton.setText("Start");
        isRunning = false;
      }
      else
      {
        oneGenerationButton.setEnabled(false);
        runPauseButton.setText("Pause");
        isRunning = true;
      }
      JOptionPane.showMessageDialog(null, "Start/Pause Button Pushed\nisRunning = " + isRunning,
                          "It works", JOptionPane.INFORMATION_MESSAGE);
    }
  }  
  
  private class pauseButtonListener
      implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      JOptionPane.showMessageDialog(null, "Pause Button Pushed",
                          "It works", JOptionPane.INFORMATION_MESSAGE);
    }
  }

}

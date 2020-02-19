
/**
 * A Cell represents a cell in the game of Life, by 
 * <a href = "https://en.wikipedia.org/wiki/John_Horton_Conway">John Conway</a>.
 * <p>
 * More about the game of Life: 
 * <a href = "https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia</a>
 *  
 * @author Michael Buescher and APCS @ HB
 * @version 2018
 */
public class Cell
{
    private boolean value;
    private boolean nextValue;
    private int numNeighbors;
    
    // ------------------------ Constructor -----------------------
    public Cell ()
    {
        value = false;
    }
    
    // ------------------------  Accessors  -----------------------
    public boolean getValue ()         { return value; }
    public boolean getNextValue ()     { return nextValue; }
    public int getNunNeighbors ()      { return numNeighbors; }
    
    
    // ------------------------  Mutators and Similar Methods -------------
    public void setValue (boolean v)        { value = v; }
    public void setNextValue (boolean v)    { nextValue = v; }
    public void setNumNeighbors (int n)     { numNeighbors = n; }
    
    /**
     * Changes the state of the cell.
     * 
     * @return the new state
     */
    public boolean toggle ()
    {
        value = !value;
        return value;
    }
    
    /** 
     * Calculates the state of the cell for the next generation.
     * 
     * Uses the standard rules of Life:
     *   A living cell with 0 or 1 living neighbors dies of loneliness
     *   A living cell with 2 or 3 living neighbors continues living
     *   A living cell with more than 3 living neighbors dies of overcrowding
     *   A dead cell with exactly 3 living neighbors gets born
     */
    public void calculateNext ()
    {
    }
}

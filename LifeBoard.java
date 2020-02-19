
/**
 * A LifeBoard represents a playing space for the game of Life, by 
 * <a href = "https://en.wikipedia.org/wiki/John_Horton_Conway">John Conway</a>.
 * <p>
 * More about the game of Life: 
 * <a href = "https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia</a>
 * 
 *
 * @author Michael Buescher and APCS @ HB
 * @version 2018
 */
public class LifeBoard
{
    private int numRows, numCols;
    private Cell[][] board;
    
    // ------------------  Constructors -----------------------------
    /**  
     * The default constructor makes a 30 x 50 board
     */
    public LifeBoard ()
    {
        numRows = 30;
        numCols = 50;
        board = new Cell[numRows][numCols];
        
        for (int row = 0; row < numRows; row++)
          for (int col = 0; col < numCols; col++)
            board[row][col] = new Cell();
    }
    
    /**
     * Constructs a board with the specified number of rows and columns
     * 
     * @param r the number of rows
     * @param c the number of columns
     */
    public LifeBoard (int r, int c)
    {
        numRows = r;
        numCols = c;
        board = new Cell[numRows][numCols];
                
        for (int row = 0; row < numRows; row++)
          for (int col = 0; col < numCols; col++)
            board[row][col] = new Cell();
    }
    
    //  --------------------  Accessors  ------------------------------
    public int getRows ()  { return numRows; }
    public int getCols ()  { return numCols; }
    public Cell getCell (int r, int c)  { return board[r][c];  }
    
    //  --------------------  Modifiers  ------------------------------
    public void setRows ()  { /* not implemented */ };
    public void setCols ()  { /* not implemented */ };
    public void toggleCell (int r, int c)
    {
        getCell(r, c).toggle();
    }
        
    // ---------------------  Game Play Methods  ----------------------
    /**
     * Counts the number of living neighbors for the Cell at row r, column c.
     * 
     * @param r the row of the Cell being checked
     * @param c the column of the Cell being checked
     * @return the number of living neighbors
     */
    public int countNeighbors (int row, int col)
    {
        int count = 0;
        
        return count;
    }
    
    /*
     * Counts the neighbors of each Cell on the board
     */
    private void countAllNeighbors ()
    {
    }
    
    /*
     * Updates the state of each Cell to the next Generation
     */
    private void nextGeneration ()
    {
        for (int r = 0; r < numRows; r++)
        {
            for (int c = 0; c < numCols; c++)
            {
                board[r][c].calculateNext();
                board[r][c].setValue(board[r][c].getNextValue());
            }
        }
    }
    
    /**
     * Updates the board for the next generation.
     */
    public void runOneGeneration ()
    {
        countAllNeighbors();
        nextGeneration();
    }
    
    
}

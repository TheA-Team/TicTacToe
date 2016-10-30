package is.TicTacToe;

public class Board {
    private Player[] board;
	
	// Default constructor.
	Board() 
	{
		board = new Player[9];
	}
	
	// Check if move is valid for 3x3 board.
	public void isValidMove(int input)
	{
		// Throws exception if 1-9 is not selected.
		if(input < 0 || input >= 9)
		{
			throw new IndexOutOfBoundsException("Input " + input + " is not between 0 and 8!");
		}
	}
	
	// Prints game board to console.
	public String printBoard() 
		{
        StringBuilder theBoard = new StringBuilder();
        for(int i = 0; i < 9; i++) 
		{
            String symbol;
			
			if(board[i] == null)
			{
				symbol = " ";
			}
			else
			{
				symbol = board[i].getSymbol();
			}
            theBoard.append(" " + symbol + " ");

            if((i + 1) % 3 == 0) 
			{
                theBoard.append(i != 8 ? "\n---+---+---\n" : "\n");
            }
			else 
			{
                theBoard.append("|");
            }
        }
        return theBoard.toString();
    }
	
	// Insert right symbol for player.
	public void insertSymbol(Player player, int input)
	{
		isValidMove(input);
		board[input] = player;
	}
	
	// Check if selected square is empty.
	public Boolean isEmpty(int input)
	{
		isValidMove(input);
		return board[input] == null;
	}
	
	// Check if player has won the game.
	public Boolean isWinner(Player p)
	{
		return winningHorizontlly(p) ||
			   winningVerticlly(p)   ||
			   winningDiagonally(p);
	}
	
	public Boolean winningHorizontlly(Player p)
	{
		for(int i = 0; i < 9; i += 3)
		{
			return(p == board[i] && p == board[i + 1] && p == board[i + 2]);
		}
		return false;
	}
	
	public Boolean winningVerticlly(Player p)
	{
		for(int i = 0; i < 9; i++)
		{
			return(p == board[i] && p == board[i + 3] && p == board[i + 6]);
		}
		return false;
	}
	
	public Boolean winningDiagonally(Player p)
	{
		return(p == board[0] && p == board[4] && p == board[8]) ||
		      (p == board[2] && p == board[4] && p == board[6]);
	}
	
	// Resets the game board to all squares to null
	public void clearBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			board[i] = null;
		}
	}
	
	// Check if the game ends with draw.
	public Boolean isDraw()
	{
		for(int i = 0; i < 9; i++)
		{
			if(board[i] == null)
			{
				return false;
			}
		}
		return true;
	}
}

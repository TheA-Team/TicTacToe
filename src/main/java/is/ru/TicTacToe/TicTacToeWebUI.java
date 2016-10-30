package is.TicTacToe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
 
public class TicTacToeWebUI implements SparkApplication {
	private static Board board;
	private static Player p1, p2, curr;
	
	// Sets up the game.
    public static void setupGame()
	{
		board = new Board();
        p1 = new Player("Player 1", "X");
        p2 = new Player("Player 2", "O");
        curr = p1;
		
		staticFileLocation("/public");
        SparkApplication webUI = new TicTacToeWebUI();
		
		String port = System.getenv("PORT");
        if(port != null)
		{
            port(Integer.valueOf(port));
        }
		else
		{
			port(1337);
		}
		
		webUI.init();
	}
	
	// Swaps players.
	public void switchPlayer()
    {
        if(curr == p1)
        {
            curr = p2;
        }
        else
        {
            curr = p1;
        }
    }
	
	// Initializes the game and starts it
	@Override
    public void init()
    {
		post("/handleMove", (req, res) -> {
            Integer cell = Integer.parseInt(req.queryParams("cell"));
            if (cell < 0 || cell > 8 || !board.isEmpty(cell)) {
                return "";
            }

            board.insertSymbol(curr, cell);
            if (board.isWinner(curr)) {
                return curr.getSymbol() + " has won!";
            } else if (board.isDraw()) {
                return "Tie!";
            } else {
                switchPlayer();
            }
            return "";
        });

        post("/resetGame", (req, res) -> {
            board.clearBoard();
            curr = p1;
            return "";
        });

        get("/currentPlayer", (req, res) -> curr.getSymbol());
    }
}

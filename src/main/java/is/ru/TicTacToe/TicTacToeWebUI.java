package is.TicTacToe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
 
public class TicTacToeWebUI implements SparkApplication {
	private static Board board;
	private static Player p1, p2, curr;
	
    public static void setupGame()
	{
		board = new Board();
        p1 = new Player("Test1", "X");
        p2 = new Player("Test2", "O");
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
	
	@Override
    public void init()
    {
		post("/handleMove", (req, res) -> {
            Integer cell = Integer.parseInt(req.queryParams("cell"));
            if (cell < 0 || cell > 8 || !board.isEmpty(cell)) {
                return "";
            }

            board.insertSymbol(curr, cell);
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

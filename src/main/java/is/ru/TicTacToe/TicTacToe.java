package is.TicTacToe;

public class TicTacToe {
	
	// Checks if the game asked for is on the web og console.
    public static void main(String[] args)
	{
		Boolean web = false;
		
		if (args.length > 0) {
            if (args[0].equals("web")) {
                web = true;
            }
        }
		
		if(web)
		{
			TicTacToeWebUI webUI = new TicTacToeWebUI();
			webUI.setupGame();
		}
		else
		{
			ConsoleUI ui = new ConsoleUI();
			ui.startGame();
		}
	}
}

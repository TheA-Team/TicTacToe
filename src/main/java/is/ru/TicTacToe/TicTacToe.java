package is.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.sc);
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

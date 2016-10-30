package is.TicTacToe;

import java.util.Scanner;


public class ConsoleUI{
    private Board board;
    private Scanner sc;
    private Player p1, p2, curr;

    ConsoleUI()
    {
		board = new Board();
		sc = new Scanner(System.in);
    }

    public int getInt(String str)
    {
		try
		{
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			return -1;
		}
    }

    public void initializeGame()
    {
        System.out.println("Enter name for player 1: ");
        p1 = new Player(sc.nextLine(), "X");
       
        System.out.println("Enter name for player 2: ");
        p2 = new Player(sc.nextLine(), "O");
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
   
    public void startGame() {
        initializeGame();
        curr = p1;
 
        System.out.println(p1.getNickname() + " vs. " + p2.getNickname());
        System.out.println("------------------------------");
        while (true) {
            System.out.println("It's your turn " + curr.getNickname());
            System.out.println(board.printBoard());
            System.out.print("Select cell from 1 to 9: ");
            int move = getInt(sc.nextLine());
            if (move < 1 || move > 9) {
                System.out.println("Invalid input. Please try again.");
                continue;
            } else if (!board.isEmpty(move - 1)) {
                System.out.println("Cell number " + move + " is not empty!. Try again.");
                continue;
            }
 
            board.insertSymbol(curr, move - 1);
 
            if (board.isWinner(curr)) {
                System.out.println(board.printBoard());
                System.out.println("Winner is: " + curr.getNickname());
                break;
            } else if (board.isDraw()) {
                System.out.println(board.printBoard());
                System.out.println("Draw!");
                break;
            }
 
            switchPlayer();
            System.out.println();
        }
    }
}

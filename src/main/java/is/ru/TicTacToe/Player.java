package is.TicTacToe;

public class Player {

    private String nickname;	// Players nick name.
	private String symbol;		// Players symbol like "X" or "O".
	
	// Constructor for player, takes nickname and symbol for player as arguments.
	Player(String nick, String symb)
	{
		setNickname(nick);
		setSymbol(symb);
	}
	
	// Returns players nickname.
	public String getNickname()
	{
		return nickname;
	}
	
	// Returns players symbol.
	public String getSymbol()
	{
		return symbol;
	}
	
	// Sets players nickname.
	public void setNickname(String nick)
	{
		nickname = nick;
	}
	
	// Sets players symbol.
	public void setSymbol(String symb)
	{
		symbol = symb.substring(0, 1);
	}
}

package is.TicTacToe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
public class ConsoleUITest {
    @Test
    public void testGetInt() {
        ConsoleUI ui = new ConsoleUI();
        assertEquals(-1, ui.getInt("asdf"));
        assertEquals(-1, ui.getInt("50asdf"));
        assertEquals(-1, ui.getInt(""));
        assertEquals(1, ui.getInt("1"));
        assertEquals(50, ui.getInt("50"));
    }
}

import component.*;
import component.keypad.TerminalNumericKeypadCellNumberConverter;
import model.Player;

public final class Launcher {
    public static void main(String[] args) {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();

        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new Player(Sign.X, new UserMove(cellNumberConverter)),
                new Player(Sign.O, new ComputerMove()),
                new WinnerVirifier(),
                new CellVerifier(), false);
        game.play();
    }

}

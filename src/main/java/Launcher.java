import component.*;
import component.keypad.TerminalNumericKeypadCellNumberConverter;

public final class Launcher {
    public static void main(String[] args) {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        //final //CellNumberConverter cellNumberConverter = new DescktopNumericKKeypadCellNumberConverter();
        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new ComputerMove(),
                new UserMove(cellNumberConverter),
                new WinnerVirifier(),
                new CellVerifier());
        game.play();
    }

}

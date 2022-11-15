package component;

import component.keypad.TerminalNumericKeypadCellNumberConverter;
import model.Player;
import model.PlayerType;

public class GameFactory {
    private final PlayerType player1Type = PlayerType.USER;
    private final PlayerType player2Type = PlayerType.COMPUTER;

    public GameFactory(final String[] args) {
    }

    public Game create(){
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();

        return new Game(
                new DataPrinter(cellNumberConverter),
                new Player(Sign.X, new UserMove(cellNumberConverter)),
                new Player(Sign.O, new ComputerMove()),
                new WinnerVirifier(),
                new CellVerifier(), false);
    }
}

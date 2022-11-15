package component;

import component.keypad.TerminalNumericKeypadCellNumberConverter;
import model.Player;
import model.PlayerType;

import static model.PlayerType.COMPUTER;
import static model.PlayerType.USER;

public class GameFactory {
    private final PlayerType player1Type;
    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        PlayerType player1Type = null;
        PlayerType player2Type = null;

        for (int i = 0; i < args.length; i++) {
            if (USER.name().equalsIgnoreCase(args[i]) || COMPUTER.name().equalsIgnoreCase(args[i])) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(args[i].toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(args[i].toUpperCase());
                } else {
                    System.err.println("Unsupported command line command: " + args[i]);
                }
            } else {
                System.err.println("Unsupported command line command: " + args[i]);
            }

        }
        if (player1Type == null) {
            this.player1Type = USER;
            this.player2Type = COMPUTER;
        } else if (player2Type == null) {
            this.player1Type = USER;
            this.player2Type = player1Type;
        } else {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }

    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        final Player player1;

        if (player1Type == USER) {
            player1 = new Player(Sign.X, new UserMove(cellNumberConverter));
        } else {
            player1 = new Player(Sign.X, new ComputerMove());
        }

        final Player player2;

        if (player2Type == USER) {
            player2 = new Player(Sign.O, new UserMove(cellNumberConverter));
        } else {
            player2 = new Player(Sign.O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                new DataPrinter(cellNumberConverter),
                player1,
                player2,
                new WinnerVirifier(),
                new CellVerifier(), false);
    }
}

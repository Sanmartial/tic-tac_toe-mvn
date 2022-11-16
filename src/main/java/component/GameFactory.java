package component;

import component.console.ConsoleDataPrinter;
import component.console.ConsoleUserInputReader;
import component.keypad.TerminalNumericKeypadCellNumberConverter;
import component.swing.GameWindow;
import model.Player;
import model.PlayerType;

import static model.PlayerType.USER;

public class GameFactory {
    private final PlayerType player1Type;
    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser parser = new CommandLineArgumentParser(args);
        final CommandLineArgumentParser.PlayerTypes playerTypes = parser.parse();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();

    }

    public Game create() {
        final GameWindow gameWindow = new GameWindow();
        //final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        final DataPrinter dataPrinter = gameWindow; //new ConsoleDataPrinter(cellNumberConverter);
        final UserInputReader userInputReader = gameWindow; //new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(Sign.X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(Sign.X, new ComputerMove());
        }

        final Player player2;

        if (player2Type == USER) {
            player2 = new Player(Sign.O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(Sign.O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVirifier(),
                new CellVerifier(), false);
    }
}

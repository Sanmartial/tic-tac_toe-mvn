package component;
import model.GameTable;
import java.util.Random;
public class Game {
    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVirifier winnerVirifier;
    private final CellVerifier cellVerifier;
    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVirifier winnerVirifier,
                final CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVirifier = winnerVirifier;
        this.cellVerifier = cellVerifier;
    }
    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9");
        dataPrinter.printMappingTable(); //display the grid on the monitor
        final GameTable gameTable = new GameTable(); // object game field
        if (new Random().nextBoolean()) { //determining who takes the next step
            computerMove.make(gameTable); // if True the next step does computer
            dataPrinter.printGameTable(gameTable); //display current gaming field
        }

        final Move[] moves = {userMove, computerMove};

        while (true) {
            boolean gamaOver = false;
            for (final Move move : moves) {
                move.make(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (move instanceof UserMove) {
                    if (winnerVirifier.isUserWin(gameTable)) { //check the user won
                        System.out.println("YOU WIN");
                        gamaOver = true;
                        break;
                    }
                } else {
                    if (winnerVirifier.isComputerWin(gameTable)) { //check the user won
                        System.out.println("Computer WIN");
                        gamaOver = true;
                        break;
                    }
                }
            }

            if (cellVerifier.allCellFilled(gameTable)) { //check the draw
                System.out.println("SORRY, DRAW");
                gamaOver = true;
                break;
            }
            if (gamaOver) {
                break;
            }
        }
       System.out.println("GAME OVER");
    }
}

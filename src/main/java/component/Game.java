package component;

import model.GameTable;
import model.Player;

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
//        if (new Random().nextBoolean()) { //determining who takes the next step
//            computerMove.make(gameTable); // if True the next step does computer
//            dataPrinter.printGameTable(gameTable); //display current gaming field
//        }

        final Player[] players = new Player[]{new Player(Sign.X, userMove), new Player(Sign.O, computerMove)};
        while (true) {

            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);

                if (winnerVirifier.isWinner(gameTable, player.getSign())) { //check the user won
                    System.out.println(player + " WIN");
                    printGameOver();
                    return;
                }

                if (cellVerifier.allCellFilled(gameTable)) { //check the draw
                    System.out.println("SORRY, DRAW");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private static void printGameOver() {
        System.out.println("GAME OVER");
    }
}

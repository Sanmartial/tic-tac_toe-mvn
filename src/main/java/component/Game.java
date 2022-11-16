package component;

import model.GameTable;
import model.Player;

import java.util.Random;

public class Game {
    private final DataPrinter dataPrinter;

    private final Player player1;
    private final Player player2;
//    private final ComputerMove computerMove;
//    private final UserMove userMove;
    private final WinnerVirifier winnerVirifier;
    private final CellVerifier cellVerifier;

    private final boolean canSecondlayerMakeFirstMove;
    public Game(DataPrinter dataPrinter, Player player1, Player player2, WinnerVirifier winnerVirifier, CellVerifier cellVerifier, boolean canSecondlayerMakeFirstMove) {
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVirifier = winnerVirifier;
        this.cellVerifier = cellVerifier;
        this.canSecondlayerMakeFirstMove = canSecondlayerMakeFirstMove;
    }

    public void play() {
        dataPrinter.printInfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9");
        dataPrinter.printMappingTable(); //display the grid on the monitor
        final GameTable gameTable = new GameTable(); // object game field
        if (canSecondlayerMakeFirstMove && new Random().nextBoolean()) { //determining who takes the next step
            player2.makeMove(gameTable); // if True the next step does computer
            dataPrinter.printGameTable(gameTable); //display current gaming field
        }

        final Player[] players = new Player[]{player1, player2};
        while (true) {

            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);

                if (winnerVirifier.isWinner(gameTable, player.getSign())) { //check the user won
                    dataPrinter.printInfoMessage(player + " WIN");
                    printGameOver();
                    return;
                }
                if (cellVerifier.allCellFilled(gameTable)) { //check the draw
                    dataPrinter.printInfoMessage("SORRY, DRAW");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private void printGameOver() {
        dataPrinter.printInfoMessage("GAME OVER");
    }
}

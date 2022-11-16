package component;

import model.GameTable;
import model.Player;

import java.util.Random;

public class Game {
    private final DataPrinterImpl dataPrinterImpl;

    private final Player player1;
    private final Player player2;
//    private final ComputerMove computerMove;
//    private final UserMove userMove;
    private final WinnerVirifier winnerVirifier;
    private final CellVerifier cellVerifier;

    private final boolean canSecondlayerMakeFirstMove;
    public Game(DataPrinterImpl dataPrinterImpl, Player player1, Player player2, WinnerVirifier winnerVirifier, CellVerifier cellVerifier, boolean canSecondlayerMakeFirstMove) {
        this.dataPrinterImpl = dataPrinterImpl;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVirifier = winnerVirifier;
        this.cellVerifier = cellVerifier;
        this.canSecondlayerMakeFirstMove = canSecondlayerMakeFirstMove;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9");
        dataPrinterImpl.printMappingTable(); //display the grid on the monitor
        final GameTable gameTable = new GameTable(); // object game field
        if (canSecondlayerMakeFirstMove && new Random().nextBoolean()) { //determining who takes the next step
            player2.makeMove(gameTable); // if True the next step does computer
            dataPrinterImpl.printGameTable(gameTable); //display current gaming field
        }

        final Player[] players = new Player[]{player1, player2};
        while (true) {

            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinterImpl.printGameTable(gameTable);

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

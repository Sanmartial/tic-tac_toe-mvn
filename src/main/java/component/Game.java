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

        while (true) {
            userMove.make(gameTable); // the user takes a step
            dataPrinter.printGameTable(gameTable); //display current gaming field
            if (winnerVirifier.isUserWin(gameTable)) { //check the user won
                System.out.println("YOU WIN");
                break;
            }
            if (cellVerifier.allCellFilled(gameTable)) { //check the draw
                System.out.println("SORRY, DRAW");
                break;
            }

            // if True the next step does computer
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable); //display current gaming field
            if (winnerVirifier.isComputerWin(gameTable)) { //check the user won
                System.out.println("Computer WIN");
                break;
            }
            if (cellVerifier.allCellFilled(gameTable)) { //check the draw
                System.out.println("SORRY, DRAW");
                break;
            }

        }
        System.out.println("GAME OVER");

    }
}

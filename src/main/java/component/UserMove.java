package component;

import model.Cell;
import model.GameTable;


public class UserMove implements Move {

private final UserInputReader userInputReader;
private final DataPrinter dataPrinter;
    private final int[][] numbers = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    public UserMove(UserInputReader userInputReader, DataPrinter dataPrinter) {
        this.userInputReader = userInputReader;
        this.dataPrinter = dataPrinter;
    }

    public void make(GameTable gameTable, final Sign sign) {
        while (true) {
            final Cell cell = userInputReader.getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Can't make a move, because the cell is not free! Try again");
            }
        }
    }



}

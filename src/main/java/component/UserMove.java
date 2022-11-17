package component;

import model.game.Cell;
import model.game.GameTable;


public class UserMove implements Move {

private final UserInputReader userInputReader;
private final DataPrinter dataPrinter;
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

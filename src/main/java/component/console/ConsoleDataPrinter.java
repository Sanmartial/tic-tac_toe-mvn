package component.console;

import component.DataPrinter;
import model.game.Cell;
import model.game.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInfoMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.err.println(message);
    }
    @Override
    public void printGameTable(GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    @Override
    public void printInstruction() {
        printInfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9");
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    private void print(Lambda lambda) {
        String lineHor = "-------------";
        for (int i = 0; i < 3; i++) {
            System.out.println(lineHor);
            String lineVertical = "|";
            for (int j = 0; j < 3; j++) {
                System.out.print(lineVertical + " " + lambda.getValue(i, j) + " ");
            }
            System.out.println(lineVertical);
        }
        System.out.println(lineHor);
    }

    private interface Lambda {
        String getValue(int i, int j);
    }
}

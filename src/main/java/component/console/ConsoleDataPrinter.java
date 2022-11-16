package component.console;

import component.CellNumberConverter;
import component.DataPrinter;
import component.DataPrinterImpl;
import model.Cell;
import model.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
    private final String lineHor = "-------------";
    private final String lineVertical = "|";
    private final int[][] numbers = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };
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
    public void printMappingTable() {
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printGameTable(GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    private void print(Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println(lineHor);
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
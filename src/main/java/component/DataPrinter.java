package component;

import model.Cell;
import model.GameTable;

public class DataPrinter {
    private final CellNumberConverter cellNumberConverter;

    public DataPrinter(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    private final String lineHor = "-------------";
    private final String lineVertical = "|";
    private final int[][] numbers = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    public void printMappingTable() {
        for (int i = 0; i < numbers[0].length; i++) {
            System.out.println(lineHor);
            System.out.print(lineVertical + " ");
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.print(cellNumberConverter.toNumber(new Cell(i, j)) + " " + lineVertical + " ");
            }
            System.out.println();
        }
        System.out.println(lineHor);

    }

    public void printGameTable(GameTable gameTable) {

        for (int i = 0; i < 3; i++) {
            System.out.println(lineHor);
            for (int j = 0; j < 3; j++) {
                System.out.print(lineVertical + " " + gameTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println(lineVertical);
        }
        System.out.println(lineHor);
    }
}

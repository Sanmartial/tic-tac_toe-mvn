package component.console.keypad;


import component.console.CellNumberConverter;
import model.game.Cell;

public class DescktopNumericKKeypadCellNumberConverter implements CellNumberConverter {

    private final int[][] numbers = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    @Override
    public Cell toCell(final int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (numbers[i][j] == number) {
                    return new Cell(i, j);
                }
            }

        }
        return null;
    }

    @Override
    public int toNumber(final Cell cell) {
        return numbers[cell.row()][cell.col()];
    }
}

package component.console;


import model.game.Cell;

public interface CellNumberConverter {
    Cell toCell(int number);
    int toNumber(Cell cell);

}

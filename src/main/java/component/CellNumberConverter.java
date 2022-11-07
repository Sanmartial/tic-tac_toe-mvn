package component;


import model.Cell;

public interface CellNumberConverter {


    Cell toCell(int number);


    int toNumber(Cell cell);

}

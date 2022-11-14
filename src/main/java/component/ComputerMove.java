package component;


import model.Cell;
import model.GameTable;
import static component.Sign.O;
import java.util.Random;

public class ComputerMove implements Move {
    public void make(GameTable gameTable) {
        while (true) {
            final int numberRow = new Random().nextInt(3);
            final int numberCol = new Random().nextInt(3);
            final Cell cell = new Cell(numberCol, numberRow);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, O);
                return;
            }
        }
    }
}

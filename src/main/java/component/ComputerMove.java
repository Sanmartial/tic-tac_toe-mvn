package component;

import model.game.Cell;
import model.game.GameTable;
import java.util.Random;

public class ComputerMove implements Move {
    public void make(GameTable gameTable, Sign sign) {
        while (true) {
            final int numberRow = new Random().nextInt(3);
            final int numberCol = new Random().nextInt(3);
            final Cell cell = new Cell(numberCol, numberRow);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            }
        }
    }
}

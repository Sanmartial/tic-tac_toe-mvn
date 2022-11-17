package component;


import model.game.Cell;
import model.game.GameTable;

public class CellVerifier {
    public boolean allCellFilled(GameTable gameTable) {
        return !isNotEmpty(gameTable);
    }


    private boolean isNotEmpty(GameTable gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

}

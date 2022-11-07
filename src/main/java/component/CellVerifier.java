package component;


import model.Cell;
import model.GameTable;

public class CellVerifier {
    public boolean allCellFilled(GameTable gameTable) {
        if (!isNotEmpty(gameTable))
            return true;
        else
            return false;
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

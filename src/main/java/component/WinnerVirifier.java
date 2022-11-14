package component;


import model.Cell;
import model.GameTable;

import static component.Sign.O;
import static component.Sign.X;
public class WinnerVirifier {

    public boolean isWinner(GameTable gameTable, Sign c) {
        if (gameTable.getSign(new Cell(0, 0)) == c && gameTable.getSign(new Cell(0, 1)) == c && gameTable.getSign(new Cell(0, 2)) == c)
            return true;
        if (gameTable.getSign(new Cell(1, 0)) == c && gameTable.getSign(new Cell(1, 1)) == c && gameTable.getSign(new Cell(1, 2)) == c)
            return true;
        if (gameTable.getSign(new Cell(2, 0)) == c && gameTable.getSign(new Cell(2, 1)) == c && gameTable.getSign(new Cell(2, 2)) == c)
            return true;

        if (gameTable.getSign(new Cell(0, 0)) == c && gameTable.getSign(new Cell(1, 0)) == c && gameTable.getSign(new Cell(2, 0)) == c)
            return true;

        if (gameTable.getSign(new Cell(0, 1)) == c && gameTable.getSign(new Cell(1, 1)) == c && gameTable.getSign(new Cell(2, 1)) == c)
            return true;
        if (gameTable.getSign(new Cell(0, 2)) == c && gameTable.getSign(new Cell(1, 2)) == c && gameTable.getSign(new Cell(2, 2)) == c)
            return true;

        if (gameTable.getSign(new Cell(0, 0)) == c && gameTable.getSign(new Cell(1, 1)) == c && gameTable.getSign(new Cell(2, 2)) == c)
            return true;
        if (gameTable.getSign(new Cell(0, 2)) == c && gameTable.getSign(new Cell(1, 1)) == c && gameTable.getSign(new Cell(2, 0)) == c)
            return true;
        else
            return false;
    }
}

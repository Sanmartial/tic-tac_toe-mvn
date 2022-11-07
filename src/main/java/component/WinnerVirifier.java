package component;


import model.Cell;
import model.GameTable;

public class WinnerVirifier {
    public boolean isUserWin(GameTable gameTable) {
        return isWinner(gameTable, 'x');
    }

    public boolean isComputerWin(GameTable gameTable) {
        return isWinner(gameTable, '0');
    }

    private boolean isWinner(GameTable gameTable, char c) {
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

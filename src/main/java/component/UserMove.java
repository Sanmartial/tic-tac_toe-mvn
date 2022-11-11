package component;


import model.Cell;
import model.GameTable;
import static component.Sign.X;
import java.util.Scanner;

public class UserMove {
    private final CellNumberConverter cellNumberConverter;

    public UserMove(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    private final int[][] numbers = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    public void make(GameTable gameTable) {
        while (true) {
            final Cell cell = getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, X);
                return;
            } else {
                System.out.println("Can't make a move, because the cell is not free! Try again");
            }
        }
    }

    private Cell getUserInput() {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            final int userInput = new Scanner(System.in).nextInt();
            if (userInput > 1 || userInput < 9) {
                return cellNumberConverter.toCell(userInput);
            }
        }
    }


}

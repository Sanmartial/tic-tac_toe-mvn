package model;

import component.Sign;

import java.util.Arrays;

import static component.Sign.EMPTY;

public class GameTable {
    private final Sign[][] table = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    public boolean isEmpty(final Cell cell) { //check cell is empty
        return table[cell.getRow()][cell.getCol()] == EMPTY;
    }

    public Sign getSign(final Cell cell) { // get content cell
        return table[cell.getRow()][cell.getCol()];
    }

    public void setSign(final Cell cell, final Sign sign) { // set cell
        table[cell.getRow()][cell.getCol()] = sign;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameTable{");
        sb.append("table=");
        for (int i = 0; i < table.length; i++) {
            sb.append(Arrays.toString(table[i]));
            if (i < table.length - 1) {
                sb.append("; ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

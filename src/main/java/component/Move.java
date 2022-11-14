package component;

import model.GameTable;

public interface Move {
    void make(GameTable gameTable, Sign sign);
}

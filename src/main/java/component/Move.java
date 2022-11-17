package component;

import model.game.GameTable;

public interface Move {
    void make(GameTable gameTable, Sign sign);
}

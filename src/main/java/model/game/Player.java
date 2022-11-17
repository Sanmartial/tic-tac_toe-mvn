package model.game;

import component.Move;
import component.Sign;
import model.game.GameTable;

public final class Player {
    private final Sign sign;
    private final Move move;

    public Player(Sign sign, Move move) {
        this.sign = sign;
        this.move = move;
    }

    public Sign getSign() {
        return sign;
    }


    public void makeMove(GameTable gameTable) {
        move.make(gameTable, sign);
    }

    @Override
    public String toString() {

        return "' " + sign + " '";
    }
}

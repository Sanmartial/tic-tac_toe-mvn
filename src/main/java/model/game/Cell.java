package model.game;

public record Cell(int row, int col) {

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

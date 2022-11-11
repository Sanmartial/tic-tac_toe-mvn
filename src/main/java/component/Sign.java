package component;

public enum Sign {

    X,
    O,
    EMPTY;


    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}

import component.*;

public final class Launcher {
    public static void main(String[] args) {
        final GameFactory gameFactory = new GameFactory(args);
        final Game game = gameFactory.create();
        game.play();
    }

}

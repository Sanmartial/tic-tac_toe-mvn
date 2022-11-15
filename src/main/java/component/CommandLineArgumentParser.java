package component;

import model.PlayerType;

import static model.PlayerType.COMPUTER;
import static model.PlayerType.USER;

public class CommandLineArgumentParser {
    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    PlayerTypes parse(){
        PlayerType player1Type = null;
        PlayerType player2Type = null;

        for (int i = 0; i < args.length; i++) {
            if (USER.name().equalsIgnoreCase(args[i]) || COMPUTER.name().equalsIgnoreCase(args[i])) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(args[i].toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(args[i].toUpperCase());
                } else {
                    System.err.println("Unsupported command line command: " + args[i]);
                }
            } else {
                System.err.println("Unsupported command line command: " + args[i]);
            }

        }
        if (player1Type == null) {
           return new PlayerTypes(USER, COMPUTER);
        } else if (player2Type == null) {
            return new PlayerTypes(USER, player1Type);
        } else {
           return  new PlayerTypes(player1Type, player2Type);
        }

    }

    public static class PlayerTypes{
        private final PlayerType player1Type;
        private final PlayerType player2Type;

        private PlayerTypes(PlayerType player1Type, PlayerType player2Type) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }
    }
}

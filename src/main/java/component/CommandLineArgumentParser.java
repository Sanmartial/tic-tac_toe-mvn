package component;

import model.PlayerType;
import model.UserInterface;

import static model.PlayerType.COMPUTER;
import static model.PlayerType.USER;
import static model.UserInterface.CONSOLE;
import static model.UserInterface.GUI;

public class CommandLineArgumentParser {
    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    CommandLineArgument parse() {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        UserInterface userInterface = null;

        for (int i = 0; i < args.length; i++) {
            if (USER.name().equalsIgnoreCase(args[i]) || COMPUTER.name().equalsIgnoreCase(args[i])) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(args[i].toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(args[i].toUpperCase());
                } else {
                    System.err.println("Unsupported command line command: " + args[i]);
                }
            }
            if (GUI.name().equalsIgnoreCase(args[i]) || CONSOLE.name().equalsIgnoreCase(args[i])) {
                if (userInterface == null) {
                    userInterface = userInterface.valueOf(args[i].toUpperCase());
                }
            } else {
                System.err.println("Unsupported command line command: " + args[i]);
            }
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        if (player1Type == null) {
            return new CommandLineArgument(USER, COMPUTER, userInterface);
        } else if (player2Type == null) {
            return new CommandLineArgument(USER, player1Type, userInterface);
        } else {
            return new CommandLineArgument(player1Type, player2Type, userInterface);
        }

    }

    public static class CommandLineArgument {
        private final PlayerType player1Type;
        private final PlayerType player2Type;
        private final UserInterface userInterface;

        private CommandLineArgument(PlayerType player1Type, PlayerType player2Type, UserInterface userInterface) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
            this.userInterface = userInterface;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}

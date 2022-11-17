package component.config;

import model.config.PlayerType;
import model.config.UserInterface;
import static model.config.PlayerType.COMPUTER;
import static model.config.PlayerType.USER;
import static model.config.UserInterface.CONSOLE;
import static model.config.UserInterface.GUI;

public class CommandLineArgumentParser {
    private final String[] args;
    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public CommandLineArgument parse() {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        UserInterface userInterface = null;

        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line command: " + arg);
                }
            }
            if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = userInterface.valueOf(arg.toUpperCase());
                }
            } else {
                System.err.println("Unsupported command line command: " + arg);
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

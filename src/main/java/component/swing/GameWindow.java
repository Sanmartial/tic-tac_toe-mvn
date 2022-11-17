package component.swing;

import component.DataPrinter;
import component.GameOverHandler;
import component.UserInputReader;
import model.game.Cell;
import model.game.GameTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame implements DataPrinter, UserInputReader, GameOverHandler {
    private static final int GAME_TABLE_SIZE = 3;//ячейки
    private static final int FONT_SIZE = 50;
    private static final int CELL_SIZE = 100;
    private final JLabel[][] cells = new JLabel[GAME_TABLE_SIZE][GAME_TABLE_SIZE];//создаем ячейки
    private Cell clickedCell;

    public GameWindow() {
        super("Tic-tac-toe");
        setSystemLookAndFeel();//устанавливаем внешний вид таким образом чтобы он повторял внешний вид ОС
        setLayout(new GridLayout(GAME_TABLE_SIZE, GAME_TABLE_SIZE));
        createGameTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        displayInTheMiddleOfTheScreen();
    }
    @Override
    public void printInstruction() {

    }
    private void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | UnsupportedLookAndFeelException |
                       IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    } //устанавливаем внешний вид таким образом чтобы он повторял внешний вид ОС

    private void createGameTable() {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                final JLabel label = new JLabel();
                cells[i][j] = label;
                label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setFont(new Font(Font.SERIF, Font.PLAIN, FONT_SIZE));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(label);
                final Cell cell = new Cell(i, j);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent unused) {
                        synchronized (GameWindow.this) {
                            clickedCell = cell;
                            GameWindow.this.notifyAll();
                        }
                    }
                });
            }
        }
    } //создаем игровое поле
    private void displayInTheMiddleOfTheScreen() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
    } //отображение игрового окна по центру

    @Override
    public void printInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void printErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void printGameTable(GameTable gameTable) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                cells[i][j].setText(String.valueOf(gameTable.getSign(new Cell(i, j))));
            }
        }
    }

    @Override
    public Cell getUserInput() {
        synchronized (this) {
            try {
                wait();
            } catch (final InterruptedException exception) {
                exception.printStackTrace();
                System.exit(2);
            }
        }
        return clickedCell;
    }

    @Override
    public void gameOver() {
        System.exit(0);
    }
}


package component.console;

import component.CellNumberConverter;
import component.DataPrinter;
import component.UserInputReader;
import model.Cell;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {
    private final CellNumberConverter cellNumberConverter;
    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(CellNumberConverter cellNumberConverter, DataPrinter dataPrinter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            //System.out.println("Please type number between 1 and 9:");
            dataPrinter.printInfoMessage("Please type number between 1 and 9:");
            final int userInput = new Scanner(System.in).nextInt();
            if (userInput > 1 || userInput < 9) {
                return cellNumberConverter.toCell(userInput);
            }
        }
    }
}

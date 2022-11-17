package component.console;

import component.DataPrinter;
import component.GameOverHandler;

public class ConsoleGameOverHandler implements GameOverHandler {

    final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("GAME OVER");
    }
}

package component;

import model.GameTable;

public interface DataPrinter {
    void printInfoMessage(String message);

    void printErrorMessage(String message);
    void printMappingTable();
    void printGameTable(final GameTable gameTable);
}

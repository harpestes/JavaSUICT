package org.example.lab8.tableConstructor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final Table table;
    @Getter
    private final List<Cell> cells;

    protected Row(Table table) {
        this.table = table;
        cells = new ArrayList<>();
    }

    public void createCell(String value) {
        if (cells.size() + 1 > table.getColumns().size()) {
            table.createColumn();
        }
        Cell newCell = new Cell(table.getColumns().get(cells.size()), this, value);
        table.getColumns().get(cells.size()).addCell(newCell);
        cells.add(newCell);
    }

    public void createCell(double value) {
        if (cells.size() + 1 > table.getColumns().size()) {
            table.createColumn();
        }
        Cell newCell = new Cell(table.getColumns().get(cells.size()), this, value);
        table.getColumns().get(cells.size()).addCell(newCell);
        cells.add(newCell);
    }
}

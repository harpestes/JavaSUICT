package org.example.lab8.tableConstructor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Column {
    @Getter
    private final Table table;
    private final List<Cell> cells;
    @Getter
    private int width;

    protected Column(Table table) {
        this.table = table;
        cells = new ArrayList<>();
        width = 0;
    }

    protected void addCell(Cell cell) {
        cells.add(cell);
        calculateWidth();
    }

    private void calculateWidth() {
        cells.stream().map(Cell::getWidth).max(Integer::compareTo).ifPresent(integer -> width = integer);
    }
}

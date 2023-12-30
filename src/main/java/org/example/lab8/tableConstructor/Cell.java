package org.example.lab8.tableConstructor;

import lombok.Getter;

public class Cell {
    private final Row row;
    @Getter
    private final Column column;
    @Getter
    private final int width;
    @Getter
    private final String value;

    public Cell(Column column, Row row, String value) {
        this.column = column;
        this.row = row;
        width = value.length();
        this.value = value;
    }

    public Cell(Column column, Row row, double value) {
        this.column = column;
        this.row = row;
        this.value = String.valueOf(value);
        width = String.valueOf(value).length();
    }
}

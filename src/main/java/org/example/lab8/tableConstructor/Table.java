package org.example.lab8.tableConstructor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Table {
    private final List<Column> columns;
    private final List<Row> rows;

    public Table() {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public Row createRow() {
        Row newRow = new Row(this);
        rows.add(newRow);
        return newRow;
    }

    protected void createColumn() {
        columns.add(new Column(this));
    }

    public void print() {
        String rowSeparator = rowSeparator();
        StringBuilder result = new StringBuilder(rowSeparator);
        rows.forEach(row -> {
            row.getCells().forEach(cell -> result.append("| ")
                    .append(cell.getValue())
                    .append(String.valueOf(' ')
                            .repeat(cell.getColumn().getWidth() - cell.getWidth() + 1)));
            result.append(" |").append("\n").append(rowSeparator);
        });
        System.out.println(result);
    }

    private String rowSeparator() {
        StringBuilder result = new StringBuilder();
        columns.forEach(column -> result.append("+-")
                .append(String.valueOf('-').repeat(column.getWidth() + 1)));
        return result.append("-+").append("\n").toString();
    }
}

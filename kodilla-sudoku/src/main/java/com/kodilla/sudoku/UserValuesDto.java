package com.kodilla.sudoku;

public class UserValuesDto {

    private final int column;
    private final int row;
    private final int value;

    public UserValuesDto(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UserValues{" +
                "column=" + column +
                ", row=" + row +
                ", value=" + value +
                '}';
    }
}

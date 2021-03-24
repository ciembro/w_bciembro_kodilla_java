package com.kodilla.sudoku;

public class DataProcessor {

    public UserValuesDto processInputValues(String input){

        String[] values = input.replaceAll("\\s", "").split(",");
        try {
            int column = Integer.parseInt(values[0]);
            int row = Integer.parseInt(values[1]);
            int value = Integer.parseInt(values[2]);
            if (isDigit(column) && isDigit(row) && isDigit(value)){
                return new UserValuesDto(column, row, value);
            }
            return null;
        } catch (NumberFormatException | IndexOutOfBoundsException e){
            return null;
        }
    }

    private boolean isDigit(int value){
        return value > 0 && value < 10;
    }

}

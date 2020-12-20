package com.kodilla.stream.array;
import java.util.stream.IntStream;

public interface ArrayOperations {

    public static double getAverage(int[] numbers){

      IntStream.range(0, 20)
                .map(i -> numbers[i]).forEach(elem -> System.out.print(elem + " "));
        System.out.println();

      double avg = IntStream.range(0,20)
              .map(n ->numbers[n])
              .average().getAsDouble();   //If a value is present in this OptionalDouble,
        // returns the value, otherwise throws NoSuchElementException.

       return avg;
    }
}

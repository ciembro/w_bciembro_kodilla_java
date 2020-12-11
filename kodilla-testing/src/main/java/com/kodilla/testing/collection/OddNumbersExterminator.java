package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> even = new ArrayList<>();

        for (int i : numbers){
            if (i % 2 == 0){
                even.add(i);
            }
        }
        return even;
    }

}

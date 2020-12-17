package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        //ZADANIE 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text = "Ala ma kota";
        System.out.println(poemBeautifier.beautify(text, t -> t + " i psa"));
        System.out.println(poemBeautifier.beautify(text, t -> t.toUpperCase()));
        System.out.println(poemBeautifier.beautify(text, t -> "*** " + t + " ***"));
        System.out.println(poemBeautifier.beautify(text, t -> t.substring(0,4)));

        //Ćwiczenia
        Processor processor = new Processor();
//        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(() -> System.out.println("This is an example text."));

        System.out.println("Lambda expressions");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a,b) -> a+b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a-b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a*b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a/b);

        System.out.println("Expressions with method reference");
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::divideAByB);

    }
}
package com.endava;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

import static com.endava.CrazyLambdas.*;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello thread");
        IntUnaryOperator intUnaryOperator = operand -> operand;
        IntPredicate intPredicate = value -> value >= 100;
        Map<String, IntUnaryOperator> map = Map.of("a", (n) -> n * 10, "b", (n) -> n * 5, "c", (n) -> n * 7);

        System.out.println("------------------------------------------------------");
        System.out.println("Hello supplier: " + helloSupplier().get());
        System.out.println("------------------------------------------------------");
        System.out.println("Is empty predicate : "  + isEmptyPredicate().test(""));
        System.out.println("------------------------------------------------------");
        System.out.println("String multiplier: " + stringMultiplier().apply("a", 3));
        System.out.println("------------------------------------------------------");
        System.out.println("To dollar string: " + toDollarStringFunction().apply(new BigDecimal(10)));
        System.out.println("------------------------------------------------------");
        System.out.println("Length is in the specified range: " + lengthInRangePredicate(3,10).test("Hello"));
        System.out.println("------------------------------------------------------");
        System.out.println("Random int supplier: " + randomIntSupplier().getAsInt());
        System.out.println("------------------------------------------------------");
        System.out.println("Random int: " + boundedRandomIntSupplier().applyAsInt(4));
        System.out.println("------------------------------------------------------");
        System.out.println("Int square: " + intSquareOperation().applyAsInt(5));
        System.out.println("------------------------------------------------------");
        System.out.println("Long sum: " + longSumOperation().applyAsLong(10987654, 2888));
        System.out.println("------------------------------------------------------");
        System.out.println("String to integer: " + stringToIntConverter().applyAsInt("10"));
        System.out.println("------------------------------------------------------");
        System.out.println("Multiply function: " + nMultiplyFunctionSupplier(10).get().applyAsInt(5));
        System.out.println("------------------------------------------------------");
        System.out.println("Accepts str to str function and returns the same function composed with trim: " + composeWithTrimFunction().apply(Function.identity()).apply("       aaaaaaa     "));
        System.out.println("------------------------------------------------------");
        System.out.println("Thread supplier: " + runningThreadSupplier(runnable).get());
        System.out.println("------------------------------------------------------");
        System.out.println("Runnable to Thread: " + runnableToThreadSupplierFunction().apply(runnable).get());
        System.out.println("------------------------------------------------------");
        System.out.println("Function to conditional function: " + functionToConditionalFunction().apply(intUnaryOperator, intPredicate).applyAsInt(25));
        System.out.println("------------------------------------------------------");
        System.out.println("Map: " + functionLoader().apply(map,"a" ).applyAsInt(10));//in case of the second argument is not a key of the map, the function should return the operand
        System.out.println("------------------------------------------------------");
        System.out.println("Well done message: " + trickyWellDoneSupplier().get().get().get());
        System.out.println("------------------------------------------------------");
    }
}

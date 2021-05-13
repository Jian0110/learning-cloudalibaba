package com.auth.service;
import java.util.*;
import	java.util.function.Predicate;
import	java.util.function.Supplier;

import java.util.function.Consumer;

public class Test {

    public static void action(String message, Consumer<String> action){
        Objects.requireNonNull(action);
        action.accept(message);
    }
    public static void action2(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }
    public static void action3(Integer value, Predicate<Integer> predicate){
        System.out.println(predicate.test(value));
    }


    public static void testConsumer(String msg){


        Consumer<String> consumer1 = message ->{
            System.out.println(message);
        };
        Consumer<String> consumer2 = message -> {
            System.out.println(message.split(",")[0]);
        };
        consumer1.andThen(consumer2).accept(msg);
    }

    public static void testSupplier(Integer value){
        Supplier<Integer> supplier = () -> {
            return value;
        };
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList("2","3","4").contains("5"));
    }

}

package com.upb.agripos;

import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        String nama = "Ahmad Rafie Ramadhani Azzaki";
        String nim = "240202849";

        BiConsumer<String, String> sayHello = (n, i) ->
                System.out.println("Hello World, I am " + n + "-" + i);

        sayHello.accept(nama, nim);
    }
}

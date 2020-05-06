package com.example.thread.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author wangyang
 * @date 2020/05/06
 */
public class FunctionConsumer {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("1");
                add("S");
                add("D");
                add("F");
                add("A");
            }
        };

        test(
                () -> list,
                System.out::println
        );
//        Function<Integer, Integer> f = s -> s++;
        Function<Integer, Integer> g = s -> s * 2;
        System.out.println(g.apply(2));


        Predicate<String> h = o -> !o.startsWith("t");
        list.stream().filter(h).forEach(System.out::println);

        list.stream().map(String::toLowerCase).forEach(System.out::println);

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        Optional<String> s = Optional.of("wwww");
        s.ifPresent(System.out::println);
    }


    private static <T> void test(Supplier<T> supplier, Consumer<T> consumer) {
        T t = supplier.get();
        consumer.accept(t);
    }
}

package xxl;

import io.vavr.collection.List;

import java.util.function.BiFunction;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        System.err.println(
                List.rangeBy(0, 10, 1)
                        .reduce(new BiFunction<Integer, Integer, Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) {
                                return integer + integer2;
                            }
                        })
        );
        System.err.println(
                List.rangeBy(0, 10, 1)
                        .fold(0, new BiFunction<Integer, Integer, Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) {
                                return integer + integer2;
                            }
                        })
        );
    }
}

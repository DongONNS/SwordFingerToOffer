package edu.csu.bingfa.completableFutrueTest;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class completableFutrueTest {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        Instant start = Instant.now();
        ForLoopCalculator forLoopCalculator = new ForLoopCalculator();
        long res1 = forLoopCalculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时为：" + Duration.between(end,start).toMillis() + "ms");

        System.out.println("计算结果为：" + res1);
    }
}

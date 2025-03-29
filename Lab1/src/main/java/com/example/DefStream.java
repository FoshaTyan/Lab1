package com.example;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class DefStream {

    public static int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static double average(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static double standardDeviation(List<Integer> list) {
        double avg = average(list);
        int size = list.size(); // N
        if (size == 0) return 0.0; // Защита от деления на 0

        double variance = list.stream()
                .mapToDouble(num -> Math.pow(num - avg, 2))
                .sum() / size;
        return Math.sqrt(variance);
    }

    public static List<Integer> multiplyByTwo(List<Integer> list) {
        return list.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    public static List<Integer> filterByThree(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0 && n % 3 == 0).collect(Collectors.toList());
    }
}


package com.example;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BenchmarkTest {
    private static final int SIZE = 10_000_000;
    private List<Integer> list;

    @Setup(Level.Iteration)
    public void setUp() {
        list = new Random().ints(SIZE, 1, 101)
                .boxed()
                .collect(Collectors.toList());
    }
    //===================================================Сума====================================
    @Benchmark
    public int sumStream() {

        return DefStream.sum(list);
    }
    @Benchmark
    public int sumParallel() {

        return ParallelStream.sum(list);
    }
    //===================================================Середнє=================================
    @Benchmark
    public double avgStream() {

        return DefStream.average(list);
    }
    @Benchmark
    public double avgParallel() {
        return ParallelStream.average(list);
    }
    //===================================================Стандартне відхилення===================
    @Benchmark
    public double DeviationStream() {
        return DefStream.standardDeviation(list);
    }
    @Benchmark
    public double DeviationParallel() {
        return ParallelStream.standardDeviation(list);
    }
    //===================================================Множення на 2===========================
    @Benchmark
    public List<Integer> multiplyStream() {
        return DefStream.multiplyByTwo(list);
    }
    @Benchmark
    public List<Integer> multiplyParallel() {

        return ParallelStream.multiplyByTwo(list);
    }
    //=================================Парні, що діляться на 3===================================
    @Benchmark
    public List<Integer> filterStream() {
        return DefStream.filterByThree(list);
    }
    @Benchmark
    public List<Integer> filterParallel() {

        return ParallelStream.filterByThree(list);
    }
}

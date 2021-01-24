package com.hyf.leetcode.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @Author huyufei on 2021/1/10
 * @Desc: TODO
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@OutputTimeUnit(value = TimeUnit.MICROSECONDS)
public class JMHTest1 {

    @State(Scope.Group)
    public static class Test {
        public Test() {
            System.out.println("create instance");
        }

        public void read() {
            System.out.println("read...");
        }

        public void write() {
            System.out.println("write...");
        }
    }

    @Benchmark
    @Group("test")
    @GroupThreads(3)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    public void testRead(Test test) {
        test.read();
    }

    @Benchmark
    @Warmup(iterations = 5)
    @Group("test")
    @GroupThreads(3)
    @Measurement(iterations = 10)
    public void testWrite(Test test) {
        test.write();
    }

    public static void main(String[] args) throws RunnerException {
        final Options opts = new OptionsBuilder()
                .include(JMHTest1.class.getSimpleName())
                .build();
        new Runner(opts).run();
    }
}

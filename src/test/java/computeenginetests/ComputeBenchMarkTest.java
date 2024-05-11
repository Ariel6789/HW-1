package computeenginetests;

import computeengine.ComputeEngineImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ComputeBenchMarkTest {

    public static void main(String[] args) {
        // Create an instance of the ComputeBenchMarkTest class
        ComputeBenchMarkTest bench = new ComputeBenchMarkTest();
        // Call the benchmarkCompute method on the created instance
        bench.benchmarkCompute();
    }

    @Test
    public void benchmarkCompute() {
        ComputeEngineImpl engine = new ComputeEngineImpl();

        // Benchmarking (Before Optimization)
        long startTimeBefore = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            engine.computePrimeFactors(ThreadLocalRandom.current().nextInt(10, 100));
        }
        long endTimeBefore = System.nanoTime();
        double totalTimeBefore = (endTimeBefore - startTimeBefore) / 1e9; // Convert to seconds

        // Optimized computePrimeFactors implementation
        engine.setComputePrimeFactorsOptimized(true);

        // Benchmarking (After Optimization)
        long startTimeAfter = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            engine.computePrimeFactors(ThreadLocalRandom.current().nextInt(10, 100));
        }
        long endTimeAfter = System.nanoTime();
        double totalTimeAfter = (endTimeAfter - startTimeAfter) / 1e9; // Convert to seconds

        // Assert that the optimized version is faster than the baseline
        Assertions.assertTrue(totalTimeBefore > totalTimeAfter, "Optimized version should be faster");

        // Print benchmarking results
        System.out.println("**Performance Improvement Summary**");
        System.out.println("  - Baseline execution time (10000 iterations): " + totalTimeBefore + " seconds");
        System.out.println("  - Optimized execution time (10000 iterations): " + totalTimeAfter + " seconds");
        System.out.println("  - Improvement: " + ((totalTimeBefore - totalTimeAfter) / totalTimeBefore) * 100 + "%");
    }
}




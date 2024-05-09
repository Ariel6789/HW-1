package computeenginetests;

import computeengine.ComputeEngine;
import computeengine.ComputeEngineImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ComputeTest {
	@Test
	public void smokeTestCompute() {
		// The computation component has very simple inputs/outputs and no dependencies, so we can
		// write a smoke test with no mocks at all

		ComputeEngineImpl engine = new ComputeEngineImpl();

		// Benchmarking (Before Optimization)
		long startTimeBefore = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			engine.computePrimeFactors(ThreadLocalRandom.current().nextInt(10, 100));
		}
		long endTimeBefore = System.nanoTime();
		double totalTimeBefore = (endTimeBefore - startTimeBefore) / 1e9; // Convert to seconds

		// Optimized computePrimeFactors`implementation
		engine.setComputePrimeFactorsOptimized(true); // Assuming setter for optimization flag

		// Benchmarking (After Optimization)
		long startTimeAfter = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			engine.computePrimeFactors(ThreadLocalRandom.current().nextInt(10, 100));
		}
		long endTimeAfter = System.nanoTime();
		double totalTimeAfter = (endTimeAfter - startTimeAfter) / 1e9; // Convert to seconds


		Assertions.assertTrue(totalTimeBefore > totalTimeAfter, "Optimized version should be faster");

		System.out.println("**Performance Improvement Summary**");
		System.out.println("  - Baseline execution time (10000 iterations): " + totalTimeBefore + " seconds");
		System.out.println("  - Optimized execution time (10000 iterations): " + totalTimeAfter + " seconds");
		System.out.println("  - Improvement: " + ((totalTimeBefore - totalTimeAfter) / totalTimeBefore) * 100 + "%");


		// Testing the computePrimeFactors for the value 1, expecting an empty array since 1 has no prime factors
        Assertions.assertArrayEquals(new int[]{}, engine.computePrimeFactors(1));

        // Additional test cases can be added as needed to thoroughly test the computePrimeFactors method
        // For example, testing the computePrimeFactors for the value 2, expecting an array containing only 2
        Assertions.assertArrayEquals(new int[]{2}, engine.computePrimeFactors(2));

        // Testing for a number with multiple prime factors, e.g., 12 = 2 * 2 * 3
        Assertions.assertArrayEquals(new int[]{2, 2, 3}, engine.computePrimeFactors(12));
	}
}
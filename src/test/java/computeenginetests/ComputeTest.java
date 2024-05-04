package computeenginetests;

import computeengine.ComputeEngine;
import computeengine.ComputeEngineImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ComputeTest {
	@Test
	public void smokeTestCompute() {
		// The computation component has very simple inputs/outputs and no dependencies, so we can
		// write a smoke test with no mocks at all
		
		ComputeEngine engine = new ComputeEngineImpl();

		for (int i = 0; i < 1000000; i++) {
			engine.computePrimeFactors(ThreadLocalRandom.current().nextInt(10, 100));
		}
		  // Testing the computePrimeFactors for the value 1, expecting an empty array since 1 has no prime factors
        Assert.assertArrayEquals(new int[]{}, engine.computePrimeFactors(1));

        // Additional test cases can be added as needed to thoroughly test the computePrimeFactors method
        // For example, testing the computePrimeFactors for the value 2, expecting an array containing only 2
        Assert.assertArrayEquals(new int[]{2}, engine.computePrimeFactors(2));

        // Testing for a number with multiple prime factors, e.g., 12 = 2 * 2 * 3
        Assert.assertArrayEquals(new int[]{2, 2, 3}, engine.computePrimeFactors(12));
	}
}
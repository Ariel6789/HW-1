package test;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.ComputeEngine;
import src.ComputeEngineImpl;
import src.ComputeRequest;

public class ComputeEngineIntegrationTest {

	@Test
	public void testComputeWorkflow() {
		
		ComputeEngine engine = new ComputeEngineImpl();
		
		TestDataStore testDs = new TestDataStore();

		InMemoryInputConfig input = new InMemoryInputConfig(1, 10, 25);
		
		InMemoryOutputConfig output = new InMemoryOutputConfig();
		
		// This is the actual object we're testing
		ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
		when(mockRequest.getInputConfig()).thenReturn(30);
		//when(mockRequest.getOutputConfig()).thenReturn(output);
		when(mockRequest.getDelimiter()).thenReturn(','); 
		
	 // Execute the computation
	 int[] actualPrimeFactors = engine.computePrimeFactors(mockRequest.getInputConfig());
        
	 // Define the expected prime factors for the input number 30
	 int[] expectedPrimeFactors = {2, 3, 5};
		
		  // Verify that the computed prime factors match the expected results
		  Assert.assertArrayEquals(expectedPrimeFactors, actualPrimeFactors);
	}
}

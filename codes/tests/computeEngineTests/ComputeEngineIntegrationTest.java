package test;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.ComputeEngine;
import src.ComputeEngineImpl;
import src.ComputeRequest;
<<<<<<< Updated upstream
import src.DataStorageAPI;
import src.ComputeResult;
import src.FileInputConfig;
=======
import src.InputConfig;



>>>>>>> Stashed changes

public class ComputeEngineIntegrationTest {

	@Test
	public void testComputeWorkflow() {
		
		ComputeEngine engine = new ComputeEngineImpl();
<<<<<<< Updated upstream
		FileInputConfig inputConfig = new FileInputConfig("path_to_file.txt");
        ComputeRequest mockRequestObj = Mockito.mock(ComputeRequest.class);
=======
		InputConfig inputConfig = new FileInputConfig("path_to_file");
		ComputeRequest mockRequestObj = Mockito.mock(ComputeRequest.class);
>>>>>>> Stashed changes
		TestDataStore testDs = new TestDataStore();

		//InMemoryInputConfig input = new InMemoryInputConfig(1, 10, 25);
		
		//InMemoryOutputConfig output = new InMemoryOutputConfig();
		
		// This is the actual object we're testing
<<<g<<<< Updated upstream
	
		when(mockRequestObj.getInputConfig()).thenReturn(inputConfig);
=======
		
		
		when(mockRequestObj.getInputConfig()).thenReturn(inputConfig);

>>>>>>> Stashed changes
		//when(mockRequest.getOutputConfig()).thenReturn(output);
		when(mockRequestObj.getDelimeter()).thenReturn(','); // Assuming the delimiter is for formatting output
		
	 // Execute the computation
	 int[] actualPrimeFactors = engine.computePrimeFactors(1);
        
	 // Define the expected prime factors for the input number 30
	 int[] expectedPrimeFactors = {2, 3, 5};
		
		  // Verify that the computed prime factors match the expected results
		  Assert.assertArrayEquals(expectedPrimeFactors, actualPrimeFactors);
	}


}
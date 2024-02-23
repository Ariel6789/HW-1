package edu.softwareeng.sample;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.softwareeng.sample.WriteResult.WriteResultStatus;

/*
 * In this case, I've split out the smoke tests into two tests, one per method. It's also fine to consolidate
 * these into a single test
 */
public class DataStorageTest {

	@Test
	public void smokeTestRead() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		InputConfig inputConfig = Mockito.mock(InputConfig.class);
		
		DataStorage dataStorage = new DataStorageImpl();
		Assert.assertEquals(1L, dataStorage.read(inputConfig));
	}
	
	@Test
	public void smokeTestWrite() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		// This is optional; for simple parameters, if it's easier to use a real one (like String),
		// feel free to do that
		OutputConfig outputConfig = Mockito.mock(OutputConfig.class);
		
		DataStorage dataStorage = new DataStorageImpl();
		
		// assertEquals will use .equals, so this type of call is generally safe for any Object, but for enums you can also use ==
		// Note that if your dummy implementation returns null, this will NPE - that's fine! As long as the test fails,
		// the exact failure doesn't matter
		Assert.assertEquals(WriteResultStatus.SUCCESS, dataStorage.appendSingleResult(outputConfig, "result").getStatus());
	}
}

package edu.softwareeng.sample;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.softwareeng.sample.WriteResult.WriteResultStatus;

/*
 * In this case, I've split out the smoke tests into two tests, one per method. It's also fine to consolidate
 * these into a single test
 */
public class DataStoreTest {

	@Test 
	public void smokeTestRead() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		DataStorage dataStorageMock = Mockito.mock(DataStorage.class);
		
		DataStore dataStore = new DataStoreImpl();
		
		when(dataStorageMock.read(any(InputConfig.class))).thenReturn(1L);
		Assert.assertEquals(1L, dataStore.read(inputConfig));
	}
	
	@Test
	public void smokeTestWrite() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		// This is optional; for simple parameters, if it's easier to use a real one (like String),
		// feel free to do that
		OutputConfig outputConfig = Mockito.mock(OutputConfig.class);
		
		DataStore dataStore = new DataStoreImpl();
		
		// assertEquals will use .equals, so this type of call is generally safe for any Object, but for enums you can also use ==
		// Note that if your dummy implementation returns null, this will NPE - that's fine! As long as the test fails,
		// the exact failure doesn't matter
		Assert.assertEquals(WriteResultStatus.SUCCESS, dataStore.appendSingleResult(outputConfig, "result").getStatus());
	}
}

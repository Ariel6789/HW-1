package src;

import java.util.Arrays;

import src.WriteResult.WriteResultStatus;

//import edu.softwareeng.sample.WriteResult.WriteResultStatus;

public class DataStoreImpl implements DataStore {

	@Override
	public WriteResult appendSingleResult(OutputConfig output, String result) {
		
		return () -> WriteResultStatus.SUCCESS; 
	}

	@Override
	public Iterable<Integer> read(InputConfig input, int i) {
		// For the test, return a dummy list of integers
        return Arrays.asList(1, 2, 3); // Example data, adjust as needed
	}

}

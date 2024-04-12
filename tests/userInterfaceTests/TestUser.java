package test;

import java.io.File;
import src.CoordinatorImpl;
import src.ComputeRequest;
import src.ComputeResult;

import org.junit.jupiter.api.Test;

public class TestUser {
	
	private final CoordinatorImpl coordinator;

	public TestUser(CoordinatorImpl coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		ComputeRequest request = null;
		ComputeResult coResult= coordinator.compute(request);
	}

}

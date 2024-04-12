import io.grpc.stub.StreamObserver;
import your.generated.proto.package.ComputationCoordinatorGrpc;
import your.generated.proto.package.Coordinate.*;

public class ComputationCoordinatorImpl extends ComputationCoordinatorGrpc.ComputationCoordinatorImplBase {

	private final ComputeEngineImpl computeEngineImpl;

	public ComputationCoordinatorImpl(ComputeEngineImpl computeEngineImpl) {
		this.computeEngineImpl = computeEngineImpl;
	}
	@Override
	public void initializeComputation(ProcessSourceRequest request, StreamObserver<ComputationOutcome> responseObserver) {
		try {
			int number = Integer.parseInt(request.getSourceFilePath()); // Assuming the number is passed as a string
			int[] factors = computeEngineImpl.computePrimeFactors(number);

			// Format the factors as a string
			String result = Arrays.toString(factors);

			// Here you would typically save the result to data storage and return the path to the saved data
			// For simplicity, we're just returning the result directly
			ComputationOutcome outcome = ComputationOutcome.newBuilder()
					.setCompletedSuccessfully(true)
					.setFeedbackMessage("Computation completed successfully.")
					.setComputationDetails("Prime factors: " + result)
					.build();

			responseObserver.onNext(outcome); //
			responseObserver.onCompleted();
		} catch (NumberFormatException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void initializeComputationWithCustomDelimiter(ProcessWithDelimiterRequest request, StreamObserver<ComputationOutcome> responseObserver) {
		// Implement computation with custom delimiter here
		ComputationOutcome outcome = ComputationOutcome.newBuilder()
				.setCompletedSuccessfully(true)
				.setFeedbackMessage("Computation with custom delimiter initialized successfully.")
				.setComputationDetails("Details of the computation with custom delimiter.")
				.build();
		responseObserver.onNext(outcome);
		responseObserver.onCompleted();
	}

	@Override
	public void assignSource(ProcessSourceRequest request, StreamObserver<SourceAssignmentResponse> responseObserver) {
		// Implement source assignment logic here
		SourceAssignmentResponse response = SourceAssignmentResponse.newBuilder()
				.setAssignedFilePath("Path to the assigned file")
				.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}

package src;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import src.StorageComputationServiceGrpc.StorageComputationServiceImplBase;
import src.StorageComputationServiceOuterClass.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorageAPI extends StorageComputationServiceImplBase {

	// Implement the rpc methods defined in .proto//
	@Override
	public void getInput(UserInput request, StreamObserver<NumericSequence> responseObserver) {
		// Implement your logic here to read numbers based on UserInput
		// For example, let's read a single number and return it in a list
		List<Integer> numbers = new ArrayList<>();
		numbers.add(request.getNumber());
		NumericSequence reply = NumericSequence.newBuilder().addAllNumbers(numbers).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public void commit(CommitParameters request, StreamObserver<CommitResponse> responseObserver) {
		// Implement your logic here to write numbers to the destination with the specified separator
		// For example, let's write the large integer to the specified file
		writeToFile(request.getStorageTarget().getDestination(),
				String.valueOf(request.getBigInteger().getBigValue()),
				request.getSeparator().getDelimiter());

		// Assume the write operation was successful and send a response
		CommitResponse reply = CommitResponse.newBuilder().build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	private void writeToFile(String fileName, String content, String delimiter) {
		// Add your file writing logic here
		try (FileWriter writer = new FileWriter(fileName, true)) {
			writer.append(content).append(delimiter);
		} catch (IOException e) {
			throw new RuntimeException("Failed to write to file: " + fileName, e);
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// The port that the server should run on can be passed as an argument
		// Defaults to 8080 if no argument is passed
		int port = args.length > 0 ? Integer.parseInt(args[0]) : 8080;
		Server server = ServerBuilder.forPort(port)
				.addService(new DataStorageAPI())
				.build()
				.start();

		System.out.println("Server started, listening on " + port);
		server.awaitTermination();
	}
}

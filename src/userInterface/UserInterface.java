import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    public static void main(String[] args) throws IOException { //
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a positive integer: ");
            long number = Long.parseLong(reader.readLine());

            // Here you would call the Compute Engine's gRPC service and pass the number
            // For now, let's simulate it with a direct method call.
            ComputeEngine engine = new ComputeEngine();
            List<Long> primeFactors = engine.calculatePrimeFactors(number);

            // Save the prime factors to a file
            DataStorage.savePrimeFactors(number, primeFactors);

            // Display the result to the user
            System.out.println("The prime factors of " + number + " are: " + primeFactors);
        }
    }
}

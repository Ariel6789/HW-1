package userinterface;

import datastorage.DataStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserInterface {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enjoy this Prime Factors Calculator!");

            // Promp user to choose input method
            System.out.println("Choose input method:");
            System.out.println("1. Enter a number directly");
            System.out.println("2. Read a number from a file");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter a positive integer: ");
                    int number = Integer.parseInt(reader.readLine());
                    processNumber(number); // Process the input number
                    break;
                case 2:
                    System.out.print("Enter the path of the file containing the number: ");
                    String filePath = reader.readLine();
                    processFile(filePath); // Process the number from the file
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 or 2.");
            }
        }
    }

    // Process the input number
    private static void processNumber(int number) throws IOException {
        computeengine.ComputeEngine engine = new computeengine.ComputeEngineImpl();
        var primeFactors = engine.computePrimeFactors(number);
        displayResult(number, primeFactors); // Display the result
    }

    // Process the number from the file
    private static void processFile(String filePath) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line = fileReader.readLine();
            if (line == null) {
                System.out.println("File is empty.");
                return;
            }
            int number = Integer.parseInt(line.trim());
            processNumber(number); // Process the input number
        }
    }

    // Display the result to the user
    private static void displayResult(int number, int[] primeFactors) throws IOException {
        // Save the prime factors to a file (optional)
        DataStore.savePrimeFactors(number, primeFactors);

        // Display the result to the user
        System.out.println("The prime factors of " + number + " are: " + Arrays.toString(primeFactors));
    }
}

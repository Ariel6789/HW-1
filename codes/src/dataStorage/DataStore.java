
package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface DataStore { //
	public static void savePrimeFactors(long number, List<Long> primeFactors) throws IOException {
		String fileName = "prime_factors_of_" + number + ".txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("Prime factors of " + number + ": " + primeFactors);
		}
	}
}
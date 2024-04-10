package src;


public class ComputeEngineImpl implements ComputeEngine, ComputationCoordinator {

	@Override
	public int[] computePrimeFactors(int value) {
		return primeFactors(value);
	}

	public int[] primeFactors(int number) { //
        int[] tempFactors = new int[number];
		int count = 0; // Count of prime factors

        // Divide by 2 to find even prime factors
        while (number % 2 == 0) {
            tempFactors[count++] = 2;
            number /= 2;
        }

		// Find odd prime factors
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                tempFactors[count++] = i;
                number /= i;
            }
        }

        // If number is a prime number greater than 2
        if (number > 2) {
            tempFactors[count++] = number;
        }

        // Copy the prime factors into a properly sized array
        int[] primeFactors = new int[count];
        System.arraycopy(tempFactors, 0, primeFactors, 0, count);

        return primeFactors;
    }

	@Override
	public ComputeResult compute(ComputeRequest request) {
		@SuppressWarnings("unused")
		DataStorageAPI dataStore = new DataStorageAPI();
		@SuppressWarnings("unused")
		InputConfig inputConfig = request.getInputConfig();
		return null;
	}
   
    @Override
    public String compute(int val) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

   

}

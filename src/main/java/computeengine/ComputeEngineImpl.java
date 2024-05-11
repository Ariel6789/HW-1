package computeengine;

import request.ComputeRequest;
import result.ComputeResult;

public class ComputeEngineImpl implements computeengine.ComputeEngine, computeengine.ComputationCoordinator {

    private boolean computePrimeFactorsOptimized = false; // Flag for optimized version (assuming setter exists)

    // Existing method
    @Override
    public String compute(int val) {
        return "";
    }

    // New and modified method
    @Override
    public ComputeResult compute(ComputeRequest request) {
        String valStr = request.getInput();
        int value;
        try {
            value = Integer.parseInt(valStr);
        } catch (NumberFormatException e) {
            // If parsing fails, return NOT_AN_INTEGER
            return ComputeResult.Not;
        }

        int[] primeFactors = computePrimeFactors(value);

        if (primeFactors.length > 0) {
            return ComputeResult.SUCCESS;
        }

        return ComputeResult.FAIL;
    }

    // New and modified method
    @Override
    public int[] computePrimeFactors(int number) {
        if (number <= 1) {
            return new int[0];
        }
        int[] tempFactors = new int[number];
        int count = 0;

        // Optimized version with loop optimizations and square root check
        if (computePrimeFactorsOptimized) {
            // Divide by 2 efficiently (works for even and odd numbers)
            while (number % 2 == 0) {
                tempFactors[count++] = 2;
                number /= 2;
            }
            // Optimized loop for odd factors
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                while (number % i == 0) {
                    tempFactors[count++] = i;
                    number /= i;
                }
            }
        } else {
            // Standard implementation (for comparison or testing)
            for (int i = 2; i <= number; i++) {
                while (number % i == 0) {
                    tempFactors[count++] = i;
                    number /= i;
                }
            }
        }

        // Copy prime factors into a properly sized array
        int[] primeFactors = new int[count];
        System.arraycopy(tempFactors, 0, primeFactors, 0, count);

        return primeFactors;
    }

    //// Setter for optimization flag (assuming you have this mechanism in your code)
    public void setComputePrimeFactorsOptimized(boolean optimized) {
        this.computePrimeFactorsOptimized = optimized;
    }


}

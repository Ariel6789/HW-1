## Project Computation Description:

Calculate all prime factors of a given positive integer.
##### Input: A single positive integer n, where 1 ≤ n < Integer.MAX_VALUE.
##### Output: A list of prime factors of n.
---
### System Diagram:
![System Diagram for softeng](https://github.com/Ariel6789/HW-1/assets/157422509/eb69617d-7cbf-4a6d-bca3-10bee677463b)

---
Whys Analysis: Difficulty Evaluating Performance Improvement
Problem: Initially, we struggled to show the actual improvement achieved by optimizing the computePrimeFactors method.
Why 1: We focused primarily on documenting the core functionality of computePrimeFactors.
Why 2 : The assumption was that the optimized version was an internal implementation detail, not necessarily user-facing functionality.
Why 3 : We hadn't considered the potential benefit of users being aware of the optimized option.
Why 4: Without pre-optimization data, it's impossible to quantify the effectiveness of the implemented optimizations.
Why 5: This lack of data made it difficult to convince myself and others that the optimizations were actually making a difference.
Actionable Process Change:
I learned to use System.nanoTime() to consistently measure execution time throughout the project. Updated the project documentation to include a clear explanation of the computePrimeFactorsOptimized method.This should detail its purpose, usage instructions, and any relevant performance benchmarks compared to the standard version. 


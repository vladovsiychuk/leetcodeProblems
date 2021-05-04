package count_primes_204;

public class Solution {
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] numbers = new boolean[n];
        for (int p = 2; p <= (int)Math.sqrt(n); ++p) {
            if (numbers[p] == false) {
                for (int j = p*p; j < n; j += p) {
                    numbers[j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i] == false) {
                ++numberOfPrimes;
            }
        }

        return numberOfPrimes;
    }


    public static int countPrimes2(int n) {
        if (n < 2) return 0;
        boolean[] nonPrime = new boolean[n];
        nonPrime[1] = true;
        int numNonPrimes = 1;
        for (int i=2; i < n; i++) { // O(n)
            if (nonPrime[i]) continue;
            int j = i * 2;
            while (j < n) { // O(log(log(n)))
                if (!nonPrime[j]) {
                    nonPrime[j] = true;
                    numNonPrimes++;
                }
                j += i;
            }
        }
        return (n-1) - numNonPrimes;
    }
}

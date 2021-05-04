package count_primes_204;

public class My {
    public static int result(int n) {

        if (n < 2)
            return 0;

        int res = 0;
        boolean notPrimes[] = new boolean[n];

        for(int i=2; i < n; i++) {
            if (i*2 >= n)
                break;

            if(!notPrimes[i]) {
                for(int j=i*2; j < n; j = j+i) {
                    notPrimes[j] = true;
                }
            }
        }

        for(int i = 2; i < n; i++)
            if (notPrimes[i] == false)
                res++;

        return res;
    }
}

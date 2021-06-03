package reverse_bits_190;

public class My {
    public static int result(int n){

        int res = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            res |= (mask & n);
            res <<= 1;
            n >>= 1;
        }

        return res;
    }
}


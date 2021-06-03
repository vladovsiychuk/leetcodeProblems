package sqrt_x_69;

public class Solution {
    public static int result(int x){
        long l = 0, r = x;

        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (mid * mid <= x) // int would overflow here
                l = mid;
            else
                r = mid - 1;
        }

        return (int) l;
    }
}


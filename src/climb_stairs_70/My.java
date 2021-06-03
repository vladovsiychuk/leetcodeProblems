package climb_stairs_70;

import java.util.HashMap;

public class My {
    public static int result(int n){
        HashMap<Integer,Integer> cache = new HashMap<>();
        return climbStairs(n, cache);
    }

    private static int climbStairs(int n, HashMap<Integer, Integer> cache) {
        if (n == 0 || n == 1) return n;

        if (cache.containsKey(n))
            return cache.get(n);
        else
            cache.put(n,climbStairs(n-1, cache) + climbStairs(n - 2, cache));
        return cache.get(n);
    }
}


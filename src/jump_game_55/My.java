package jump_game_55;

public class My {
    public boolean result(int[] nums){
        int n = nums.length;
        if (n == 1)
            return true;
        int distance = 1;
        boolean[] can = new boolean[n];
        for (int i = n-2; i >= 0; i--){
            if (nums[i] >= distance){
                can[i] = true;
                distance = 1;
            }else
                distance++;
        }
        return can[0];
    }
}


package single_number_136;

public class My {
    public int result(int[] nums){
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}


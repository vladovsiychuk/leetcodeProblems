package product_of_array_except_self_238;

public class My {
    public int[] result(int[] nums){
        int[] res = new int[nums.length];
        int[] tmp = new int[nums.length];
        res[0] = 1;
        tmp[tmp.length-1] = 1;

        for (int i = 1; i < res.length; i++)
            res[i] = res[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--){
            tmp[i] = tmp[i + 1] * nums[i + 1];
            res[i] *= tmp[i];
        }

        return res;
    }
}


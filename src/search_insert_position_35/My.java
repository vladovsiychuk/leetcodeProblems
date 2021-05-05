package search_insert_position_35;

public class My {
    public static int result(int[] nums, int target){

        int tmp = 0;
        for(int i = 0; i < nums.length; i++) {
           if(nums[i] == target)
               return i;
           if(target < nums[i])
               return i;
           tmp += 1;
        }

        return tmp;
    }
}


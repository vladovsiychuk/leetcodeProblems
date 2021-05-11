package remove_duplicates_from_sorted_array_26;

public class My {
    public static int result(int nums[]){

//        Input: nums = [0,1,2,3,4,2,2,3,3,4]
//		                            ^r
//        Output: 5, nums = [0,1,2,3,4]

        int left = 0;

        for(int right = 1; right < nums.length; right++){
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }
}


package search_in_rotated_sorted_array_33;

public class My {
    public int result(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        int pMinVal = left;
        left = 0;
        right  = nums.length-1;

        if (nums[pMinVal] <= target && target <= nums[right])
            left = pMinVal;
        else
            right = pMinVal - 1;

        while (left < right){
            int mid = left + (right - left)/2;

            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}

/*
     l
    [4,5,6,7,8,1,2,3] target: 8 n:8
                   r
             m
 */
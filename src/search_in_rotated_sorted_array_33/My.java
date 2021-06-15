package search_in_rotated_sorted_array_33;

public class My {
    public int result(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target)
                return mid;

            if (target < nums[mid] && target >= nums[left]) {
                right = mid - 1;
                continue;
            }else if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
                continue;
            }else if (target < nums[mid] && target <= nums[right]) {
                left = mid + 1;
                continue;
            }else if (target > nums[mid] && target <= nums[left]) {
                right = mid - 1;
                continue;
            }
            return -1;
        }

        if (nums[left] == target)
            return left;
        return -1;
    }
}

/*
     l
    [4,5,6,7,8,1,2,3] target: 8
                   r
           m
 */
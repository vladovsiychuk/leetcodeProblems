package find_minimum_in_rotated_sorted_array_2_154;

public class My {
    public int result(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right){
            while (left != n-1 && nums[left] == nums[left+1])
                left++;

            while (right != 0 && nums[right] == nums[right - 1])
                right--;

            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}


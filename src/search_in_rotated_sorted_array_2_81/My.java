package search_in_rotated_sorted_array_2_81;

public class My {
    public boolean result(int[] nums, int target){
        int n = nums.length;
        if (n == 1)
            return true;

        int left = 0;
        int right = n-1;

        while (left < right){
            while (left!=n-1 && nums[left] == nums[left+1])
                left++;
            while (right!=0 && nums[right] == nums[right-1])
                right--;

            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        int min = left;
        left = 0;
        right = n-1;

        if (nums[min] <= target && target <= nums[right])
            left = min;
        else
            right = min - 1;

        while (left < right){
            while (left!=n-1 && nums[left] == nums[left+1])
                left++;
            while (right!=0 && nums[right] == nums[right-1])
                right--;

            int mid = left + (right-left)/2;
            if (nums[mid]==target)
                return true;

            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        if (nums[left] == target)
            return true;
        return false;
    }
}


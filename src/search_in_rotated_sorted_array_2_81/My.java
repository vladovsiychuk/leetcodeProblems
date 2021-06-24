package search_in_rotated_sorted_array_2_81;

public class My {
    public boolean result(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] >= nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        while (left != 0 && nums[left-1] == nums[left])
            left--;

        int startIndex = left;
        left = 0;
        right = n - 1;

        if (target >= nums[startIndex] && target <= nums[right])
            left = startIndex;
        else
            right = startIndex - 1;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (nums[left] == target)
            return true;
        return false;
    }
}


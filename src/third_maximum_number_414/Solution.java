package third_maximum_number_414;



public class Solution {
    public static int thirdMax(int[] nums) {
        Integer first = getMaxLowerThan(nums, null);
        if (first == null) return 0;
        Integer second = getMaxLowerThan(nums, first);
        if (second == null) return first;
        Integer third = getMaxLowerThan(nums, second);
        if (third == null) return first;
        return third;
    }

    static Integer getMaxLowerThan(int[] nums, Integer top) {
        Integer result = null;
        for(int i : nums) {
            if ((top == null || i < top) && (result == null || result < i)) result = i;
        }
        return result;
    }
}

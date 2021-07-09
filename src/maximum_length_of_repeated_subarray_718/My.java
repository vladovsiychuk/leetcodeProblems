package maximum_length_of_repeated_subarray_718;

public class My {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int countMax = 0;
        int count = 0;
        int[] lower = n1 <= n2 ? nums1 : nums2;
        int[] higher = n1 > n2 ? nums1 : nums2;
        while (i < lower.length && lower[i] == higher[i]){
            i++;
            countMax++;
        }

        if (i == n1 || i == n2)
            return countMax;

        return Math.max(Math.max(countMax, helper(0, n1-2, lower, higher, countMax)),
                Math.max(countMax, helper(1, n1-1, lower, higher, countMax)));
    }

    private int helper (int start, int end, int[] lower, int[] higher,
                        int countMax){
        if (start > end)
            return 0;
        int n = lower.length;
        int startCopy = start;
        if (countMax >= n)
            return countMax;

        for (int i = 0; i < higher.length; i++){
            if (lower[start] != higher[i])
                continue;
            int j = i;
            int count = 0;
            while (startCopy <= end && j <= higher.length-1 && lower[startCopy] == higher[j]){
                count++;
                startCopy++;
                j++;
            }
            startCopy = start;
            countMax = Math.max(count,countMax);
        }

        return Math.max(Math.max(countMax, helper(start, end-1, lower, higher, countMax)),
                Math.max(countMax, helper(start+1,end,lower,higher,countMax)));
    }
}


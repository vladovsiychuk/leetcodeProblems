package merge_sorted_array_88;

import java.util.Arrays;

public class My {
    public String result(int[] nums1, int n, int[] nums2, int m){

        for (int i = nums1.length-1, k = 0; i >= nums1.length-1+n; i--,k++) {
            nums1[i] = nums2[k];
        }

        Arrays.sort(nums1);

        return "ok";
    }
}


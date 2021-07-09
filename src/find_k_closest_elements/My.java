package find_k_closest_elements;

import java.util.*;

public class My {
    public List<Integer> result(int[] arr, int x, int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = n - k;

        while (left < right){
            int mid = left + (right - left)/2;
            if (Math.abs(arr[mid]-x) <= Math.abs(arr[mid+k]-x))
                right = mid;
            else
                left = mid + 1;
        }

        for (int i = left; i < left + k; i++)
            result.add(arr[i]);
        return result;
    }
}


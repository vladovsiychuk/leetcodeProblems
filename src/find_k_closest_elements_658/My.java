package find_k_closest_elements_658;

import java.util.*;

public class My {
    public List<Integer> result(int[] arr, int x, int k) {
        int n = arr.length; //
        int left = 0; // 0
        int right = n-k; // 0
        List<Integer> result = new ArrayList<>();

        while (left < right) {
            int mid = left + (right-left)/2; // 0

            //abs(3-1) < abs(3-1) == 2 < 2

            if (Math.abs(x-arr[mid]) < Math.abs(x-arr[mid+k])){ //
                right = mid;
            } else if (Math.abs(x-arr[mid]) == Math.abs(x-arr[mid+k]) //
                    && arr[mid] < arr[mid+k])
                right = mid;
            else
                left = mid+1;
        }

        for (int i = left; i < left+k && i <= n-1; i++)
            result.add(arr[i]);

        return result;
    }
}


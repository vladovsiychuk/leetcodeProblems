package find_k_closest_elements;

import java.util.*;

public class My {
    public List<Integer> result(int[] arr, int x, int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = n-1;

        while (left < right){
            int mid = left + (right - left)/2;
            if (arr[mid] == x){
                left = mid;
                break;
            }
            if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }
        if (left != 0 && Math.abs(arr[left-1]-x) <= Math.abs(arr[left]-x))
            left = left - 1;
        result.add(arr[left]);
        k--;
        right = left+1;
        left = left-1;

        while (k > 0){
            if (left < 0)
                result.add(arr[right++]);
            else if (right > n-1)
                result.add(arr[left--]);
            else {
                int comp = Math.abs(x-arr[left]) - Math.abs(x-arr[right]);
                if (comp <= 0)
                    result.add(arr[left--]);
                else
                    result.add(arr[right++]);
            }
            k--;
        }
        Collections.sort(result);
        return result;
    }
}


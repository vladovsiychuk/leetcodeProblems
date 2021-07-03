package find_k_closest_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class My {
    public List<Integer> result(int[] arr, int x, int k){
        int n = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int left = 0;
        int right = n-1;

        while (left < right){
            int mid = left + (right - left)/2;
            if (arr[mid] == k) {
                left = mid;
                break;
            }else if (k < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        if (arr[left] > k && left - 1 >= 0 && Math.abs(arr[left]-k) == Math.abs(arr[left-1]-k) )
            left = left - 1;
        int kIndex = left;
        left = kIndex-1;
        right = kIndex+1;

        if (x > 0){
            queue.add(arr[kIndex]);
            x--;
        }

        while (x > 0){
            int candidate;
            if (left < 0) {
                queue.add(arr[right]);
                right++;
            }else if (right > n-1) {
                queue.add(arr[left]);
                left--;
            } else {
                int comp = Math.abs(arr[left] - k) - Math.abs(arr[right] - k);
                if ((comp == 0 && left < right) || (comp < 0)){
                    queue.add(arr[left]);
                    left--;
                }else if (comp == 0 || comp > 0){
                    queue.add(arr[right]);
                    right++;
                }
            }
            x--;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (!queue.isEmpty())
            result.add(queue.poll());
        return result;
    }
}


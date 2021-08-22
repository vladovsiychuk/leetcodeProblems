package educative.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*SLIDING WINDOW*/
    public static int findMaxSumSubArray(int k, int[] nums) {
        int windowSum = 0;
        int maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            windowSum += nums[windowEnd];

            if (windowEnd >= k - 1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    /*
               s
        [2, 1, 5, 2, 3, 2] s=7
                  e

        windowSum: 7
        minLenght: 2

     */

    public static int findMinSubArray(int s, int[] nums) {
        int minLenght = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++){
            windowSum += nums[end];

            while (windowSum >= s){
                minLenght = Math.min(minLenght, end - start + 1);
                windowSum -= nums[start];
                start++;
            }
        }
        return minLenght == Integer.MAX_VALUE ? 0 : minLenght;
    }






    /* ====== FAST-SLOW POINTERS ====== */


    /*
        1. find a lenght of cycle
        2. find the start using length of cycle
     */

    public static ListNode findCycleStart(ListNode head) {
        int cycleLenght = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                cycleLenght = findCycleLenght(slow);
                break;
            }
        }
        return findStart(head, cycleLenght);
    }

    private static ListNode findStart(ListNode head, int cycleLenght) {
        ListNode pointer1 = head, pointer2 = head;

        while (cycleLenght > 0){
            pointer2 = pointer2.next;
            cycleLenght--;
        }

        while (pointer1 != pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private static int findCycleLenght(ListNode slow) {
        ListNode current = slow.next;
        int length = 1;

        while (slow != current){
            current = current.next;
            length++;
        }

        return length;
    }



    /* ====== MERGE INTERVALS ====== */


    private static List<Interval> insert (List<Interval> intervals, Interval newInterval){
        if (intervals == null || intervals.isEmpty())
            return new ArrayList<>(Arrays.asList(newInterval));

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        //add to output all intervals come before newInterval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        //merge all intervals that overlap
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);

        //add all remaining intervals
        while (i < intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }








    /* ====== CYCLIC SORT ====== */


    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if (nums[j] != nums[i])
                swap(j,i,nums);
            else
                i++;
        }
    }

    private static void swap(int j, int i, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            if (nums[i] < n && nums[i] != i)
                swap(nums[i],i,nums);
            else
                i++;
        }

        for (i = 0; i < n; i++) {
            if (i != nums[i])
                return i;
        }
        return -1;
    }

    /*

        null <- 1 <- 2 <- 3 <- 4

        next: null
        current: 4
        prev: 4

     */

    public static ListNode reverse(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
















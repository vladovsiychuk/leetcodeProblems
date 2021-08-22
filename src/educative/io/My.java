package educative.io;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class My {
    /* ===== SLIDING WINDOWS ===== */

    /*
     s
    [2,1,5,1,3,2] k = 3
         e

     */

    public static int findMaxSumSubArray(int k, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int end = 0; end < n; end++){
            sum += nums[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }

    /*
           s
    [2, 1, 5, 2, 3, 2] s=7
              e

    sum: 3
    minSum: 2

     */

    public static int findMinSubArray(int s, int[] nums) {
        return 0;
    }











    /* ====== TOW POINTERS ====== */

    /*
        s
    [1, 2, 3, 4, 6] target: 6
              e
    sum 5
     */

    public static int[] search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int sum = 0;

        while(start < end){
            sum = nums[start] + nums[end];
            if (sum == target){
                return new int[]{nums[start],nums[end]};
            }else if (sum > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{};
    }

    /*
                        s
        [2, 3, 6, 9, 6, 9, 9]
                           e
                     i
        n: 4
     */

    public static int remove(int[] nums) {
        int n = nums.length;
        int index = 1;

        for (int end = 1, start = 0; end < nums.length; end++, start++){
            if (nums[start] == nums[end])
                n--;
            else {
                nums[index] = nums[end];
                index++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return n;
    }

    /*
    [3, 2, 3, 6, 3, 10, 9, 3]

        s
    [2, 2, 3, 6, 3, 10, 9, 3]    key = 3
           e

     n: 7

     */

    public static int removeUnsorted(int[] nums, int key) {
        int n = nums.length;//7
        for (int end = 0, start = 0; end < nums.length; end++){//start: 1 end:1
            if (nums[end] == key){
                n--;
            }else{
                nums[start] = nums[end];
                start++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n;
    }






    /* ====== FAST-SLOW POINTERS ====== */

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null){
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        return false;
    }

    /*

    1 -> 2 -> 3 -> 4
        ^          |
        |          v
        7 <- 6 <-  5

        slow:4
        fast:7

        length:7

        1 -> 2
          \  |
             v
            3

            slow: 2
            fast: 3

            count:2

     */

    public static int cycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;

        while (fast.next != null){
            count++;

            if (fast.next.next == null || fast.next.next == slow)
                return count;
            else{
                count++;
                fast = fast.next.next;
                slow = slow.next;
            }

        }
        return count;
    }

    /*

        1 -> 2 -> 3
             ^    |
             |    v
             5 <- 4

         pointer: 1
         set: 1

     */

    public static ListNode findCycleStart(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode pointer = head;

        while (true){
            set.add(pointer);
            if (set.contains(pointer.next))
                return pointer.next;
            pointer = pointer.next;
        }
    }

    /*

        1 - - 4
          2 - - 5
                  6-7
                         10 - 19


        not overlap when: currStart > prevEnd
                       || currEnd < prevStart

        prevStart: 1 prevEnd: 5
        currStart: 7 currEnd: 9

        result: [[1,5],[6,7]]
     */








    /* ====== MERGE INTERVALS ====== */



    public static List<Interval> merge(List<Interval> input) {
        Collections.sort(input);

        int prevStart = input.get(0).start; //1
        int prevEnd = input.get(0).end; //5
        List<Interval> result = new ArrayList<>();//[[1,5],[6,7]]

        for (int i = 1; i < input.size(); i++){ //i:2
            int currStart = input.get(i).start; //6
            int currEnd = input.get(i).end; //7

            if (currStart > prevEnd || currEnd < prevStart){
                //if not overlap
                if(result.size() == 0)
                    result.add(new Interval(prevStart,prevEnd));
                result.add(new Interval(currStart,currEnd));
            }
            prevStart = Math.min(prevStart, currStart);
            prevEnd = Math.max(prevEnd, currEnd);
        }

        if (result.size() == 0)
            result.add(new Interval(prevStart,prevEnd));

        return result;
    }

    public static boolean anyTwoOverlap(int[][] intervals) {
        List<Interval> sortedIntervals = new ArrayList<>();
        for (int[] i : intervals)
            sortedIntervals.add(new Interval(i[0],i[1]));

        Collections.sort(sortedIntervals);
        Iterator<Interval> sortedIntervalsItr = sortedIntervals.iterator();
        Interval interval = sortedIntervalsItr.next();
        int start = interval.start;
        int end = interval.end;

        while (sortedIntervalsItr.hasNext()){
            Interval current = sortedIntervalsItr.next();
            if (current.start > end || current.end < start){ //if not overlap
                end = Math.max(end, current.end);
                continue;
            }else{
                return true;
            }
        }
        return false;
    }

    /*

        1 - 3
                5 - 7
                       8 - - - 12

         insert: 4 - 10
         expected: 1-3,4-12

         currentStart:
         currentEnd:
         newStart:
         newEnd:
         newProcessed:
         result: [[]]

     */

    public static List<Interval> insert(List<Interval> input, Interval newInterval) {

        List<Interval> result = new ArrayList<>(); //[[8,12],]
        Iterator<Interval> iterator = input.iterator();
        int newStart = newInterval.start; // 4
        int newEnd = newInterval.end; // 12
        boolean newProcessed = false; //false

        while(iterator.hasNext()){
            Interval current = iterator.next();//[5,7]
            if (newStart > current.end || newEnd < current.start){ //if not overlap
                if (!newProcessed && newEnd < current.start) {
                    result.add(new Interval(newStart, newEnd));
                    newProcessed = true;
                }
                result.add(current);
            }else{
                newStart = Math.min(newStart, current.start);
                newEnd = Math.max(newEnd, current.end);
            }
        }

        if (!newProcessed)
            result.add(new Interval(newStart, newEnd));

        return result;
    }

    /*
        [4,0,3,1]

               i
        [0,1,4,3]
        [ , , , ]

     */

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            if (nums[i] != i){
                if (nums[i] != n && i != n)
                    swap(nums[i],i,nums);
                else
                    swap(nums[i],n-1,nums);
            }else{
                i++;
            }
        }

        for (i = 0; i < n; i++){
            if (i != nums[i])
                return i;
        }
        return -1;
    }

    private static void swap(int j, int i, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = nums[j];
    }

    /*

        head: 1
        p: 2
        q: 4

        1 -> 2 <- 3 <- 4  5
             |
             v
            null

        prevReverse:1
        nextReverse:5
        i:4
        current:4
        next:5
        prev:3

     */

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode current = head;
        ListNode headReverse = null;
        ListNode tailReverse = null;
        ListNode prevReverse = null;
        ListNode nextReverse = null;
        int i = 1;

        while (i <= q && current != null){
            if (i == p-1) {
                prevReverse = current;
            }else if (i == p)
                headReverse = current;
            else if (i == q) {
                nextReverse = current.next;
                current.next = null;
            }
            i++;
            current = current.next;
        }

        headReverse = reverse(headReverse);
        if (prevReverse != null)
            prevReverse.next = headReverse;
        else
            head = headReverse;

        current = headReverse;

        while(current != null){
            if (current.next == null)
                tailReverse = current;
            current = current.next;
        }

        tailReverse.next = nextReverse;

        return head;
    }

    private static ListNode reverse(ListNode head) {
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




    /* ====== TREE BFS ====== */

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null)
                    newQueue.add(current.left);
                if (current.right != null)
                    newQueue.add(current.right);
            }
            result.add(list);
            queue = newQueue;
        }
        return result;
    }



    public static List<List<Integer>> traverseReverse(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new ArrayDeque<>();

            while(!queue.isEmpty()){
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null)
                    newQueue.add(current.left);
                if (current.right != null)
                    newQueue.add(current.right);
            }

            queue = newQueue;
            result.addFirst(list);
        }
        return result;
    }






    /* ====== TREE DFS ====== */

    //NOT Solved, not works with input [1,2] 1
//    Given a binary tree and a number ‘S’,
//    find if the tree has a path from root-to-leaf
//    such that the sum of all the node values of that path equals ‘S’.

    public static boolean hasPath(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private static boolean dfs(TreeNode root, int pathSum, int sum) {
        if (root == null)
            return pathSum == sum;

        pathSum += root.val;
        return dfs(root.left, pathSum, sum) || dfs(root.right, pathSum, sum);

    }

    /*

        - start from the root
        - add value of node in the end of a LinkedList
        - process left node passing a LinkedList and path sum
        - remove the last value of linkedList,
        - process right node passing a LinkedList and path sum
        - if in dfs root == null
            - check if path sum is equal to sum
                   - add to list result if so

     */

    public static List<List<Integer>> findPath(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, sum, result, new LinkedList<Integer>());
        return result;
    }

    private static void dfs(TreeNode node, int pathSum, int sum, List<List<Integer>> result,
                            LinkedList<Integer> pathList) {
        if (node == null){
            pathList.add(1);
            return;
        }

        pathList.add(node.val);

        if (pathSum + node.val == sum) {
            result.add(new LinkedList<>(pathList));
            return;
        }

        dfs(node.left, pathSum + node.val, sum, result, pathList);
        pathList.removeLast();
        dfs(node.right, pathSum + node.val, sum, result, pathList);
        pathList.removeLast();
    }
}





































































package educative.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        /* ====== SLINDING WINDOWS  ====== */

//        System.out.println(My.findMaxSumSubArray(3, new int[]{2,1,5,1,3,2}));
//        System.out.println(Solution.findMaxSumSubArray(3, new int[]{2,1,5,1,3,2}));

//        Given an array of positive numbers and a positive number ‘S’,
//        find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
//        Return 0, if no such subarray exists.
        //NOT solved
//        System.out.println(My.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
//        System.out.println(Solution.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));






        /* ====== TWO POINTERS ====== */

        //        Given an array of sorted numbers and a target sum,
        //        find a pair in the array whose sum is equal to the given target.
//
//        Write a function to return the indices of the two numbers (i.e. the pair)
//        such that they add up to the given target.
        //solved
//        System.out.println(Arrays.toString(My.search(new int[]{1, 2, 3, 4, 6}, 6)));

//        Given an array of sorted numbers, remove all duplicates from it.
//        You should not use any extra space;
//        after removing the duplicates in-place return the new length of the array.

        //solved
//        System.out.println(My.remove(new int[]{2, 3, 3, 3, 6, 9, 9}));

//        Problem 1: Given an unsorted array of numbers and a target ‘key’,
//        remove all instances of ‘key’ in-place and return the new length of the array.
        //solved
//        System.out.println(My.removeUnsorted(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));








        /* ====== FAST-SLOW POINTERS ====== */

        //solved
//        Given the head of a Singly LinkedList,
//        write a function to determine if the LinkedList has a cycle in it or not.

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//
//        System.out.println(My.hasCycle(head));
//
//        head.next.next.next.next.next.next = head.next.next;
//        System.out.println(My.hasCycle(head));


        //solved
//        Given the head of a LinkedList with a cycle, find the length of the cycle.

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = head.next.next;
//        System.out.println(My.cycleLength(head));


        // NOT solved
//        Given the head of a Singly LinkedList that contains a cycle,
//        write a function to find the starting node of the cycle.

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = head.next.next;
//        System.out.println(My.findCycleStart(head).val);
//        System.out.println(Solution.findCycleStart(head).val);



        /* ====== MERGE INTERVALS ====== */

        //solved, but slight different from official solution
//        Given a list of intervals,
//        merge all the overlapping intervals to produce a list that
//        has only mutually exclusive intervals.

//        List<Interval> input = new ArrayList<>();
//        input.add(new Interval(1,4));
//        input.add(new Interval(2,5));
//        input.add(new Interval(7,9));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.merge(input)){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expected: 1-5,7-9
//        System.out.println();
//
//        input = new ArrayList<>();
//        input.add(new Interval(6,7));
//        input.add(new Interval(2,4));
//        input.add(new Interval(5,9));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.merge(input)){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expected: 2-4,5-9
//        System.out.println();
//
//
//        input = new ArrayList<>();
//        input.add(new Interval(1,4));
//        input.add(new Interval(2,6));
//        input.add(new Interval(3,5));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.merge(input)){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expect: 1-6
//        System.out.println();
//

        //solved
//        Problem 1:Given a set of intervals, find out if any two intervals overlap.
//        System.out.println(My.anyTwoOverlap(new int[][]{{1,4},{2,5},{7,9}})); //expect: true
//        System.out.println(My.anyTwoOverlap(new int[][]{{1,4},{5,7},{8,9}})); //expect: false


        //solved , but solution is better
//        Given a list of non-overlapping intervals sorted by their start time,
//        insert a given interval at the correct position and merge
//        all necessary intervals to produce a list that has only mutually exclusive intervals.

//        List<Interval> input = new ArrayList<>();
//        input.add(new Interval(1,3));
//        input.add(new Interval(5,7));
//        input.add(new Interval(8,12));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.insert(input, new Interval(4,6))){
////            for (Interval interval : Solution.insert(input, new Interval(4,6))){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expected: 1-3,4-7,8-12
//        System.out.println();
//
//
//        input = new ArrayList<>();
//        input.add(new Interval(1,3));
//        input.add(new Interval(5,7));
//        input.add(new Interval(8,12));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.insert(input, new Interval(4,10))){
////            for (Interval interval : Solution.insert(input, new Interval(4,6))){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expected: 1-3,4-12
//        System.out.println();
//
//        input = new ArrayList<>();
//        input.add(new Interval(2,3));
//        input.add(new Interval(5,7));
//        System.out.println("Merged intervals: ");
//        for (Interval interval : My.insert(input, new Interval(1,4))){
////            for (Interval interval : Solution.insert(input, new Interval(4,6))){
//            System.out.println("[" + interval.start + "," + interval.end + "] ");
//        }
//        //expected:1-4,5-7
//        System.out.println();








        /* ====== CYCLIC SORT ====== */

        //NOT Solved because not understood the probleam
//        We are given an array containing ‘n’ objects. Each object, when created,
//        was assigned a unique number from 1 to ‘n’ based on their creation sequence.
//        This means that the object with sequence number ‘3’
//        was created just before the object with sequence number ‘4’.
//
//        Write a function to sort the objects in-place on their creation sequence number in
//        O(n) and without any extra space.
//        For simplicity, let’s assume we are passed an integer array containing only
//        the sequence numbers, though each number is actually an object.
//        int[] array = new int[]{3, 1, 5, 4, 2};
//        Solution.sort(array);
//        System.out.println(Arrays.toString(array));


        //NOT Solved in optimal way
//        We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
//        Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
//        System.out.println(My.findMissingNumber(new int[]{4, 0, 3, 1}));
//        System.out.println(Solution.findMissingNumber(new int[]{4, 0, 3, 1}));


        /* ====== IN PLACE REVERSAL OF A LINKED LIST ====== */

        //NOT Solved UPD: Solved
//        Given the head of a Singly LinkedList, reverse the LinkedList.
//        Write a function to return the new head of the reversed LinkedList.

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//
//        ListNode result = Solution.reverse(head);
//
//        while (result != null){
//            System.out.println(result.val);
//            result = result.next;
//        }


        //Solved
//        Given the head of a
//        LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
//        ListNode result = My.reverse(head,2,4);
//
//        while (result != null){
//            System.out.println(result.val);
//            result = result.next;
//        }





        /* ====== TREE BFS ====== */

        //Solved
//        Given a binary tree, populate an array to represent its level-by-level traversal.
//        You should populate the values of
//        all nodes of each level from left to right in separate sub-arrays.

//        TreeNode root = new TreeNode (12);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode (1);
//        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
//        List<List<Integer>> result = My.traverse(root);
//        System.out.println(result);



        //Solved
//        Given a binary tree, populate an array to represent its
//        level-by-level traversal in reverse order, i.e., the lowest level comes first.
//        You should populate the values of
//        all nodes in each level from left to right in separate sub-arrays.

//        TreeNode root = new TreeNode (12);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode (1);
//        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
//        List<List<Integer>> result = My.traverseReverse(root);
//        System.out.println(result);







        /* ====== TREE DFS ====== */

//        Given a binary tree and a number ‘S’,
//        find if the tree has a path from root-to-leaf
//        such that the sum of all the node values of that path equals ‘S’.
        /*

                12
              /    \
             7      1
           /  \      \
          9    10     5

         */

//        TreeNode root = new TreeNode (12);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode (1);
//        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
//        System.out.println(My.hasPath(root, 18));



        //Solved, but not well
//        Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the
//        sum of all the node values of each path equals ‘S’.

        /*

                 12
               /    \
              1      7
             / \     /
            10  5    4


         */

        TreeNode root = new TreeNode (12);
        root.left = new TreeNode(1);
        root.right = new TreeNode (7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        System.out.println(My.findPath(root, 23));


    }
}




































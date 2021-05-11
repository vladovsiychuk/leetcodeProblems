package merge_two_sorted_lists_21;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static ListNode result(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode tail = head;


        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        return head.next;
    }
}




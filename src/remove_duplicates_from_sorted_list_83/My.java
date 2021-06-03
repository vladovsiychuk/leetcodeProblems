package remove_duplicates_from_sorted_list_83;

import java.util.List;

public class My {
    public static ListNode result(ListNode head){

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode res = new ListNode();
        ListNode slow = head;
        ListNode fast = head.next;
        res.next = slow;
        slow.next = null;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
                slow.next = null;
            }else
                fast = fast.next;
        }

        return res.next;
    }
}


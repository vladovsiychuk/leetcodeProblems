package remove_duplicates_from_sorted_list_83;

import java.util.List;

public class My {
    public static ListNode result(ListNode head){

        if(head == null) return null;
        else if (head.next == null) return head;

        ListNode res = new ListNode();


        
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tail = res;
        tail.next = slow;
        tail = tail.next;

        while(fast != null){
            if (slow.val != fast.val){
                slow = fast;
                fast = fast.next;
                tail.next = slow;
                tail = tail.next;
            }
            if(fast != null && fast.next != null)
                fast = fast.next;
            else
                fast = null;
        }

        return res.next;
    }
}


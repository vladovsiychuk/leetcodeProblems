package middle_of_the_linked_list_876;

public class My {
    public static ListNode result(ListNode head){


        if(head == null) return null;
        else if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == null)
                return slow;
        }

        return slow.next;
    }
}


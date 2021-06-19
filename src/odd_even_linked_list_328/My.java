package odd_even_linked_list_328;

public class My {
    public ListNode result(ListNode head){
        ListNode head_odd = new ListNode();
        ListNode head_even = new ListNode();
        ListNode odd = head_odd;
        ListNode even = head_even;
        boolean oddNum = true;

        while (head != null) {
            if (oddNum) {
                odd.next = head;
                odd = odd.next;
                oddNum = false;
            } else {
                even.next = head;
                even = even.next;
                oddNum = true;
            }
            head = head.next;
        }
        even.next = null;
        odd.next = head_even.next;
        return head_odd.next;
    }
}


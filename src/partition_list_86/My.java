package partition_list_86;

public class My {
    public ListNode result(ListNode head, int x){
        ListNode head_before = new ListNode();
        ListNode before = head_before;
        ListNode head_after = new ListNode();
        ListNode after = head_after;

        while (head != null){
            if (head.val < x){
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = head_after.next;
        return head_before.next;
    }
}


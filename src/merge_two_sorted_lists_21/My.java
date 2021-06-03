package merge_two_sorted_lists_21;

public class My {
    public static ListNode result(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;

        ListNode res = new ListNode();
        ListNode tail = new ListNode();
        tail = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else if (l1.val == l2.val){
                tail.next = l2;
                l2 = l2.next;
                tail.next.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }

            if (l1 == null && l2 != null)
                tail.next = l2;
            else if (l2 == null && l1 != null)
                tail.next = l1;
        }

        return res.next;
    }
}


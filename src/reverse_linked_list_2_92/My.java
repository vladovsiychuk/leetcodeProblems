package reverse_linked_list_2_92;


public class My {
    public static ListNode reverse(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode headReverse = null;
        ListNode tailReverse = null;
        ListNode prevReverse = null;
        ListNode nextReverse = null;
        int i = 1;

        while (i <= right && current != null){
            if (i == left-1) {
                prevReverse = current;
            }else if (i == left)
                headReverse = current;

            if (i == right) {
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
}


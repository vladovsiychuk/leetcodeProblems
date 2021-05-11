package reverse_linked_list_206;

public class My {
    private static ListNode res = new ListNode(-5002);

    public static ListNode result(ListNode head){

        if(head == null)
            return null;

        function(head);

        return res;
    }

    private static void function(ListNode head) {

        if(head.next != null)
            function(head.next);

        if(res.val < -5001)
            res.val = head.val;
        else
            res.next = new ListNode(head.val);
    }
}


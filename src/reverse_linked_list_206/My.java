package reverse_linked_list_206;

import java.util.Stack;

public class My {
    public static ListNode result(ListNode head){

            if (head == null) return null;
            if (head.next == null) return head;

            Stack<Integer> stack = new Stack<>();
            ListNode res = new ListNode();
            ListNode tail = new ListNode();
            tail = res;

            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            while (stack.size() > 0) {
                ListNode tmp = new ListNode(stack.pop());
                tail.next = tmp;
                tail = tail.next;
            }

            return res.next;
    }
}


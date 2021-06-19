package odd_even_linked_list_328;

public class Main {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(4);

        System.out.println(new My().result(head));
//        System.out.println(new Solution().result());
    }
}

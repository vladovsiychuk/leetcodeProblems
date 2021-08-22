package reverse_linked_list_2_92;


public class Main {
    public static void main(String args[]) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = My.reverse(head,2,4);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

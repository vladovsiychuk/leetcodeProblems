package partition_list_86;

public class Main {
    public static void main(String args[]) {
        System.out.println(new My().result(new ListNode(1,
                new ListNode(4,
                new ListNode(3,
                new ListNode(2,
                new ListNode(5,
                new ListNode(2)))))),3));
//        System.out.println(new Solution().result());
    }
}

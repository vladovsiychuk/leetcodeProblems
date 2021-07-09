package lre_iterator_900;

public class Main {
    public static void main(String args[]) {
        My my = new My(new int[]{3,8,0,9,2,5});
        System.out.println(my.next(2));
        System.out.println(my.next(1));
        System.out.println(my.next(1));
        System.out.println(my.next(2));
//        System.out.println(new Solution().result());
    }
}

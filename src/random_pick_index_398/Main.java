package random_pick_index_398;

public class Main {
    public static void main(String args[]) {
//        System.out.println(new My().result());
//        System.out.println(new Solution().result());
//        System.out.println(new Solution().reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));

        My test = new My(new int[]{1, 2, 3, 3, 3});
        System.out.println(test.pick(3));
        System.out.println(test.pick(1));
        System.out.println(test.pick(3));
    }
}

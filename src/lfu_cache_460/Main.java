package lfu_cache_460;

public class Main {
    public static void main(String args[]) {
//        System.out.println(new My().result());
//        System.out.println(new Solution().result());

        //["LFUCache","set","set","get","set","get","get","set","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

        Solution test = new Solution(10);
        test.set(10,13);
        test.set(3,17);
        test.set(6,11);
        test.set(10,5);
        test.set(9,10);
        System.out.println(test.get(13));
        test.set(2,19);
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        test.set(5,25);
        System.out.println(test.get(8));
        test.set(9,22);
        test.set(5,5);
        test.set(1,30);
        System.out.println(test.get(11));
        test.set(9,12);
        System.out.println(test.get(7));
        System.out.println(test.get(5));
        System.out.println(test.get(8));
        System.out.println(test.get(9));
        test.set(4,30);
        test.set(9,3);
        System.out.println(test.get(9));
        System.out.println(test.get(10));
        System.out.println(test.get(10));
        test.set(6,14);
        test.set(3,1);
        System.out.println(test.get(3));
        test.set(10,11);
        System.out.println(test.get(8));
        test.set(2,14);
        System.out.println(test.get(1));
        System.out.println(test.get(5));
        System.out.println(test.get(4));
        test.set(11,4);
        test.set(12,24);
        test.set(5,18);
        System.out.println(test.get(13));
        test.set(7,23);
        System.out.println(test.get(8));
        System.out.println(test.get(12));
        test.set(3,27);
        test.set(2,12);
        System.out.println(test.get(5));
        test.set(2,9);
        test.set(13,4);
        test.set(8,18);
        test.set(1,7);
        System.out.println(test.get(6));
//        test.set(9,29);
//        test.set(8,21);
//        System.out.println(test.get(5));
//        test.set(6,30);
//        test.set(1,12);
//        System.out.println(test.get(10));
//        test.set(4,15);
//        test.set(7,22);
//        test.set(11,26);
//        test.set(8,17);
//        test.set(9,29);
//        System.out.println(test.get(5));
//        test.set(3,4);
//        test.set(11,30);
//        System.out.println(test.get(12));
//        test.set(4,29);
//        System.out.println(test.get(3));
//        System.out.println(test.get(9));
//        System.out.println(test.get(6));
//        test.set(3,4);
//        System.out.println(test.get(1));
//        System.out.println(test.get(10));
//        test.set(3,29);
//        test.set(10,28);
//        test.set(1,20);
//        test.set(11,13);
//        System.out.println(test.get(3));
//        test.set(3,12);
//        test.set(3,8);
//        test.set(10,9);
//        test.set(3,26);
//        System.out.println(test.get(8));
//        System.out.println(test.get(7));
//        System.out.println(test.get(5));
//        test.set(13,17);
//        test.set(2,27);
//        test.set(11,15);
//        System.out.println(test.get(12));
//        test.set(9,19);
//        test.set(2,15);
//        test.set(3,16);
//        System.out.println(test.get(1));
//        test.set(12,17);
//        test.set(9,1);
//        test.set(6,19);
//        System.out.println(test.get(4));
//        System.out.println(test.get(5));
//        System.out.println(test.get(5));
//        test.set(8,1);
//        test.set(11,7);
//        test.set(5,2);
//        test.set(9,28);
//        System.out.println(test.get(1));
//        test.set(2,2);
//        test.set(7,4);
//        test.set(4,22);
//        test.set(7,24);
//        test.set(9,26);
//        test.set(13,28);
//        test.set(11,26);

    }
}
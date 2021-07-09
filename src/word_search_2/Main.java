package word_search_2;

public class Main {
    public static void main(String args[]) {
        System.out.println(new My().result(new char[][]{{'a','b','c'},
                                                        {'a','e','d'},
                                                        {'a','f','g'}} ,
                                        new String[]{"eaafgdcba","eaabcdgfa"}));


//        System.out.println(new Solution().result());
    }
}

package max_sum_of_rectangle_no_longer_than_k;

public class Main {
    public static void main(String args[]) {
        System.out.println(new My().result(new int[][]{{ 5,-4,-3, 4},
                                                        {-3,-4, 4, 5},
                                                        { 5, 1, 5,-4}}
                                                        , 10));
//        System.out.println(new Solution().maxSumSubmatrix(new int[][]{  { 5,-4,-3, 4},
//                                                                        {-3,-4, 4, 5},
//                                                                        { 5, 1, 5,-4}}
//                                                                        , 10));
    }
}

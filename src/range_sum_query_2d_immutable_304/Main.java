package range_sum_query_2d_immutable_304;

public class Main {
    public static void main(String args[]) {
        NumMatrix obj = new NumMatrix(new int[][]{{2,3},{3,4}});
        int param_1 = obj.sumRegion(0,0,1,1);

        System.out.println(param_1);
//        System.out.println(new Solution().result());
    }
}

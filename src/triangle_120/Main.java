package triangle_120;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(2);
        tmp.add(3);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(8);
        tmp.add(5);
        tmp.add(10);
        triangle.add(tmp);

        System.out.println(new My().result(triangle));
//        System.out.println(new Solution().result());
    }
}

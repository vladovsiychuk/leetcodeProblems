package keys_and_rooms_841;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        room1.add(1);
        rooms.add(room1);
        rooms.add(room2);

        System.out.println(new My().result(rooms));
//        System.out.println(new Solution().result());
    }
}

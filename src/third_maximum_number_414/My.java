package third_maximum_number_414;

import java.util.HashMap;

public class My {

    public static int result(int nums[]) {

        HashMap<Integer,Integer> topThree = new HashMap<Integer, Integer>();
        topThree.put(1,null);
        topThree.put(2, null);
        topThree.put(3, null);

        for(int i = 0; i < nums.length; i++){
            if (topThree.get(1) == null || nums[i] > topThree.get(1)) {
                topThree = setFirst(nums[i], topThree);
            } else if (nums[i] != topThree.get(1)
                    && (nums[i] > topThree.get(2))){
                topThree = setSecond(nums[i], topThree);
            } else if ((nums[i] != topThree.get(1) && nums[i] != topThree.get(2))
                    && (topThree.get(3) == null ||
                            nums[i] > topThree.get(3))){
                topThree = setThird(nums[i], topThree);
            }
        }

        if(topThree.get(3) == null) {
            return topThree.get(1);
        }

        return topThree.get(3);
    }

    private static HashMap<Integer, Integer> setThird(int num, HashMap<Integer, Integer> topThree) {
        topThree.put(3,num);
        return topThree;
    }

    private static HashMap<Integer, Integer> setSecond(int num, HashMap<Integer, Integer> topThree) {
        topThree.put(3,topThree.get(2));
        topThree.put(2,num);

        return topThree;
    }

    private static HashMap<Integer, Integer> setFirst(int num, HashMap<Integer, Integer> topThree) {
        topThree.put(3, topThree.get(2));
        topThree.put(2, topThree.get(1));
        topThree.put(1, num);

        return topThree;
    }
}

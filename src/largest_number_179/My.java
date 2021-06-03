package largest_number_179;

import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.*;

public class My {
    public String result(int[] nums){
        List<String> numsList = new ArrayList<>();

        for (int num : nums)
            numsList.add(Integer.toString(num));

        Collections.sort(numsList, new LargestNumberComparator());

        if (numsList.get(0).equals("0"))
            return "0";

        StringBuilder largestNum = new StringBuilder();
        for (String num : numsList)
            largestNum.append(num);


        return largestNum.toString();
    }

    private class LargestNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    }
}


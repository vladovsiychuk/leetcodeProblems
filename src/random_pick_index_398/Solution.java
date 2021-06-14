package random_pick_index_398;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        List<String> tmp = new ArrayList<>();
        for (String string : logs)
            tmp.add(string);

        Collections.sort(tmp, new myComparator());

        for (int i = 0; i < tmp.size(); i++)
            result[i] = tmp.get(i);

        return result;
    }

    private class myComparator implements Comparator<String> {
        @Override
        public int compare (String a, String b) {
            String[] contentA = a.split("\\s", 2);
            String[] contentB = b.split("\\s", 2);
            contentA[1] = contentA[1].replaceAll("\\s", "");
            contentB[1] = contentB[1].replaceAll("\\s", "");


            //The letter-logs come before all digit-logs.
            if(Character.isLetter(contentA[1].charAt(0))
                    && !Character.isLetter(contentB[1].charAt(0)))
                return -1;

            int compare = contentA[1].compareTo(contentB[1]);
            if (compare != 0)
                return compare;

            return contentB[0].compareTo(contentA[0]);
        }
    }
}


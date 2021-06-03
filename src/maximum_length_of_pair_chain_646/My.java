package maximum_length_of_pair_chain_646;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class My {
    public int result(int [][] pairs) {
        List<Pair> pairsList = new ArrayList<>();
        int count = 0;
        int current = Integer.MIN_VALUE;

        for (int[] pair : pairs)
            pairsList.add(new Pair(pair[0],pair[0]));

        Collections.sort(pairsList);

        for (Pair pair: pairsList){
            if (current < pair.last){
                current = pair.last;
                count++;
            }
        }

        return count;
    }

    private class Pair implements Comparable<Pair> {
        int first;
        int last;

        Pair (int first, int last){
            this.first = first;
            this.last = last;
        }

        @Override
        public int compareTo(Pair other) {
            return this.last - other.last;
        }
    }
}


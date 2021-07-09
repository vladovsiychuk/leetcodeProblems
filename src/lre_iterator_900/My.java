package lre_iterator_900;

import java.util.ArrayList;
import java.util.List;

class My {
    List<Integer> counts = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    public My(int[] encoding) {
        int count = 0;
        for (int i = 0; i < encoding.length; i++){

            if (i%2 == 0)
                count = encoding[i];
            else{
                if (count == 0) continue;
                counts.add(count);
                values.add(encoding[i]);
                count = 0;
            }
        }
    }

    public int next(int n) {

        while (!counts.isEmpty()){
            if (n > counts.get(0)){
                n -= counts.get(0);
                counts.remove(0);
                values.remove(0);
            } else {
                int rest = counts.get(0) - n;
                int result = values.get(0);
                if (rest == 0){
                    counts.remove(0);
                    values.remove(0);
                    return result;
                }
                counts.remove(0);
                counts.add(0,rest);
                return result;
            }
        }
        return -1;
    }
}


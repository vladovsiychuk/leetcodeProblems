package plus_one_66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {

    public static int[] result(int[] digits) {

        List result = new ArrayList<Integer>();
        boolean incrementOther = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if(incrementOther == true) {
                if (digits[i] == 9){
                    result.add(0,0);
                    incrementOther = true;
                }else {
                    result.add(0, digits[i] + 1);
                    incrementOther = false;
                }
            }else{
                result.add(0,digits[i]);
            }
        }

        if (incrementOther == true)
            result.add(0,1);

        int[] array = new int[result.size()];

        for(int i=0; i < result.size(); i++) {
            array[i] = (int) result.get(i);
        }

        return array;
    }
}

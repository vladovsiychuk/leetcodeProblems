package missing_number_268;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class My {
    public static int result(int nums[]){

        int n = nums.length;
        HashSet<Integer> allNums = new HashSet<>();

        for(int i = 0; i<n+1; i++){
            allNums.add(i);
        }

        for(int num: nums){
            allNums.remove(num);
        }

        for(int num: allNums){
            return num;
        }

        return -1;
    }
}


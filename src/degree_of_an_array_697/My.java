package degree_of_an_array_697;

import java.util.HashMap;

public class My {
    public static int result(int nums[]){


        int recordCounts = 0;
        int recordKey = -1;
        int res = 0;
        boolean start = false;
        HashMap<Integer,Integer> tmp = new HashMap<Integer, Integer>();
        for(Integer num: nums){
            if(!tmp.containsKey(num)) {
                tmp.put(num, 1);
                if(recordCounts == 0){
                    recordCounts = 1;
                    recordKey = num;
                }
            }else {
                tmp.put(num,tmp.get(num) + 1);
                if(tmp.get(num) > recordCounts){
                    recordCounts = tmp.get(num);
                    recordKey = num;
                }
            }
        }

        for(Integer num: nums){
            if(num == recordKey){
                start = true;
                recordCounts--;
            }
            if (start)
                res++;
            if (recordCounts == 0)
                return res;
        }

        return -1;
    }
}


package group_anagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          HashMap<String, List<String>> map=new HashMap<>();

        for(String str:strs)
        {
            char [] arr=str.toCharArray();
            Arrays.sort(arr);
            String temp=String.valueOf(arr);
            if(!map.containsKey(temp))
                map.put(temp,new ArrayList<String>());
            map.get(temp).add(str);


        }

       return new ArrayList<List<String>>(map.values());
    }
}


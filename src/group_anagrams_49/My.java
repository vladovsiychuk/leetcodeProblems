package group_anagrams_49;

import java.util.*;

public class My {
    public List<List<String>> result(String[] strs){
        HashMap<List<Character>, List<String>> groupsHashMap = new HashMap<>();
        List<List<String>> groups = new ArrayList<>();

        for (String string : strs) {
            List<Character> key = new ArrayList<>();

            for (int i = 0; i < string.length(); i++)
                key.add(string.charAt(i));

            Collections.sort(key);

            if (!groupsHashMap.containsKey(key))
                groupsHashMap.put(key, new ArrayList<String>());

            groupsHashMap.get(key).add(string);
        }

        for (List<Character> key : groupsHashMap.keySet())
            groups.add(groupsHashMap.get(key));

        return groups;
    }
}


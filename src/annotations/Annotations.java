package annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Annotations {
    public String result(){
        //string -> char[]
        char[] a = "string".toCharArray();
        //char[] -> String
        String b = new char[]{'t','e','s','t'}.toString();
        //String[] -> List<String>
        List<String> strings = Arrays.asList(new String[]{"one", "two", "three"});
        //"1" -> 1
        int n = Integer.valueOf("1");

        //int[] -> List<Integer>
        int[] arr = { 1, 2, 3, 4, 5 };
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i: arr)
            list.add(i);

        //List<String> -> String[]
        List<String> tmp2 = new ArrayList<>();
        tmp2.add("one"); tmp2.add("two"); tmp2.add("three");
        String[] d = new String[tmp2.size()];
        tmp2.toArray(d);

        return "ok";
    }
}


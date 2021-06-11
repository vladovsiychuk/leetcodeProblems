package reverse_string_344;

public class My {
    public String result(char[] s){
        int left = 0;
        int right = s[s.length - 1];

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

        return "done";
    }
}


package fizz_buzz_412;

import java.util.ArrayList;
import java.util.List;

public class My {
    public List<String> result(int n){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String tmp = "";
            if ((i + 1)%5 == 0 && (i+1)%3 == 0)
                tmp = "FizzBuzz";
            else if ((i+1)%3 == 0)
                tmp = "Fizz";
            else if ((i+1)%5 == 0)
                tmp = "Buzz";
            else
                tmp = Integer.toString(i + 1);
            result.add(tmp);
        }
        return result;
    }
}


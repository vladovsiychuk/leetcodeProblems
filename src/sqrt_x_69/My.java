package sqrt_x_69;

public class My {
    public int result(int x){
        int res = 0;
        int prevRes = 0;

        for (int i = 0; i <= x/2; i++) {
            prevRes = res;
            res = i * i;
            if (res > x)
                return prevRes;
            if (res == x)
                return res;
        }

        return prevRes;
    }
}


package fibonacci;

public class My {
    public static int result(int i){
        if (i == 0) return 0;
        if (i == 1) return 1;
        return result(i - 1) + result(i - 2);
    }
}


package plus_one_66;

public class My {

    private static int[] tmp;

    public static int[] result(int[] digits) {

        tmp = digits;

        if(tmp[tmp.length - 1] == 9) {
            tmp[tmp.length - 1] = 0;
            incrementPreviouse(tmp.length - 2);
        }else
            tmp[tmp.length - 1] = tmp[tmp.length - 1] + 1;

        return tmp;
    }

    private static void incrementPreviouse(int index) {
        if(tmp[index] == 9){
            tmp[index] = 0;
            incrementPreviouse(index - 1);
        }

        tmp[index] = tmp[index]++;
    }
}

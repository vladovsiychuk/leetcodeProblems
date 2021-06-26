package longest_turbolent_subarray_978;

public class My {
    public int result(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            int countGreater = isGreaterThanNext(i,arr);
            int countLower = isLowerThanNext(i,arr);
            if (countGreater > count)
                count = countGreater;
            if (countLower > count)
                count = countLower;
        }
        return count;
    }

    private int isGreaterThanNext(int i, int[] arr) {
        if (i == arr.length-1)
            return 1;
        if (arr[i] <= arr[i+1])
            return 1;

        return 1 + isLowerThanNext(i+1,arr);
    }

    private int isLowerThanNext(int i, int[] arr) {
        if (i == arr.length-1)
            return 1;
        if (arr[i] >= arr[i+1])
            return 0;

        return 1 + isGreaterThanNext(i+1,arr);
    }
}


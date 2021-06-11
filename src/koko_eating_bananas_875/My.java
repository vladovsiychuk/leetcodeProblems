package koko_eating_bananas_875;

public class My {
    public int result(int[] piles, int h){
        int left = 1;
        int right = Integer.MAX_VALUE;
        int res = 0;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (isValid(mid, piles, h)){
                res = mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }

        return res;
    }

    private boolean isValid(int mid, int[] piles, int h) {
        int count = 0;
        for (int i = 0; i < piles.length; i++){
            count += piles[i]/mid;
            if (piles[i]%mid != 0)
                count++;

            if (count > h)
                return false;
        }

        return true;
    }
}


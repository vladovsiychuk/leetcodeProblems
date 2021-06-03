package guess_number_higher_or_lower_374;

public class My {
    public int result(int n){
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    private int guess(int mid) {
        if (mid < 2) return 1;
        if (mid > 2) return -1;
        return 0;
    }
}


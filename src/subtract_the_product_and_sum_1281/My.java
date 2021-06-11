package subtract_the_product_and_sum_1281;

public class My {
    public int result(int n){
        int product = 1;
        int sum = 0;

        while (n > 0) {
            product *= n%10;
            sum += n%10;
            n /= 10;
        }
        return product - sum;
    }
}


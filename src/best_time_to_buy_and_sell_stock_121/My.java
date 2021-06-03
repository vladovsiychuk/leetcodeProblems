package best_time_to_buy_and_sell_stock_121;

public class My {
    public int result(int[] prices){

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int n: prices){
            min = Math.min(min, n);
            profit = Math.max(profit,n - min);
        }

        return profit;
    }
}


package classes.problems.arrays.greedy;

public class BuyAndSellStock {

    public static void main(String[] args) {

    }

    static int buyAndSell(int[] prices){
        int minVal = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices){
            if(price < minVal){
                minVal = price;
            }else{
                profit = Math.max(profit, price - minVal);
            }
        }
        return profit;
    }
}

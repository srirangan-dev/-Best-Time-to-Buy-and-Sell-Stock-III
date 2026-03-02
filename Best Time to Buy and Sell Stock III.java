class Solution {
    public int maxProfit(int[] prices) {

        int min1 = Integer.MAX_VALUE;
        int profit1 = 0;

        int min2 = Integer.MAX_VALUE;
        int profit2 = 0;

        for (int price : prices) {

            min1 = Math.min(min1, price);
            profit1 = Math.max(profit1, price - min1);

            min2 = Math.min(min2, price - profit1);
            profit2 = Math.max(profit2, price - min2);
        }

        return profit2;
    }
}

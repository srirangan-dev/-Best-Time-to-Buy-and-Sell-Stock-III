class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;

        int[] left = new int[n];   // max profit from day 0 → i
        int[] right = new int[n];  // max profit from day i → n-1

        // Step 1: First transaction (left to right)
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        // Step 2: Second transaction (right to left)
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        // Step 3: Combine both profits
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, left[i] + right[i]);
        }

        return result;
    }
}

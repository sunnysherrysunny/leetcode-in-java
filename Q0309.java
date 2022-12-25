public class Q0309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] sell = new int[len];
        int[] buy = new int[len];
        int[] rest = new int[len];
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], rest[i - 1]));
        }
        return Math.max(sell[len - 1], rest[len - 1]);
    }
}

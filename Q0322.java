public class Q0322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] res = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coinIdx = coins.length - 1; coinIdx >= 0; coinIdx--) {
                int currCoin = coins[coinIdx];
                if (currCoin == i) {
                    res[i] = 1;
                }
                if (i - currCoin > 0 && res[i - currCoin] > 0) {
                    if (res[i] == 0) {
                        res[i] = 1 + res[i - currCoin];
                    } else {
                        res[i] = Math.min(res[i], 1 + res[i - currCoin]);
                    }
                }
            }
        }
        if (res[amount] == 0) {
            return -1;
        } else {
            return res[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }
}

package dp;
/**
 * @author : Meredith
 * @date : 2019-10-10 08:39
 * @description :
 */
public class q322_coinChange {

    public int coinChange (int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int cost = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        cost = Math.min(cost, dp[i - coin] + 1);
                    }
                }
            }
            dp[i] = cost;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}

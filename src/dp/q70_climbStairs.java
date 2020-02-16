package dp;
/**
 * @author : Meredith
 * @date : 2019-08-23 00:07
 * @description :
 */
public class q70_climbStairs {

    static public int climbStairs (int n) {

        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main (String[] args) {
        System.out.println(climbStairs(1));
    }

}

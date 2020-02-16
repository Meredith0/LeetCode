package dp;
import java.util.Arrays;

/**
 * @author : Meredith
 * @date : 2019-08-17 00:19
 * @description :一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class q62_uniquePaths {


    static public int uniquePaths(int m, int n){
        int[][] dp=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0||j==0) {
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m -1][n - 1];
    }

    //一行一行向下更新dp[][], 只需要存一维数组
    // dp[i-1][j]+dp[i][j-1] === dp[j]+dp[j-1]
    static public int uniquePaths_optimized (int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
    }

    public static void main (String[] args) {
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths_optimized(7,3));
    }
}

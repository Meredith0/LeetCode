package dp;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-09-05 19:41
 * @description :
 */
public class q120_minimumTotal {

    public static void main (String[] args) {

    }

    public int minimumTotal (List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                int left = j == 0 ? Integer.MAX_VALUE : dp[i-1][j-1];
                int right = j == i ? Integer.MAX_VALUE : dp[i - 1][j];
                dp[i][j] = Math.min(left,right) + triangle.get(i).get(j);

                if (i == triangle.size() - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }

        }

        return min;
    }

}

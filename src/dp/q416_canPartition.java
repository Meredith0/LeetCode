package dp;
/**
 * @author : Meredith
 * @date : 2020-02-17 00:53
 * @description : 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *     <p>
 *     注意:
 *     <p>
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *     示例 1:
 *     <p>
 *     输入: [1, 5, 11, 5]
 *     <p>
 *     输出: true
 *     <p>
 *     解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *      
 *     <p>
 *     示例 2:
 *     <p>
 *     输入: [1, 2, 3, 5]
 *     <p>
 *     输出: false
 *     <p>
 *     解释: 数组不能分割成两个元素和相等的子集.
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q416_canPartition {

    public static void main (String[] args) {
        var s = new q416_canPartition();
        boolean b = s.canPartition_dfs(new int[]{1, 2, 5});
        System.out.println(b);

        System.out.println(s.canPartition_dp(new int[]{1, 2, 5}));
        System.out.println(s.canPartition_dp(new int[]{1, 2, 3, 6}));
    }

    public boolean canPartition_dfs (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        return dfs(nums, nums.length - 1, sum, sum);
    }

    private boolean dfs (int[] nums, int idx, int take, int pass) {
        if (take == 0 || pass == 0) {
            return true;
        }
        if (take < 0 || pass < 0) {
            return false;
        }
        return dfs(nums, idx - 1, take - nums[idx], pass) || dfs(nums, idx - 1, take, pass - nums[idx]);
    }

    public boolean canPartition_dp (int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        boolean[][] dp = new boolean[len][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][0] = true;
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
            if (dp[i][sum]) {
                return true;
            }
        }
        return dp[len - 1][sum];
    }

}

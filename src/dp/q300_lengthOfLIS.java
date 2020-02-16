package dp;
import java.util.Arrays;

/**
 * @author : Meredith
 * @date : 2019-08-23 22:06
 * @description :给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *     <p>
 *     示例:
 *     <p>
 *     输入: [10,9,2,5,3,7,101,18]
 *     输出: 4
 *     解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *     说明:
 *     <p>
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *     <p>
 *     进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q300_lengthOfLIS {

    public int lengthOfLIS (int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int p = 0;//记录比nums[i]前面的数的dp[]中最大的
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {

                    p = Math.max(p, dp[j]);
                }
                dp[i] = p + 1;
                ans = Math.max(ans, dp[i]);//记录最大的dp[]
            }
        }

        return ans;
    }

    public int lengthOfLIS_BinarySearch (int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            //如果当前值在数组中没有, 并且小于数组最大值, 将它替换当前最大值
            if (i < 0) {
                i = -(i + 1);
            }
            //记录最长个数
            dp[i] = num;

            //长度+1
            if (i == len) {
                len++;
            }
        }
        return len;

    }

}

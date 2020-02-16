package dp;
/**
 * @author : Meredith
 * @date : 2019-08-16 22:49
 * @description : 最大子序和
 */
public class q53_maxSubArray {

    //dp[i]=max(dp[i-1]+i,nums[i])
    static public int maxSubArray (int[] nums) {

        int max = nums[0];
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1] + nums[i], nums[i]);
            if (ans[i] > max) {
                max = ans[i];
            }
        }
        return max;
    }

    public static void main (String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

}

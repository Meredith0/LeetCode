package 网易笔试;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-21 16:06
 * @description :
 */
public class Solution3 {

    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int s = in.nextInt();
        while (t > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            long[] longs = new long[s + 1];
            for (int i = 0; i < s; i++) {
                longs[i] = in.nextInt();
            }
            longs[s] = Integer.MIN_VALUE;
            System.out.println(solution(longs));
            t--;
        }
    }

    static int solution (long[] nums) {
        //int[] dp = new int[nums.length];
        int dp = 0;
        int res = 0;
        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (nums[j] >= total) {
                //dp[i]++;
                dp++;
                total += nums[j];
                // total += nums[j];
                j++;
            }
            res = Math.max(res, dp);
            total = 0;

            // System.out.println("dp" + i + "=" + dp);
        }
        return res;
    }

}

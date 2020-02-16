package 腾讯笔试;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-20 20:38
 * @description :
 */
public class Solution4 {

    public static void main (String[] args) {
        int[] nums;
        int n = 0;
        int k = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        int x;

        // int i = 0;
        //  while (i < n ) {
        x = nums[0];

        for (int j = 1, i = 0; j < k + 1 && i < n; j++) {
            if (x - j * x != 0) {
                System.out.println(x - j * x);
            } else {
                i++;
                if (nums[i] != 0) {
                    x = nums[i];
                }
            }
        }

        // }
    }

    public static int getNonzeroMin (int[] nums, int n) {
        int i;
        for (i = 0; i < n; i++) {
            if (nums[i] != 0) {
                System.out.println(nums[i]);
                return nums[i];
            }
        }
        System.out.println(0);
        return 0;
    }

}

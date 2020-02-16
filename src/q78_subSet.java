import java.util.ArrayList;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-09-03 00:03
 * @description :
 */
public class q78_subSet {


    public static void main (String[] args) {
        q78_subSet solution = new q78_subSet();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution.subsets(ints));

    }

    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1 << nums.length;
        for (int i = 0; i < count; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int status = (i >> j) & 1;
                if (status == 1) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;

    }

    // public List<List<Integer>> subsets_dp (int[] nums) {
    //     int[][] dp=new int[nums.length][];
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         dp[i + 1] = dp[i] + helper(nums[i + 1]);
    //     }
    // }
    //
    // private Object helper (int num) {
    // }


}

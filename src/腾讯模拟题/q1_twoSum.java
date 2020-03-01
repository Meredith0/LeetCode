package 腾讯模拟题;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : Meredith
 * @date : 2020-02-19 18:51
 * @description :
 */
public class q1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                res[0] = map.get(dif);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main (String[] args) {
        var q = new q1_twoSum();
        int[] res = q.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(res));
    }

}

/**
 * @author : Meredith
 * @date : 2019-08-12 22:08
 * @description : 两数之和
 */
public class q1_twoSum {

    //暴力
    public int[] twoSum_ (int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        throw new IllegalArgumentException("solution not found");
    }

}

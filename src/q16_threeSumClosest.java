import java.util.Arrays;

/**
 * @author : Meredith
 * @date : 2019-08-19 16:12
 * @description :
 */
public class q16_threeSumClosest {

    public static void main (String[] args) {

    }

    public int threeSumClosest (int[] nums, int target) {

        Arrays.sort(nums);
        int pivot;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            pivot = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = pivot + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }

}

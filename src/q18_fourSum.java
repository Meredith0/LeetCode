import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-08-19 17:09
 * @description :
 */
public class q18_fourSum {

    static public List<List<Integer>> fourSum (int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return lists;
        }
        int left;
        int right;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }

                    // if ((left != j + 1 && nums[left] == nums[left - 1]) //left != j+1 防止了跳过第2个数==第3个数的情况
                    //         || nums[i] + nums[j] + nums[left] + nums[right] < target) {
                    //     left++;
                    // } else if ((right != nums.length - 1 && nums[right] == nums[right + 1])
                    //                || nums[i] + nums[j] + nums[left] + nums[right] > target) {
                    //     right--;
                    // } else {
                    //     lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    //     // 满足条件的，进入下一次遍历
                    //     left++;
                    //     right--;
                    // }

                }
            }
        }
        return lists;
    }

    public static void main (String[] args) {
        int[] ints = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(fourSum(ints, 0));

    }

}

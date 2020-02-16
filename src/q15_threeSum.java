import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-08-12 23:08
 * @description : 三数之和
 */
public class q15_threeSum {

    static void quickSort (int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    static int partition (int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start - 1;
        int right = start;
        for (; right < end; right++) {
            if (nums[right] < pivot) {
                left++;

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        left++;
        int temp = nums[left];
        nums[left] = pivot;
        nums[end] = temp;
        return left;
    }

    public static void main (String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(System.out :: println);
    }

    static public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        quickSort(nums, 0, nums.length - 1);//从小到大排序
        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {//存在正负数才有解
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {//最左值>0必定无解
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue; // 去重
                }
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // 去重
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // 去重
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }

                }
            }
        }
        return lists;
    }

}

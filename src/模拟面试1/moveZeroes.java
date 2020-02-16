package 模拟面试1;
/**
 * @author : Meredith
 * @date : 2019-08-19 00:05
 * @description :给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class moveZeroes {
    static public void moveZeroes_(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+ 1] = temp;
                }
            }
        }

    }

    public static void main (String[] args) {
        int[] ints = {0,0,1};
        moveZeroes_(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);

        }
    }
}

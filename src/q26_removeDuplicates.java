/**
 * @author : Meredith
 * @date : 2019-08-31 19:07
 * @description :
 */
public class q26_removeDuplicates {

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int removeDuplicates (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int removeDuplicates2 (int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int current = 1;           //新数组中有效位置的最后一位，新加入的数据应当写到current+1
        for (int i = 2; i < nums.length; i++) //从第三位开始循环，前两位无论如何都是要加入新数组的
        {
            /**   i不能加入到current的情况是：i和current还有current-1处的值都相等
             * 能加入的情况是:i和current的值相等&&i和current-1的值不相等、
             * i和current还有current-1的值都不相等、 还有一种情况是不可能出现的情况
             * ：i和current的值不相等&&i和current的值相等 这种情况是不可能出现的 所以可以用i和current-1的值是否相等来判定是否写入的操作 或者可以用
             * (nums[i]==nums[current]&&nums[i]==nums[current-1])  */

            if (nums[i] != nums[current - 1])  //符合条件，加入新数组
            {
                current += 1;
                nums[current] = nums[i];
            }
        }
        return current + 1;
    }

}

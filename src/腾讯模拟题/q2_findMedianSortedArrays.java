package 腾讯模拟题;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Meredith
 * @date : 2020-02-19 18:51
 * @description :
 */
public class q2_findMedianSortedArrays {

    public static void main (String[] args)  {
        var q = new q2_findMedianSortedArrays();
        // int[] nums1 = new int[]{0};
        // int[] nums2 = new int[]{};
        // System.out.println(q.findMedianSortedArrays(nums1, nums2));
        q.pluses();
    }

    public void pluses( ) {
        int i = -8;
        System.out.println(++i);
        // System.out.println(i++);
        // int j = ++i + i++ + i++ + ++i;
        // int k = j++ + ++j + j++ + ++j;
        // System.out.println(String.format("i=%s,j=%s,k=%s", i, j, k));
    }

    public double findMedianSortedArrays (int[] nums1, int[] nums2) {
        int len1 = 0;
        int len2 = 0;
        int[] notnull = new int[0];
        if (nums1 == null) {
            notnull = nums2;
        }
        if (nums2 == null) {
            notnull = nums1;
        }
        if (nums1 == null || nums2 == null) {
            if ((notnull.length & 1) == 1) {
                return notnull[notnull.length / 2];
            } else {
                double sum = (notnull[notnull.length / 2] + notnull[notnull.length / 2 + 1]);
                return sum / 2;
            }
        }

        int totalLength = len1 + len2;
        int middle = totalLength / 2;
        boolean isOdd = (totalLength & 1) == 1;
        int idx1 = 0;
        int idx2 = 0;
        Deque<Integer> temp = new LinkedList<>();
        for (int i = 0; i < middle + 1; i++) {
            if (temp.size() == 2) {
                temp.removeFirst();
            }
            if (idx1 < len1 && idx2 < len2 && nums1[idx1] < nums2[idx2]) {
                temp.addLast(nums1[idx1]);
                idx1++;
            } else if (idx2 < len2) {
                temp.addLast(nums2[idx2]);
                idx2++;
            }
        }
        if (isOdd) {
            return temp.getLast();
        }
        return (double) (temp.getFirst() + temp.getLast()) / 2;
    }

}
//对于任意给定的一组字符组成的一个数组，假设一定存在某个字符出现的总次数超过其它字符出现的总次数之和，如：字符数组['a','b','2','b','b']中的字符'b'，再如字符数组['c','2','c','c']中的字符'c'。
// 1)（4分）请编写程序找出数组中该字符，要求：程序中使用到Map型数据存储结构(如HashMap、HashTable等)；
// 2)（5分）请编写程序找出数组中该字符，要求：①程序中不使用Map型数据存储结构(如HashMap、HashTable等)；②尝试将数据有序化后再进行查找；③排序不允许调用Java API类库，排序算法时间复杂度优先；
// 3)（6分）请编写程序找出数组中该字符，要求：①思路与上面的1)和2)不同，不使用Map型数据存储结构且不使用排序手段；②时间复杂度为O(n);(注：n代表数组长度)③空间复杂度越低越好；
// 4)（5分）请分别给出上面1)2)3)你实现的算法的时间复杂度和空间复杂度；
// （注：不能使用本地IDE）
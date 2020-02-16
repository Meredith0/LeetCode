import common.ListNode;

/**
 * @author : Meredith
 * @date : 2019-08-19 23:49
 * @description :将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *     <p>
 *     示例：
 *     <p>
 *     输入：1->2->4, 1->3->4
 *     输出：1->1->2->3->4->4
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q21_mergeTwoLists {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummyNode.next;
    }

}

import common.ListNode;

/**
 * @author : Meredith
 * @date : 2019-10-01 14:48
 * @description :
 */
public class q83_deleteDuplicates {

    public ListNode deleteDuplicates (ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

}

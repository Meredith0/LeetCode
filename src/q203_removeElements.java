import common.ListNode;

/**
 * @author : Meredith
 * @date : 2019-10-01 16:02
 * @description :
 */
public class q203_removeElements {

    public ListNode removeElements (ListNode head, int val) {
        ListNode dummyNode = new ListNode(val - 1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode removeElements_recursively(ListNode head, int val) {
        if(head==null)
            return null;
        head.next=removeElements_recursively(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }

}

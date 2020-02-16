/**
 * @author : Meredith
 * @date : 2019-09-16 09:21
 * @description :
 */
public class q100_isSameTree {

    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

}

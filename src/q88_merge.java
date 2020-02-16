/**
 * @author : Meredith
 * @date : 2019-09-15 15:58
 * @description :
 */
public class q88_merge {

    public static void main (String[] args) {

    }

    public void merge (int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length - 1;
        int p;
        m--;
        n--;
        while (m > 0 && n > 0) {
            if (nums1[m] >= nums2[n]) {
                p = nums1[m];
                m--;
            } else {
                p = nums2[n];
                n--;
            }
            nums1[i] = p;
            i--;
        }
        while (m > 0) {
            nums1[i] = nums1[m];
            i--;
            m--;
        }
        while (n > 0) {
            nums2[i] = nums2[n];
            i--;
            n--;
        }
    }

}

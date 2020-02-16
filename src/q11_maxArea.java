/**
 * @author : Meredith
 * @date : 2019-08-18 23:45
 * @description :
 */
public class q11_maxArea {

    // 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
    // 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
    public int maxArea (int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            //左边是短板
            if (height[left] < height[right]) {
                ans = Math.max(ans,height[left] * (right - left));
                left++;
            }else {
                ans = Math.max(ans,height[right] * (right - left));
                right--;
            }
        }
        return ans;
    }

}

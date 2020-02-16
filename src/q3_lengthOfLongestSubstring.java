import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author : Meredith
 * @date : 2019-08-14 17:04
 * @description : 无重复字符的最长子串
 */
public class q3_lengthOfLongestSubstring {

    //滑动窗口, 用HashSet做窗口
    public static int lengthOfLongestSubstring_ (String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int i = 0, j = 0;
        int res = 0;
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static void main (String[] args) {
        String str = "abczzabcbb";
        System.out.println(lengthOfLongestSubstring_(str));
    }

    //优化的滑动窗口, 用hashMap
    public int lengthOfLongestSubstring_HashMap (String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}

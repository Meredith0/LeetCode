/**
 * @author : Meredith
 * @date : 2019-08-15 16:29
 * @description : 最长回文字符串
 */
public class q5_longestPalindrome {

    static public String longestPalindrome_ (String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    static public String longestPalindrome_dp (String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
        {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                {
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) &&
                                    s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    public static void main (String[] args) {
        String s1 = "abczzzab";
        String s2 = "aba456cba";
        System.out.println(longestPalindrome_(s1));
        System.out.println(longestPalindrome_(s2));
        System.out.println(longestPalindrome_dp(s1));
        System.out.println(longestPalindrome_dp(s2));

    }

}

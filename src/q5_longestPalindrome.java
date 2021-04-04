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
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];

                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s1 = "abczzzab";
        String s2 = "#a#b#a#b#a#";
        System.out.println(longestPalindrome_(s1));
        System.out.println(longestPalindrome_(s2));
        System.out.println(longestPalindrome_dp(s1));
        System.out.println(longestPalindrome_dp(s2));

        q5_longestPalindrome q5_longestPalindrome = new q5_longestPalindrome();
        System.out.println(q5_longestPalindrome.manacher(s1));
        System.out.println(q5_longestPalindrome.manacher(s2));
    }

    public String manacher(String s) {
        char[] chars = separateWith('#', s);

        int max = 0;
        // #a#b#a#b#a#

        int start = 0;
        for (int i = 0; i < s.length() * 2 + 1; i++) {
            int currentLength = centerSpreadCount(chars, i);
            if (currentLength > max) {
                max = currentLength;
                start = (max - start) / 2;
            }
        }

        return s.substring(start, start + max);

    }

    private char[] separateWith(char separator, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(separator);
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            stringBuilder.append(separator);
        }
        return stringBuilder.toString().toCharArray();
    }

    private int centerSpreadCount(char[] chars, int index) {
        // #a#b#a#b#a#
        int count = 0;
        int i = index - 1;
        int j = index + 1;
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            i--;
            j++;
            count++;
        }
        return count;
    }

}

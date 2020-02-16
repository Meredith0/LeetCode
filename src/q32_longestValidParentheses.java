/**
 * @author : Meredith
 * @date : 2019-09-09 09:45
 * @description :
 */
public class q32_longestValidParentheses {

    public int longestValidParentheses (String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // ()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // (()())
                else if (i - dp[i - 1] > 0 //判断中间有成对的括号
                             && s.charAt(i - dp[i - 1] - 1) == '(') {//找到左括号
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ?//防止(()))))
                                             dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}

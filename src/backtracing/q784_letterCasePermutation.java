package backtracing;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Meredith
 * @date : 2019-09-02 21:38
 * @description :给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *     <p>
 *     示例:
 *     输入: S = "a1b2"
 *     输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *     <p>
 *     输入: S = "3z4"
 *     输出: ["3z4", "3Z4"]
 *     <p>
 *     输入: S = "12345"
 *     输出: ["12345"]
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/letter-case-permutation
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q784_letterCasePermutation {

    public List<String> letterCasePermutation (String S) {
        List<String> res = new ArrayList<>();
        // 特判
        int len = S.length();
        if (len == 0) {
            return res;
        }
        Stack<Character> path = new Stack<>();
        dfs(S, 0, len, path, res);
        return res;
    }

    private void dfs (String S, int index, int len, Stack<Character> stack, List<String> res) {
        if (index == len) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                stringBuilder.append(stack.get(i));
            }
            res.add(stringBuilder.toString());
            return;
        }

        stack.add(S.charAt(index));
        dfs(S, index + 1, len, stack, res);
        stack.pop();

        if (Character.isLetter(S.charAt(index))) {
            stack.add((char) (S.charAt(index) ^ (1 << 5)));
            dfs(S, index + 1, len, stack, res);
            stack.pop();
        }
    }
    public static void main(String[] args) {
        var solution = new q784_letterCasePermutation();
        String S = "a1b2";
        List<String> letterCasePermutation = solution.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }
}

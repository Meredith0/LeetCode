import java.util.HashMap;
import java.util.Stack;

/**
 * @author : Meredith
 * @date : 2019-08-19 23:08
 * @description :给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *     <p>
 *     有效字符串需满足：
 *     <p>
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *     注意空字符串可被认为是有效字符串。
 *     <p>
 *     示例 1:
 *     <p>
 *     输入: "()"
 *     输出: true
 *     示例 2:
 *     <p>
 *     输入: "()[]{}"
 *     输出: true
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/valid-parentheses
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q20_isValid {

    public boolean isValid (String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            //如果是右括号, 判断与栈顶是否匹配;
            // 匹配 -> pop栈顶
            // 不匹配 -> return false
            if (map.containsKey(s.charAt(i))) {
                Character top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(s.charAt(i))) {
                    return false;
                }
            }
            //如果是左括号 -> 入栈
            else {
                stack.push(s.charAt(i));
            }

        }
        return stack.isEmpty();
    }

}

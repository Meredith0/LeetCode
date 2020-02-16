import java.util.LinkedList;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-08-19 16:40
 * @description :给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *     <p>
 *     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *     <p>
 *     <p>
 *     <p>
 *     示例:
 *     <p>
 *     输入："23"
 *     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *     说明:
 *     尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *     <p>
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q17_letterCombinations {

    //利用队列先进先出，将之前的字符串出队，拼接新的字符，新生成的字符串入队。
    // 而且使用LinkedList，申请新空间方便，不会像ArrayList那样频繁扩容导致的性能低下。
    static public List<String> letterCombinations (String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        System.out.println(letterCombinations("23"));
    }

}

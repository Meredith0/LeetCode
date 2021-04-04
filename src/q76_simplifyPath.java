import java.util.Stack;

/**
 * @author zeng.fk
 *     2021-03-03 11:27
 */
public class q76_simplifyPath {

    public static void main(String[] args) {
        System.out.println(new q76_simplifyPath().simplifyPath("/a/./b/../t"));
        System.out.println(new q76_simplifyPath().simplifyPath("/../"));
        System.out.println(new q76_simplifyPath().simplifyPath("/home/"));
        System.out.println(new q76_simplifyPath().simplifyPath("/home//foo/"));

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (String s : str) {
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!s.equals("") && !s.equals("..")) {
                stack.push(s);
            }
        }
        Stack<String> reverseStack = new Stack<>();
        stack.forEach(reverseStack :: push);
        StringBuilder res = new StringBuilder();
        reverseStack.forEach((x) -> {
            if (!x.equals("")) {
                res.append("/").append(x);
            }
        });
        return res.toString().equals("") ? "/" : res.toString();
    }

}

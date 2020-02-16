package 腾讯笔试;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-20 19:54
 * @description :
 */
public class Solution1 {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNextInt() && t > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例

            int a = in.nextInt();
            String b = in.next();
            if (validate(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }
    }

    static public boolean validate (int a, String str) {

        int i;
        for (i = 0; i < a; i++) {
            if (str.charAt(i) == '8') {
                break;
            }
        }
        return a - i >= 11;
    }

}

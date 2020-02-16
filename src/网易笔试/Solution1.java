package 网易笔试;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-21 15:47
 * @description :
 */
public class Solution1 {

    static String solution (int x) {
        // long n = 0;
        int n = x % 9;
        int count = x / 9;

        String res = n == 0 ? "" : "" + n;
        while (count > 0) {

            res += "9";
            count--;
        }
        return res;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            System.out.println(solution(a));
            t--;
        }
    }

}

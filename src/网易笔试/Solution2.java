package 网易笔试;
import java.util.Scanner;

/**
 * @author : Meredith
 * @date : 2019-09-21 15:33
 * @description :
 */
public class Solution2 {

    static int solution (int a, int b, int p, int q) {
        int count = 0;
        while (a < b) {
            if (a + p >= b) {
                count++;
                return count;
            }

            p = p * q;
            count++;
        }
        return count;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            System.out.println(solution(a, b, p, q));
            t--;
        }

    }

}

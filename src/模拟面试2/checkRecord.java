package 模拟面试2;
/**
 * @author : Meredith
 * @date : 2019-09-08 12:31
 * @description :
 *     给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *     <p>
 *     'A' : Absent，缺勤
 *     'L' : Late，迟到
 *     'P' : Present，到场
 *     如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *     <p>
 *     你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *     <p>
 *     示例 1:
 *     <p>
 *     输入: "PPALLP"
 *     输出: True
 *     示例 2:
 *     <p>
 *     输入: "PPALLL"
 *     输出: False
 */
public class checkRecord {

    static public boolean checkRecord (String s) {
        int absent = 0;
        int late = 0;

        String str = s + "PP";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                absent++;
            } else if (str.charAt(i) == 'L' && str.charAt(i + 1) == 'L' && str.charAt(i + 2) == 'L') {
                late++;
            }
        }
        return absent < 2 && late < 1;
    }

    public static void main (String[] args) {
        System.out.println(checkRecord("PPALLL"));
        System.out.println(checkRecord("LLPPPLL"));
    }

}

package test;
/**
 * @author : Meredith
 * @date : 2019-09-03 23:18
 * @description :
 */
public class test01 {

    public static void main (String[] args) {
        Integer a = Integer.valueOf(1);
        Integer b =  Integer.valueOf(1);;
        Integer c = Integer.valueOf(129);
        Integer d = Integer.valueOf(129);

        System.out.println(a == b);
        System.out.println(c == d);

        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        String str4 = "he";
        String str6 = "llo";
        System.out.println(str1 == (str4 + str6));
        System.out.println(str1 == str3);

    }
}

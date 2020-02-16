import java.util.ArrayList;

/**
 * @author : Meredith
 * @date : 2019-09-07 15:15
 * @description :
 */
public class q9_isPalindrome {

    static public boolean isPalindrome (int x) {
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            if (x < 0) {
                int t = x % 10;
                x = -x / 10;
                list.add(t);
            }
            int t = x % 10;
            x = x / 10;
            list.add(t);
        }
        int i = 0;
        int j = list.size() - 1;
        System.out.println(list);
        while (i < j) {
            if (list.get(i).equals(list.get(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        isPalindrome(-121);
    }

}

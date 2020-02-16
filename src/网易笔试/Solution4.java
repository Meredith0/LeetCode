package 网易笔试;
import java.util.ArrayList;

/**
 * @author : Meredith
 * @date : 2019-09-21 16:48
 * @description :
 */
public class Solution4 {

    public static void main (String[] args) {
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add("1");
        l2.add(1);
        System.out.println(l1.get(0).getClass());
        System.out.println(l2.get(0).getClass());
        System.out.println(l1.getClass() == l2.getClass());
    }

}

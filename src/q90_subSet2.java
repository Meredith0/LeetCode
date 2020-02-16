import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Meredith
 * @date : 2019-09-03 15:10
 * @description :
 */
public class q90_subSet2 {

    //one-hot encoding
    public List<List<Integer>> subsetsWithDup (int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1 << num.length;
        for (int i = 0; i < subsetNum; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false;
            for (int j = 0; j < num.length; j++) {
                //当前位是 1
                if ((i >> j & 1) == 1) {
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if (j > 0 && num[j] == num[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    } else {
                        list.add(num[j]);
                    }
                }
            }
            if (!illegal) {
                lists.add(list);
            }
        }
        return lists;
    }
}

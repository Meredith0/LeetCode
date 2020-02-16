import java.util.Arrays;

/**
 * @author : Meredith
 * @date : 2019-09-15 15:09
 * @description :
 */
public class q66_pulsOne {

    public static int[] plusOne (int[] digits) {
        int length = digits.length - 1;
        digits[length]++;
        for (int i = length; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }
        if (digits[0] == 10) {
            int[] res = new int[length + 2];
            res[0] = 1;
            res[1] = 0;
            for (int i = 2; i < length + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

    public static int[] plusOne_mod (int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main (String[] args) {
        int[] ints = new int[]{9, 9, 9};

        int[] res = plusOne_mod(ints);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");

        }

        int[] ints1 = new int[10];
        System.out.println(Arrays.toString(ints1));
    }

}

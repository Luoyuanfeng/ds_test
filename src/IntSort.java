import com.sun.jmx.snmp.SnmpUnsignedInt;

import java.util.Arrays;
import java.util.Objects;

/**
 * 可重复的正整数排序
 */
public class IntSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 15, 7, 9, 14, 3, 6, 8, 10, 9, 9, 9, 0, 0};
        int[] res = sort(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sort(int[] arr) {
        if (Objects.isNull(arr)) {
            return null;
        }
        int max = 0;
        for (int e : arr) {
            max = e > max ? e : max;
        }

        int[] temp = new int[max + 1];
        for (int e : arr) {
            temp[e]++;
        }

        int resultIdx = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                result[resultIdx] = i;
                temp[i]--;
                resultIdx++;
            }
        }

        return result;
    }

}

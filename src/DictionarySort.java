import java.util.Arrays;

public class DictionarySort {

    public static void main(String[] args) {
        int[] result = dictSort(15);
        System.out.println(Arrays.toString(result));
    }

    public static int[] dictSort(int n) {
        int[] result = new int[n];
        int val = 1;
        int index = 0;
        while (val <= n && index < n) {
            result[index] = val;
            val = next(val, n);
            index++;
        }
        return result;
    }

    // less than 100
    public static int next(int curr, int n) {
        int r;
        if (curr * 10 <= n && curr % 10 != 0) {
            r = curr * 10;
        } else if ((curr + 1) % 10 == 0) {
            r = (curr + 1) / 10;
        } else if (curr == n && curr > 10) {
            r = curr / 10 + 1;
        } else {
            r = curr + 1;
        }
        System.out.println(r);
        return r;
    }
}

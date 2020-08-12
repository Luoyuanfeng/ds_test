import java.util.Arrays;

public class DictionarySort2 {

    public static void main(String[] args) {
        String[] result = dictSort(100);
        System.out.println(Arrays.toString(result));
    }

    public static String[] dictSort(int n) {
        if (n < 1) {
            return null;
        }
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = String.valueOf(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++ ) {
                String a = result[i];
                String b = result[j];
                if (a.compareTo(b) > 0) {
                    result[i] = b;
                    result[j] = a;
                }
            }
        }
        return result;
    }
}

import java.util.Arrays;

public class QSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 4, 5, 20, 11, 7, 3, 10, 12, 16, 15, 13, 17, 19};
        System.out.println("BEFORE: " + Arrays.toString(arr));
        qSort(arr, 0, arr.length - 1);
        System.out.println(" AFTER: " + Arrays.toString(arr));
    }

    public static void qSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int mark = array[j];
        while (i < j) {
            while (i < j && array[i] <= mark) {
                i++;
            }
            while (i < j && array[j] >= mark) {
                j--;
            }
            swap(array, i ,j);
        }
        swap(array, i, high);
        qSort(array, low, i - 1);
        qSort(array, i, high);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

package sorts;

public class CountingSort {
    public static void countingSort(int[] array) {
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNum) maxNum = array[i];
        }
        int[] count = new int[maxNum + 1];

        for (int i = 0; i < count.length; i++) count[i] = 0;
        for (int i = 0; i < array.length; i++) count[array[i]]++;

        int k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = count[i]; j > 0; j--) array[k++] = i;
    }
}

package sorts;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length);
    }
    public static int[] quickSort(int[] array, int i, int j) {
        if (i == j) return array;

        int pivot = partition(array, i, j);

        quickSort(array, i, pivot);
        quickSort(array, pivot + 1, j);

        return array;
    }
    public static int partition(int[] array, int i, int j) {
        int pivot = i;
        int s1_index = i;
        // int s2_index = i;

        for (int k = i + 1; k < j; k++)
            // if (array[k] >= array[pivot]) s2_index++;
            // else {
            //     Swap.swap(array, k, ++s1_index);
            //     s2_index++;
            // }
            if (array[k] < array[pivot]) Swap.swap(array, k, ++s1_index);
        Swap.swap(array, pivot, s1_index);
        return s1_index;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 18, 5, 8, 14, 12, 34, 76, 4};
        arr = quickSort(arr);
        for (int i : arr) System.out.println(i);
    }
}

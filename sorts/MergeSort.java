package sorts;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;

        int n = array.length / 2;
        int[] left = new int[n];
        int[] right = new int[array.length - n];

        int i;
        for (i = 0; i < left.length; i++) left[i] = array[i];    
        for (int j = 0; i < array.length; i++) right[j++] = array[i];

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int left_index = 0;
        int right_index = 0;
        int count = 0;

        while (left_index < left.length && right_index < right.length) {
            if (left[left_index] < right[right_index]) merged[count++] = left[left_index++];
            else merged[count++] = right[right_index++];
        }

        while (left_index < left.length) merged[count++] = left[left_index++];
        while (right_index < right.length) merged[count++] = right[right_index++];

        return merged;
    }
}
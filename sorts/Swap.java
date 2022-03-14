package sorts;

public class Swap {
    public static void swap(int[] array, int i, int j) {
        // array[i] += array[j];
        // array[j] = array[i] - array[j];
        // array[i] -= array[j];
        int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
    }
}

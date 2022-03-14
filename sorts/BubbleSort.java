package sorts;

class BubbleSort {
    public static void bubbleSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j] < array[j-1]) Swap.swap(array, j, j-1);
            }
        }
    }
}
package sorts;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 18, 5, 8, 14, 12, 34, 76, 4};
        HeapSort.heapSort(arr);
        for (int i : arr) System.out.println(i);
    }
}

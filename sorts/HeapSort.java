package sorts;

import basicdatastructures.BinaryHeap;

public class HeapSort {
    public static void heapSort(int[] array) {
        BinaryHeap heap = new BinaryHeap(array.length);
        for (int i : array) heap.insert(i);
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.top();
            heap.pop();
        }
    }
}

package basicdatastructures;

import sorts.Swap;

public class BinaryHeap {
    public int[] heap;
    public int size;

    public BinaryHeap(int size) {
        heap = new int[size + 1];
        heap[0] = Integer.MIN_VALUE;
        this.size = 1;
    }
    public int top() {
        return heap[1];
    }
    public void insert(int value) {
        int ind = size;
        heap[ind] = value;
        while (ind != 1 && heap[ind] < heap[ind / 2]) {
            Swap.swap(heap, ind, ind / 2);
            ind /= 2;
        }
        size++;
    }
    public void pop() {
        heap[1] = heap[size - 1];
        heap[size - 1] = Integer.MAX_VALUE;
        int ind = 1;
        while (
            (ind * 2 < size &&
            heap[ind] > heap[ind * 2]) ||
            (ind * 2 + 1 < size &&
            heap[ind] > heap[ind * 2 + 1])
        ) {
            if (ind * 2 + 1 > size || heap[ind * 2] < heap[ind * 2 + 1])
                Swap.swap(heap, ind * 2, ind);
            else { Swap.swap(heap, ind * 2 + 1, ind); ind++; }
            ind *= 2;
        }
        size--;
    }
}

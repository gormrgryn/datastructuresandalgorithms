package basicdatastructures;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> queue;
    private int length;

    public PriorityQueue() {
        queue = new ArrayList<T>();
        length = 0;
    }
    public T front() {
        return queue.get(0);
    }
    public T pop() {
        if (isEmpty()) return null;
        T v = front();
        for (int i = 0; i < length - 1; i++) {
            queue.set(i, queue.get(i + 1));
        }
        length--;
        return v;
    }
    public void push(T val) {
        if (length == 0) {
            queue.add(val);
            length++;
        }
        else {
            int i;
            for (i = length - 1; i >= 0; i--) {
                if (queue.get(i).compareTo(val) > 0) queue.set(i + 1, queue.get(i));
                else break;
            }
            length++;
            queue.add(i + 1, val);
        }
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public int length() {
        return length;
    }
}

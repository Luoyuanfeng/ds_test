import java.util.LinkedList;
import java.util.Queue;

public class DoubleQueueStack<T> {

    private Queue<T> Q1;
    private Queue<T> Q2;

    public DoubleQueueStack() {
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();
    }

    public void push(T e) {
        while (!Q2.isEmpty()) {
            Q1.add(Q2.poll());
        }
        Q1.add(e);
    }

    public T pop() {
        T res = null;
        while (!Q1.isEmpty()) {
            if (Q1.size() == 1) {
                res = Q1.poll();
            } else {
                Q2.add(Q1.poll());
            }
        }
        while (!Q2.isEmpty()) {
            Q1.add(Q2.poll());
        }
        return res;
    }

    public int size() {
        return Q1.size() + Q2.size();
    }

    public boolean isEmpty() {
        return Q1.isEmpty() && Q2.isEmpty();
    }
}

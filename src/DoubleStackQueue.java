import org.omg.CORBA.INTERNAL;

import java.util.Objects;
import java.util.Stack;

public class DoubleStackQueue<T> {

    private Stack<T> L;
    private Stack<T> R;

    public DoubleStackQueue() {
        L = new Stack<>();
        R = new Stack<>();
    }

    public void enq(T e) {
        if (Objects.isNull(e)) {
            return;
        }
        while (!R.isEmpty()) {
            L.push(R.pop());
        }
        L.push(e);
    }

    public T deq() {
        if (!R.isEmpty()) {
            return R.pop();
        }
        while (!L.isEmpty()) {
            R.push(L.pop());
        }
        return R.isEmpty() ? null : R.pop();
    }

    public int size() {
        return L.size() + R.size();
    }

    public boolean isEmpty() {
        return L.isEmpty() && R.isEmpty();
    }

}

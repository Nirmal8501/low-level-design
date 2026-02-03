package BehaviouralPatterns.Memento;

import java.util.Stack;

public class MementoCaretaker<T> {
//    Prefer deque over stack but I just used this for simplicity
    private final Stack<T> states = new Stack<>();

    public void add(T state) {
        states.push(state);
    }

    public T getLastState() {
        return states.pop();
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }

}

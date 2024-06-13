package ru.latypov;

public class Counter {
    private Object monitor = new Object();
    private int value;

    public void increment() {
        synchronized (monitor) {
            value++;
        }
    }

    public void decrement() {
        synchronized (monitor) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }
}

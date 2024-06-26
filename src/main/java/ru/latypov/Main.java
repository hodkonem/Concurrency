package ru.latypov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.decrement();
                }
            }
        });
      thread1.start();
      thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(counter.getValue());
    }

//    private static final int SIZE = 50_000_000;
//    private static final int HALF = SIZE / 2;
//
//    public static void main(String[] args) {
//        startTimer();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                withConcurrency();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                withoutConcurrency();
//            }
//        }).start();
//    }
//
//    private static void startTimer() {
//        Thread timer = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int seconds = 0;
//                try {
//                    while (true) {
//                        System.out.println(seconds++);
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        timer.setDaemon(true);
//        timer.start();
//    }
//
//    private static void withoutConcurrency() {
//        float[] array = new float[SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            array[i] = 1f;
//        }
//        long before = System.currentTimeMillis();
//        for (int i = 0; i < SIZE; i++) {
//            float f = (float) i;
//            array[i] = (float) (array[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
//        }
//        long after = System.currentTimeMillis();
//        System.out.println("withoutConcurrency: " + (after - before));
//    }
//
//    private static void withConcurrency() {
//        float[] array = new float[SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            array[i] = 1f;
//        }
//        long before = System.currentTimeMillis();
//        float[] firstHalf = new float[HALF];
//        float[] secondHalf = new float[HALF];
//        System.arraycopy(array, 0, firstHalf, 0, HALF);
//        System.arraycopy(array, HALF, secondHalf, 0, HALF);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < HALF; i++) {
//                    float f = (float) i;
//                    firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
//                }
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < HALF; i++) {
//                    float f = (float) i;
//                    secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.arraycopy(firstHalf, 0, array, 0, HALF);
//        System.arraycopy(secondHalf, 0, array, HALF, HALF);
//        long after = System.currentTimeMillis();
//        System.out.println("withConcurrency: " + (after - before));
}
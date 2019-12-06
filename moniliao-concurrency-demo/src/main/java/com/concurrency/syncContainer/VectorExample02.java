package com.concurrency.syncContainer;

import com.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.syncContainer
 */
@Slf4j
@ThreadNotSafe
public class VectorExample02 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }

}

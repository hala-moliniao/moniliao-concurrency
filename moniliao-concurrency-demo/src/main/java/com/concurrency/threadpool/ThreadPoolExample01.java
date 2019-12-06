package com.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: created by limingzhou
 * @date: 2019/11/29
 * @description: main.java.com.concurrency.threadpool
 */

public class ThreadPoolExample01 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            String arg = args[i];

        }
    }
}

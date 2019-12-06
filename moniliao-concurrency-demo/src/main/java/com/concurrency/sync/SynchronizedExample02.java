package com.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: created by limingzhou
 * @date: 2019/11/14
 * @description: com.concurrency.sync
 */
@Slf4j
public class SynchronizedExample02 {

    // 修饰一个类
    public static void test1(int j) {
        synchronized (SynchronizedExample02.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test01：{} -> {}",j, i);

            }
        }
    }

    // 修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test02：{} -> {}",j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample02 demo1 = new SynchronizedExample02();
        SynchronizedExample02 demo2 = new SynchronizedExample02();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
                demo1.test2(1);
        });
        executorService.execute(() -> {
                demo2.test2(2);
        });
    }
}

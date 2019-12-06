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
public class SynchronizedExample01 {

    // 修饰一个代码块
    // synchronized不属于类的一部分，子类不会继承
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test01：{} -> {}",j, i);

            }
        }
    }

    // 修饰一个方法等同于修饰一个代码块
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test02：{} -> {}",j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample01 demo1 = new SynchronizedExample01();
        SynchronizedExample01 demo2 = new SynchronizedExample01();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
                demo1.test1(1);
        });
        executorService.execute(() -> {
                demo2.test1(2);
        });

        executorService.execute(() -> {
            demo1.test2(1);
        });
        executorService.execute(() -> {
            demo2.test2(2);
        });
    }
}

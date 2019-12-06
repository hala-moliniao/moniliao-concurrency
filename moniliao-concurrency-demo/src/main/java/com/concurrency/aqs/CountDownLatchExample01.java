package com.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: created by limingzhou
 * @date: 2019/11/17
 * @description: com.concurrency
 */
@Slf4j
public class CountDownLatchExample01 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i <threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception:{}", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("线程号：{}", threadNum);
        Thread.sleep(100);
    }
}

package com.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: created by limingzhou
 * @date: 2019/11/17
 * @description: com.concurrency.aqs
 */
@Slf4j
public class SemaphoreExample03 {

    private static final int threadCount = 20;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <threadCount; i++) {
            final int threadNum = i;

            executorService.execute(() -> {
                try {
                    // 尝试获取一个许可
                   if(semaphore.tryAcquire()) {
                       test(threadNum);
                       semaphore.release();
                   }
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {

        log.info("线程号：{}", threadNum);
        Thread.sleep(1000);
    }
}

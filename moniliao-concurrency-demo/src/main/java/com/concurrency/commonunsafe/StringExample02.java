package com.concurrency.commonunsafe;

import com.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.commonunsafe
 */
@Slf4j
@ThreadSafe
public class StringExample02 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception信息:{},exception堆栈信息:{}",e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",sb.length());
    }

    private static void update() {
        sb.append("1");
    }
}

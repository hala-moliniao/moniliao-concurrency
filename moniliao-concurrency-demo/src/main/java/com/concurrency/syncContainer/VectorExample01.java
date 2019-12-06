package com.concurrency.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.syncContainer
 */
@Slf4j
public class VectorExample01 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception信息:{},exception堆栈信息:{}",e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("vector size:{}", vector.size());
    }

    private static void update(int i) {
        vector.add(i);
    }
}

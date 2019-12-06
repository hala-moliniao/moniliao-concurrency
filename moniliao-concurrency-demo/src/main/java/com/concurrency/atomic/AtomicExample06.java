package com.concurrency.atomic;

import com.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: created by limingzhou
 * @date: 2019/11/13
 * @description: com.concurrency.test
 */

@Slf4j
@ThreadSafe
public class AtomicExample06 {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception信息:{},exception堆栈信息",e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappened:{}",isHappened.get());
    }

    private static void test() {
        if(isHappened.compareAndSet(false,true)) {
            log.info("execute");
        }
    }

}

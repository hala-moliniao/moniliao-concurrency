package com.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: created by limingzhou
 * @date: 2019/11/17
 * @description: com.concurrency.aqs
 */
@Slf4j
public class CyclicBarrierExample01 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    // 尝试获取一个许可
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception:{}", e);
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready.", threadNum);
        barrier.await();
        log.info("{} is continuous.", threadNum);
    }
}

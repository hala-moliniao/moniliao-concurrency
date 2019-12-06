package com.concurrency.commonunsafe;

import com.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.commonunsafe
 */
@Slf4j
@ThreadNotSafe
public class ArrayListExample01 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();

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
        log.info("arrayList size:{}", arrayList.size());
    }

    private static void update(int i) {
        arrayList.add(i);
    }
}

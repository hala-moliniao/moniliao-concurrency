package com.concurrency.atomic;

import com.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: created by limingzhou
 * @date: 2019/11/13
 * @description: com.concurrency.test
 */

@Slf4j
@ThreadSafe
public class AtomicExample04 {

    // 请求总数
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count:{}",count.get());
    }

}

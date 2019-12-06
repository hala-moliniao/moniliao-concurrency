package com.concurrency.atomic;

import com.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: created by limingzhou
 * @date: 2019/11/13
 * @description: com.concurrency.test
 */

@Slf4j
@ThreadSafe
public class AtomicExample05 {

    // 第二个参数必须是volatile修饰且不能是static的
    private static AtomicIntegerFieldUpdater<AtomicExample05> updater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicExample05.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicExample05 example05 = new AtomicExample05();
        if (updater.compareAndSet(example05, 100, 120)) {
            log.info("update success 1:{}", example05.getCount());
        }
        if (updater.compareAndSet(example05, 100, 120)) {
            log.info("update success 2:{}", example05.getCount());
        } else {
            log.info("update fail:{}", example05.getCount());
        }
    }

}

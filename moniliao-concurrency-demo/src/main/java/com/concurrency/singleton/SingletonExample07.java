package com.concurrency.singleton;

import com.concurrency.annotations.Recommend;
import com.concurrency.annotations.ThreadSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample07 {

    // 私有构造函数
    private SingletonExample07() {
    }

    public static SingletonExample07 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample07 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample07();
        }

        public SingletonExample07 getInstance() {
            return singleton;
        }
    }
}

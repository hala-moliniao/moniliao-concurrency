package com.concurrency.singleton;

import com.concurrency.annotations.ThreadSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 饿汉模式：单例实例在类装载使用时创建
 * 在构造函数中存在过多的处理，导致加载的时候特别慢影响性能，或者创建后未使用导致资源浪费
 */
@ThreadSafe
public class SingletonExample02 {

    // 私有构造函数
    private SingletonExample02() {
    }

    // 单例对象
    private static SingletonExample02 instance = new SingletonExample02();

    // 静态的工厂方法
    public static SingletonExample02 getInstance() {
        return instance;
    }
}

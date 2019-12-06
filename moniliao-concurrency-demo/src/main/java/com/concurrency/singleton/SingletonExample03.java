package com.concurrency.singleton;

import com.concurrency.annotations.NotRecommend;
import com.concurrency.annotations.ThreadSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 懒汉模式：单例实例在第一次使用时创建，线程安全
 */
@ThreadSafe
@NotRecommend
public class SingletonExample03 {

    // 私有构造函数
    private SingletonExample03() {
    }

    // 单例对象
    private static SingletonExample03 instance = null;

    // 静态的工厂方法
    public static synchronized SingletonExample03 getInstance() {
        if(instance == null) {
            instance = new SingletonExample03();
        }
        return instance;
    }
}

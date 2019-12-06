package com.concurrency.singleton;

import com.concurrency.annotations.ThreadNotSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 懒汉模式：单例实例在第一次使用时创建
 */
@ThreadNotSafe
public class SingletonExample01 {

    // 私有构造函数
    private SingletonExample01() {
    }

    // 单例对象
    private static SingletonExample01 instance = null;

    // 静态的工厂方法
    public static SingletonExample01 getInstance() {
        if(instance == null) {
            instance = new SingletonExample01();
        }
        return instance;
    }
}

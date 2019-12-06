package com.concurrency.singleton;

import com.concurrency.annotations.ThreadNotSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 懒汉模式：单例实例在第一次使用时创建
 */
@ThreadNotSafe
public class SingletonExample04 {

    // 私有构造函数
    private SingletonExample04() {
    }

    /**
     * 1.memory = allocate(); 分配对象的内存空间
     * 2.ctorInstance(); 初始化对象
     * 3.instance = memory; 设置instance指向刚分配的内存
     */

    // JVM和CPU优化，发生了指令重排后就是
    // 1.memory = allocate(); 分配对象的内存空间
    // 3.instance = memory; 设置instance指向刚分配的内存
    // 2.ctorInstance(); 初始化对象

    // 单例对象
    private static SingletonExample04 instance = null;

    // 静态的工厂方法
    public static SingletonExample04 getInstance() {
        if(instance == null) {                            // B 执行到 3
            // 双重检测机制 同步锁
            synchronized(SingletonExample04.class) {
                if(instance == null) {
                    instance = new SingletonExample04();  // A - 3
                }
            }
        }
        return instance;
    }
}

package com.concurrency.singleton;

import com.concurrency.annotations.ThreadSafe;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: 饿汉模式：单例实例在类装载使用时创建
 * 在构造函数中存在过多的处理，导致加载的时候特别慢影响性能，或者创建后未使用导致资源浪费
 *
 * 编写静态域或静态代码块时，要注意执行顺序
 */
@ThreadSafe
public class SingletonExample06 {

    // 私有构造函数
    private SingletonExample06() {
    }

    // 单例对象
    private static SingletonExample06 instance = null;

    static {
        instance = new SingletonExample06();
    }

    // 静态的工厂方法
    public static SingletonExample06 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());

        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}

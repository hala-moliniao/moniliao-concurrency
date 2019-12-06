package com.concurrency.publish;

import com.concurrency.annotations.NotRecommend;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: created by limingzhou
 * @date: 2019/11/14
 * @description: com.concurrency.publish
 */
@Slf4j
@NotRecommend
public class UnsafeEscape {

    private int thisCanBeEscape = 0;

    public UnsafeEscape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            // 会造成this引用的逸出，可以通过工厂方法和私有构造器创建
            // 对象在未构造完成之前不允许被发布
            log.info("{}", UnsafeEscape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new UnsafeEscape();
    }
}

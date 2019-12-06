package com.concurrency.publish;

import com.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: created by limingzhou
 * @date: 2019/11/14
 * @description: com.concurrency.publish
 */
@Slf4j
@ThreadNotSafe
public class UnsafePublish {

    // 数据可能被修改，数据不确定
    private String[] states = new String[]{"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish publish = new UnsafePublish();
        log.info("{}", Arrays.toString(publish.getStates()));

        publish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(publish.getStates()));
    }
}

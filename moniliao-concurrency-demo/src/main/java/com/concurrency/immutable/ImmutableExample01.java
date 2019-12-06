package com.concurrency.immutable;

import com.concurrency.annotations.ThreadNotSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.immutable
 */
@Slf4j
@ThreadNotSafe
public class ImmutableExample01 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        // a = 2;
        // b = "aa";
        // map = Maps.newHashMap();
        map.put(1,10);
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
        // a = 1;

        Collections.unmodifiableCollection(new ArrayList<>(10));
    }
}

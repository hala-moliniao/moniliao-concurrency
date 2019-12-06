package com.concurrency.immutable;

import com.concurrency.annotations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.immutable
 */
@Slf4j
@ThreadSafe
public class ImmutableExample02 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,10);
        log.info("{}", map.get(1));
    }

}

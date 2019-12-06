package com.concurrency.immutable;

import com.concurrency.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: created by limingzhou
 * @date: 2019/11/16
 * @description: com.concurrency.immutable
 */
@Slf4j
@ThreadSafe
public class ImmutableExample03 {

    private final static List list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map1 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();

    public static void main(String[] args) {
        System.out.println(map1.get(3));
    }
}

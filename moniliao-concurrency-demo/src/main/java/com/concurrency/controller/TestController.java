package com.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: created by limingzhou
 * @date: 2019/11/10
 * @description: com.concurrency.controller
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "this is a springboot integrating docker project";
    }
}

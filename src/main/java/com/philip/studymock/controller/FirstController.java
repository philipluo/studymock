package com.philip.studymock.controller;

import com.philip.studymock.service.OrderService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by philipl on 2019/6/30.
 */
@RestController
public class FirstController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/")
    public String hello(){
        return "hello: "+orderService.getOrderSource();
    }

}

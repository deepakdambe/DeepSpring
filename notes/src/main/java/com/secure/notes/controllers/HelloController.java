package com.secure.notes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

    AtomicInteger c = new AtomicInteger(1);

    @GetMapping("/")
    public String sayHello() {
        return "Hello 1";
    }

    @GetMapping("/hello")
    public String sayHello2() {
        return "Hello 2";
    }

    @GetMapping("/hi")
    public String sayHi() {
//        System.out.println("req made = " + c.getAndIncrement());
        return "Hiii";
    }
}

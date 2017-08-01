package com.huseyin;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class ZeroCounterController {

    @RequestMapping("/")
    public String index() {
        return "Rest from Spring Boot!";
    }
}

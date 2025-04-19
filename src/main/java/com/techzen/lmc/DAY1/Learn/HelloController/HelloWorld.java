package com.techzen.lmc.DAY1.Learn.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // đánh dấu controller

public class HelloWorld {
    @RequestMapping("hello") // đường dẫn, endpoint
    public String LMC(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "Da Nang") String address) {
        return "Hello " + name + ", " + address + " !";
    }

}

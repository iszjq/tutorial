package cc.iszjq.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/error")
    public String error() {
        return "Something is error";
    }
}

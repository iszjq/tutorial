package cc.iszjq.tutorial.controller;

import cc.iszjq.tutorial.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("xn")) {
            throw new UserNotExistException();
        }
        return "hello";
    }
}

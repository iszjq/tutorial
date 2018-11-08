package cc.iszjq.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HelloController {



    @GetMapping("/success")
    public String success(ModelMap map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("jiaqiang", "xiaonan"));
        return "success";
    }
}

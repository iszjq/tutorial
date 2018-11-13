package cc.iszjq.tutorial.controller;

import cc.iszjq.tutorial.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1.浏览器客户端返回的都是json数据
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.NotExist");
        map.put("message", e.getMessage());
        return map;
    }*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.NotExist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}

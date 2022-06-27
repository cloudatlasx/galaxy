package onem.learn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/27
 * @Version V1.0
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "fuck off";
    }

}

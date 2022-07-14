package onem.learn.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/12
 * @Version V1.0
 */
@RestController
@Slf4j
public class LoginController {
    @PostMapping("/login")
    public void login(String username, String password) {
        log.info("username: {}", username);
        log.info("password: {}", password);
    }
}

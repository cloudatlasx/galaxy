package onem.learn.client.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/17
 * @Version V1.0
 */
@RestController
@RequestMapping
@Slf4j
public class PrintController {
    @GetMapping("/print")
    public String print() {
        log.info("print");
        return "print";
    }
}

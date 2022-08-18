package onem.learn.thread.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/13
 * @Version V1.0
 */
@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @Autowired
    @Qualifier("task")
    private Executor executor;

    @Autowired
    private ThreadHelper threadHelper;

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        executor.execute(() -> {
            log.info("hello execute");
        });
        String threadName = threadHelper.getThreadName();
        log.info("thread name: {}", threadName);
        return "hello spring " + threadName;
    }
}

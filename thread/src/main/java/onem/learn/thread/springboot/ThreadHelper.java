package onem.learn.thread.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/8/18
 * @Version V1.0
 */
@Component
@Slf4j
public class ThreadHelper {
    @Async("task")
    public String getThreadName() {
        log.info("task: {}", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
    }
}

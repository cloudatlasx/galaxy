package onem.learn.thread.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/13
 * @Version V1.0
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        ThreadVariableUtils.put("xx", "xx");
        ExecutorService singleThreadExecutor = new MyThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        singleThreadExecutor.execute(() -> {
            log.info("线程1");
            if (ThreadVariableUtils.contains("xx")) {
                log.info(ThreadVariableUtils.get("xx"));
            } else {
                log.info("none");
                ThreadVariableUtils.put("xx", "xx");
            }
        });
        singleThreadExecutor.execute(() -> {
            log.info("线程2");
            if (ThreadVariableUtils.contains("xx")) {
                log.info(ThreadVariableUtils.get("xx"));
            } else {
                log.info("none");
            }
        });
    }
}

package onem.learn.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("callable running");
        return "success";
    }
}

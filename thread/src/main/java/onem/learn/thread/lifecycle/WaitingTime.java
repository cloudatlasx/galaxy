package onem.learn.thread.lifecycle;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/10
 * @Version V1.0
 */
public class WaitingTime implements Runnable {
    @Override
    public void run() {
        while (true) {
            waitSecond(200);
        }
    }

    public static final void waitSecond(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

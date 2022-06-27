package onem.learn.thread.lifecycle;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/10
 * @Version V1.0
 */
public class BlockedThread implements Runnable {
    @Override
    public void run() {
        synchronized (BlockedThread.class) {
            while (true) {
                WaitingTime.waitSecond(100);
            }
        }
    }
}

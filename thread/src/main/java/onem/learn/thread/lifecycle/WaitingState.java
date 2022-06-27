package onem.learn.thread.lifecycle;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/10
 * @Version V1.0
 */
public class WaitingState implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (WaitingState.class) {
                try {
                    WaitingState.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

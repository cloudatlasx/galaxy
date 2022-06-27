package onem.learn.thread.basic;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("thread running");
    }

}

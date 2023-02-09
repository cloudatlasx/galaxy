package onem.learn.thread.basic;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
public class RunnableDemo implements Runnable {
    String x;
    String y;

    public RunnableDemo(String x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("runnable running");
    }
}

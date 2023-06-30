package onem.learn.thread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/4/12
 * @Version V1.0
 */
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition CONSUMER = lock.newCondition();
    private static final Condition PROVIDER = lock.newCondition();
    private static final Queue<String> data = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        boolean locked = false;
        if (locked = lock.tryLock(3L, TimeUnit.SECONDS)) {
            System.out.println("locked: " + locked);
        }
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                        System.out.println("add before :" + lock.isLocked());
                        lock.lock();
                        System.out.println("add after :" + lock.isLocked());
                        if (data.size() == 0) {
                            TimeUnit.SECONDS.sleep(3L);
                            data.add("data");
                            System.out.println("添加一个数据");
                        } else {
                            CONSUMER.await();
                        }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                        System.out.println("take before :" + lock.isLocked());
                        lock.lock();
                        System.out.println("take after :" + lock.isLocked());
                        if (data.size() > 0) {
                            System.out.println("take data: " + data.poll());
                            System.out.println("消费一个数据");
                            TimeUnit.SECONDS.sleep(1L);
                        } else {
                            CONSUMER.signalAll();
                        }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}

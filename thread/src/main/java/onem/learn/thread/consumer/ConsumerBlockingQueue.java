package onem.learn.thread.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/24
 * @Version V1.0
 */
public class ConsumerBlockingQueue<E> {
    private Queue<E> queue;
    private int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition PROVIDER = lock.newCondition();
    private final Condition CONSUMER = lock.newCondition();

    public ConsumerBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("put");
            if (queue.size() == capacity) {
                PROVIDER.await();
            }
            queue.add(e);
            CONSUMER.signalAll();
        } finally {
            System.out.println("put unlocked");
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("take");
            if (queue.size() == 0) {
                CONSUMER.await();
            }
            E e = queue.poll();
            PROVIDER.signalAll();
            return e;
        } finally {
            System.out.println("take unlocked");
            lock.unlock();
        }
    }
}

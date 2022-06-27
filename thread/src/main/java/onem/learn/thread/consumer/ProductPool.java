package onem.learn.thread.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/24
 * @Version V1.0
 */
public class ProductPool<E> {
    private BlockingQueue<E> pool;

    public ProductPool (int size) {
        pool = new ArrayBlockingQueue<>(size);
    }

    public E get() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void put(E e) {
        try {
            pool.put(e);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

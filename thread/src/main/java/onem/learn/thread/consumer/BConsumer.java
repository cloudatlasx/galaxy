package onem.learn.thread.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/24
 * @Version V1.0
 */
@Slf4j
public class BConsumer<E> implements Runnable{

    private ConsumerBlockingQueue<E> queue;

    public BConsumer(ConsumerBlockingQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 3) {
                    TimeUnit.SECONDS.sleep(5L);
                }
                E e = queue.take();
                log.info("消费：" + e.toString());
                TimeUnit.MILLISECONDS.sleep(500L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
    }
}

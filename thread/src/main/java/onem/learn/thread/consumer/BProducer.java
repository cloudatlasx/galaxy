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
public class BProducer implements Runnable{
    private ConsumerBlockingQueue<Food> queue;

    public BProducer(ConsumerBlockingQueue<Food> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 2 || i == 8) {
                    TimeUnit.SECONDS.sleep(5L);
                }
                Food f = new Food("食物"+i);
                log.info("生产：" + f.toString());
                queue.put(f);
                TimeUnit.MILLISECONDS.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

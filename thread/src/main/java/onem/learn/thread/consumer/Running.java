package onem.learn.thread.consumer;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/24
 * @Version V1.0
 */
public class Running {
    public static void main(String[] args) {
        ProductPool foodPool = new ProductPool<Food>(10);

        foodPool.put(new Food("蜜糖"));
        System.out.println(foodPool.get());

        ConsumerBlockingQueue<Food> foodQueue = new ConsumerBlockingQueue(10);
        new Thread(new BProducer(foodQueue), "producer one").start();
        new Thread(new BConsumer(foodQueue), "consumer one").start();
    }
}

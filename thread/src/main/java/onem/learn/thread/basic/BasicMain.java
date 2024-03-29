package onem.learn.thread.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
@Slf4j
public class BasicMain {
    public static void main(String[] args) throws Exception {
        Thread thread = new ThreadDemo();
        thread.start();
        Thread runnable = new Thread(new RunnableDemo("1", "2"));
        runnable.start();
        FutureTask<String> futureTask = new FutureTask(new CallableDemo());
        Thread callable = new Thread(futureTask);
        callable.start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());
        Future future = CompletableFuture.completedFuture("1");
        CompletableFuture.supplyAsync(() -> "x"
        ).thenAccept(result -> log.info(result)
        ).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        CompletableFuture.supplyAsync(() -> {
            log.info("running supplyAsync");
            return "this is supplyAsync";
        }).thenAcceptAsync((result) -> {
            log.info("{} thenAcceptAsync", result);
        });

    }
}

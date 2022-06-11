package com.learn.galaxy.thread.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
public class BasicMain {
    public static void main(String[] args) throws Exception {
        Thread thread = new ThreadDemo();
        thread.start();
        Thread runnable = new Thread(new RunnableDemo());
        runnable.start();
        FutureTask<String> futureTask = new FutureTask(new CallableDemo());
        Thread callable = new Thread(futureTask);
        callable.start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());

        CompletableFuture.supplyAsync(() -> "x"
        ).thenAccept(result ->  System.out.println("result: " + result)
        ).exceptionally(e -> {
           e.printStackTrace();
           return null;
        });

    }
}

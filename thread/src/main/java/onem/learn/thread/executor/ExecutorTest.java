package onem.learn.thread.executor;

import lombok.SneakyThrows;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/4/12
 * @Version V1.0
 */
public class ExecutorTest {
    public static void main(String[] args) {
        // 3 和 4 不会被执行到
        Executor executor = Executors.newFixedThreadPool(2);
        ExecutorTest executorTest1 = new ExecutorTest();
        ExecutorTest executorTest2 = new ExecutorTest();
        ExecutorTest executorTest3 = new ExecutorTest();
        ExecutorTest executorTest4 = new ExecutorTest();
        executorTest1.name = "Executor1";
        executorTest2.name = "Executor2";
        executorTest3.name = "Executor3";
        executorTest4.name = "Executor4";
        executor.execute(() -> executorTest1.testExecutor());
        executor.execute(() -> executorTest2.testExecutor());
        executor.execute(() -> executorTest3.testExecutor());
        executor.execute(() -> executorTest4.testExecutor());

        ExecutorTest threadTest1 = new ExecutorTest();
        ExecutorTest threadTest2 = new ExecutorTest();
        ExecutorTest threadTest3 = new ExecutorTest();
        ExecutorTest threadTest4 = new ExecutorTest();
        threadTest1.name = "thread1";
        threadTest2.name = "thread2";
        threadTest3.name = "thread3";
        threadTest4.name = "thread4";
        new Thread(() -> threadTest1.testExecutor()).start();
        new Thread(() -> threadTest2.testExecutor()).start();
        new Thread(() -> threadTest3.testExecutor()).start();
        new Thread(() -> threadTest4.testExecutor()).start();
    }
    public String name;
    @SneakyThrows
    public void testExecutor() {
        for (int i = 0; i < 30; i++) {
            if (i % 10 == 0) {
                System.out.println("name: " + name + "休眠两秒");
                TimeUnit.SECONDS.sleep(2L);
            } else {
                System.out.println("name: " + name + "执行：" + i);
                TimeUnit.MILLISECONDS.sleep(500L);
            }
        }
    }
}

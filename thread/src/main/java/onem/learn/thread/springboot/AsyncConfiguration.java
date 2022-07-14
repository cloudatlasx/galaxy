package onem.learn.thread.springboot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/13
 * @Version V1.0
 */
@Configuration
@EnableAsync
@Data
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer {

    @Bean("task")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(10);
        pool.setCorePoolSize(10);//核心线程池数
        pool.setMaxPoolSize(20); // 最大线程
        pool.setQueueCapacity(30);//队列容量
        pool.setThreadNamePrefix("task-work-");
        pool.setTaskDecorator(new ContextDecorator());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.initialize();
        return pool;
    }

    static class ContextDecorator implements TaskDecorator {
        @Override
        public Runnable decorate(Runnable runnable) {
            return () -> {
                try {
                    log.info("TaskDecorator before run");
                    runnable.run();
                    log.info("TaskDecorator after run");
                } finally {
                    log.info("TaskDecorator finally");
                }
            };
        }
    }
}

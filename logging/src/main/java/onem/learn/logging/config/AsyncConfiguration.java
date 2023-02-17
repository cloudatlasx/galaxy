package onem.learn.logging.config;

import lombok.Data;
import org.slf4j.MDC;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 线程池配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.thread-pool")
@EnableAsync
@Data
public class AsyncConfiguration implements AsyncConfigurer {

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;

    private int keepAliveSeconds;


    @Bean("securityTaskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(keepAliveSeconds);
        pool.setCorePoolSize(corePoolSize);//核心线程池数
        pool.setMaxPoolSize(maxPoolSize); // 最大线程
        pool.setQueueCapacity(queueCapacity);//队列容量
        pool.setThreadNamePrefix("task-mtc-work-");
        pool.setTaskDecorator(new ContextDecorator());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.initialize();
        return pool;
    }
    @Bean("logTaskExecutor")
    public Executor logTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(keepAliveSeconds);
        pool.setCorePoolSize(1);// 核心线程池数
        pool.setMaxPoolSize(1); // 最大线程
        pool.setQueueCapacity(Integer.MAX_VALUE);// 队列容量
        pool.setThreadNamePrefix("task-mtc-build-log-");
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.initialize();
        return pool;
    }

    @Bean("transactionLogExecutor")
    public Executor transactionLogExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(keepAliveSeconds);
        pool.setCorePoolSize(1);// 核心线程池数
        pool.setMaxPoolSize(1); // 最大线程
        pool.setQueueCapacity(Integer.MAX_VALUE);// 队列容量
        pool.setThreadNamePrefix("task-mtc-transaction-log-");
        pool.setTaskDecorator(new ContextDecorator());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.initialize();
        return pool;
    }

    @Bean("interfaceLogExecutor")
    public Executor interfaceLogExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(keepAliveSeconds);
        pool.setCorePoolSize(3);// 核心线程池数
        pool.setMaxPoolSize(5); // 最大线程
        pool.setQueueCapacity(Integer.MAX_VALUE);// 队列容量
        pool.setThreadNamePrefix("task-it-");
        pool.setTaskDecorator(new ContextDecorator());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.initialize();
        return pool;
    }

    @Bean("bomTask")
    public Executor bomTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setKeepAliveSeconds(keepAliveSeconds);
        pool.setCorePoolSize(1);// 核心线程池数
        pool.setMaxPoolSize(1); // 最大线程
        pool.setQueueCapacity(100);// 队列容量
        pool.setThreadNamePrefix("task-bom-");
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        pool.initialize();
        return pool;
    }

    static class ContextDecorator implements TaskDecorator {
        @Override
        public Runnable decorate(Runnable runnable) {
            RequestAttributes context = RequestContextHolder.currentRequestAttributes();
            Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
            return () -> {
                try {
                    if (copyOfContextMap == null) {
                        MDC.clear();
                    } else {
                        MDC.setContextMap(copyOfContextMap);
                    }
                    RequestContextHolder.setRequestAttributes(context);
                    runnable.run();
                } finally {
                    RequestContextHolder.resetRequestAttributes();
                    MDC.clear();
                }
            };
        }
    }
}

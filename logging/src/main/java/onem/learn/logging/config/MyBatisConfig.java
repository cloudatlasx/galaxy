package onem.learn.logging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/16
 * @Version V1.0
 */
@Configuration
public class MyBatisConfig {
    @Bean
    SqlCostInterceptor sqlCostInterceptor(){
        return new SqlCostInterceptor();
    }
}
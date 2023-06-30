package onem.learn.pattern.service_locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/6/30
 * @Version V1.0
 */
@Configuration
public class ParserConfig {
    @Bean("parserFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        // 设置服务定位接口
        factoryBean.setServiceLocatorInterface(ParserFactory.class);
        return factoryBean;
    }
}

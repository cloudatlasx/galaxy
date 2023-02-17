package onem.learn.logging.interceptor;

import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/3/20
 * @Version V1.0
 */
@Configuration
public class FeignInterceptor{

}
/*public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String tid = MDC.get(ThreadMdcUtil.TRACE_ID);
        if (StringUtils.isEmpty(tid)) {
            return;
        }
        requestTemplate.header(ThreadMdcUtil.TRACE_ID, tid);
    }
}*/

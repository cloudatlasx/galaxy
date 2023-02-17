package onem.learn.logging.interceptor;

import onem.learn.logging.config.ThreadMdcUtil;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/16
 * @Version V1.0
 */
public class RestTemplateTraceIdInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        String traceId = MDC.get(ThreadMdcUtil.TRACE_ID);
        if (traceId != null) {
            httpRequest.getHeaders().add(ThreadMdcUtil.TRACE_ID, traceId);
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}

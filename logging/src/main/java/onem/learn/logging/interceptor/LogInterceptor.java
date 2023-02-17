package onem.learn.logging.interceptor;

import onem.learn.logging.config.ThreadMdcUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/16
 * @Version V1.0
 */
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //可以考虑让客户端传入链路ID，但需保证一定的复杂度唯一性；如果没使用默认UUID自动生成
        MDC.put(ThreadMdcUtil.TRACE_ID, StringUtils.isEmpty(request.getHeader(ThreadMdcUtil.TRACE_ID))
                ? ThreadMdcUtil.generateTraceId() : request.getHeader(ThreadMdcUtil.TRACE_ID));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        MDC.remove(ThreadMdcUtil.TRACE_ID);
    }
}

package onem.learn.logging.api;

import lombok.extern.slf4j.Slf4j;
import onem.learn.logging.api.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/14
 * @Version V1.0
 */

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/print/{param}")
    public String printLog(@PathVariable String param) {
        log.debug("debug: {}", param);
        log.info("info: {}", param);
        new Thread(() -> {
           log.info("Thread info: {}", param);
        }).start();
        logService.asyncLog(param);
        logService.taskExecutorLog(param);
        return "用户真实姓名为：" + logService.getUserNameByLoginName(param);
    }
    @GetMapping("/error/{param}")
    public String errorLog(@PathVariable String param) {
        try {
            log.info("打印参数为：{}", param);
            int x = 1 / 0;
        } catch (Exception e) {
            log.error("errorLog exception", e);
        }
        return "您输入的参数为：" + param;
    }

    @GetMapping("/realName/{loginName}")
    public String getRealName(@PathVariable String loginName) {
        log.info("loginName: {}", loginName);
        String realName = logService.getRealNameByLoginName(loginName);
        log.info("realName: {}", realName);
        return realName;
    }
}

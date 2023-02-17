package onem.learn.logging.api.service;

import lombok.extern.slf4j.Slf4j;
import onem.learn.logging.api.entity.User;
import onem.learn.logging.api.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/15
 * @Version V1.0
 */
@Service
@Slf4j
public class LogService {
    private final UserMapper userMapper;
    private final RestTemplate restTemplate;

    public LogService(UserMapper userMapper, RestTemplate restTemplate) {
        this.userMapper = userMapper;
        this.restTemplate = restTemplate;
    }

    @Async("logTaskExecutor")
    public void asyncLog(String message) {
        log.info("default asyncLog: {}", message);
    }
    @Async("securityTaskExecutor")
    public void taskExecutorLog(String message) {
        log.info("taskExecutorLog: {}", message);
    }

    public String getUserNameByLoginName(String loginName) {
        return Optional.ofNullable(userMapper.getUserByLoginName(loginName)).orElse(new User()).getRealName();
    }

    public String getRealNameByLoginName(String loginName) {
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity("http://127.0.0.1:10031/log/realName/" + loginName, String.class);
        return forEntity.getBody();
    }
}

package onem.learn.security.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/13
 * @Version V1.0
 */
@Data
public class SmsCode {
    private String code;
    private LocalDateTime expireTime;

    public SmsCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public SmsCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}

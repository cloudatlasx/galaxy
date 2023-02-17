package onem.learn.logging.api.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/16
 * @Version V1.0
 */
@Data
public class User {
    private Long id;
    private String loginName;
    private String realName;
    private LocalDateTime creationDate;
}

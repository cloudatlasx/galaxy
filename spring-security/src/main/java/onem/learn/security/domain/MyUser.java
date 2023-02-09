package onem.learn.security.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/12
 * @Version V1.0
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = -7071565239983297568L;

    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

}

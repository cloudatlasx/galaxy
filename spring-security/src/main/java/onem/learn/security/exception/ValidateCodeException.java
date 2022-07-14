package onem.learn.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/13
 * @Version V1.0
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7727166111486891175L;

    public ValidateCodeException(String explanation) {
        super(explanation);
    }


}

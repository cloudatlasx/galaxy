package onem.learn.security.config;

import onem.learn.security.filter.ValidateCodeFilter;
import onem.learn.security.handler.MyAuthenticationFailureHandler;
import onem.learn.security.handler.MyAuthenticationSuccessHandler;
import onem.learn.security.infra.constant.Constants;
import onem.learn.security.validata.SmsAuthenticationConfig;
import onem.learn.security.validata.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/27
 * @Version V1.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final String LOGIN_URL = "/login";
    private final String[] PERMIT_ALL = {Constants.SpringSecurity.LOGIN_PAGE,
                                        Constants.SpringSecurity.AUTHENTICATION,
                                        "/css/**", "/code/image", "/code/sms"};
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    @Autowired
    private SmsCodeFilter smsCodeFilter;
    @Autowired
    @Lazy
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加短信验证码校验过滤器
                .formLogin()
                .loginPage(Constants.SpringSecurity.AUTHENTICATION)
                .loginProcessingUrl(LOGIN_URL)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers(PERMIT_ALL).permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .apply(smsAuthenticationConfig) // 将短信验证码认证配置加到 Spring Security 中
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package onem.learn.security.service;

import lombok.extern.slf4j.Slf4j;
import onem.learn.security.domain.MyUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/7/12
 * @Version V1.0
 */
@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public UserDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟查询一个用户
        MyUser user = new MyUser();
        user.setUserName(username);
        user.setPassword(this.passwordEncoder.encode("qwerty"));
        log.info(user.getPassword());
        return new User(username, user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonExpired(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

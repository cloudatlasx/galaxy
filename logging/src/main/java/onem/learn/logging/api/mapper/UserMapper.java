package onem.learn.logging.api.mapper;

import onem.learn.logging.api.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/2/16
 * @Version V1.0
 */
@Repository
@Mapper
public interface UserMapper {
    User getUserByLoginName(@Param("loginName") String loginName);
}

package cn.zack.jpa;

import cn.zack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zack
 * user业务持久层
 * 继承JpaRepository, 并声明实体类和主键类型
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {

    /**
     * 根据userId查询user
     * @param userId
     * @return
     */
    User findByUserId(String userId);

    /**
     * 根据userId删除user
     * @param userId
     * @return
     */
    Integer deleteByUserId(String userId);

}

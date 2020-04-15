package cn.zack.service.impl;

import cn.zack.jpa.UserJpaRepository;
import cn.zack.pojo.User;
import cn.zack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zack
 * user业务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入userJpaRepository
     */
    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * 根据userId获取user信息
     * <p>
     * 使用@Cacheable将同一个参数在此方法第一次执行成功后的结果存入redis, 并声明以什么为key
     * 后续同一个参数的请求直接从redis中取结果, 不再从mysql中取
     * </p>
     *
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "user", key = "#userId")
    public User getUserByUserId(Long userId) {
        User user = userJpaRepository.findById(userId).get();
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserByUserId(Long userId) {

    }
}

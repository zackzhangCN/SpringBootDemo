package cn.zack.service.impl;

import cn.zack.jpa.UserJpaRepository;
import cn.zack.pojo.User;
import cn.zack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
     * 新增user
     *
     * @param user
     */
    @Override
    public User addUser(User user) {
        // 先查询数据库中是否存在此条数据
        User byUserId = userJpaRepository.findByUserId(user.getUserId());
        // 不存在, 插入数据库
        if (byUserId == null) {
            User user1 = userJpaRepository.save(user);
            return user1;
        } else {
            return null;
        }
    }

    /**
     * 根据唯一Id获取user信息
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
    public User getUserByUserId(String userId) {
        // 根据userId从数据库中查询
        User user = userJpaRepository.findByUserId(userId);
        return user;
    }

    /**
     * 更新user信息
     * 使用@CachePut将被更新的用户信息同步到redis
     *
     * @param user
     * @return
     */
    @Override
    @CachePut(value = "user", key = "#user.userId")
    public User updateUser(User user) {
        // 先删除, 再插入(或者在userJpaRepository写一条更新sql)
        userJpaRepository.deleteByUserId(user.getUserId());
        User user1 = userJpaRepository.save(user);
        return user1;
    }

    /**
     * 根据user唯一userId删除user
     * 使用@CacheEvict将此key在redis中的value删除
     *
     * @param userId
     * @return
     */
    @Override
    @CacheEvict(value = "user", key = "#userId")
    public String deleteUserByUserId(String userId) {
        String response;
        Integer integer = userJpaRepository.deleteByUserId(userId);
        if (integer == 1) {
            response = "OK";
        } else {
            response = "FAIL";
        }
        return response;
    }
}

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
     * 新增user
     *
     * @param user
     */
    @Override
    public String addUser(User user) {
        // 返回报文
        String response;
        // 先查询数据库中是否存在此条数据
        User byUserId = userJpaRepository.findByUserId(user.getUserId());
        // 不存在, 直接插入数据库
        if (byUserId == null) {
            userJpaRepository.save(user);
            response = "OK";
        } else {
            response = "FAIL";
        }
        return response;
    }

    /**
     * 更新user信息
     *
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        User user1 = userJpaRepository.save(user);
        return user1;
    }

    /**
     * 根据user唯一userId删除user
     * @param userId
     * @return
     */
    @Override
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

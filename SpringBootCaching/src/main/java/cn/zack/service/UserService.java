package cn.zack.service;

import cn.zack.pojo.User;

/**
 * @author zack
 * user业务接口
 */
public interface UserService {

    /**
     * 根据userId获取user信息
     *
     * @param userId
     * @return
     */
    User getUserByUserId(Long userId);

    /**
     * 更新user信息
     *
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 根据userId删除user
     *
     * @param userId
     */
    void deleteUserByUserId(Long userId);
}

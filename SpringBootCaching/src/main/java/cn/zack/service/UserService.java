package cn.zack.service;

import cn.zack.pojo.User;

/**
 * @author zack
 * user业务接口
 */
public interface UserService {

    /**
     * 新增user
     *
     * @param user
     */
    User addUser(User user);

    /**
     * 根据userId获取user信息
     *
     * @param id
     * @return
     */
    User getUserByUserId(String id);

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
    String deleteUserByUserId(String userId);
}

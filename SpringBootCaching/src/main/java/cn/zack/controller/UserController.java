package cn.zack.controller;

import cn.zack.entity.User;
import cn.zack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zack
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    /**
     * 注入userService
     */
    @Autowired
    private UserService userService;

    /**
     * 新增user
     *
     * @param user
     * @return
     */
    @PostMapping(path = "addUser")
    public User addUser(@RequestBody User user) {
        User user1 = userService.addUser(user);
        return user1;
    }

    /**
     * 根据userId获取user信息
     *
     * @param userId
     * @return
     */
    @GetMapping(path = "findById/{userId}")
    public User getUserByUserId(@PathVariable("userId") String userId) {
        User user = userService.getUserByUserId(userId);
        return user;
    }

    /**
     * 修改user
     *
     * @param user
     * @return
     */
    @PostMapping(path = "updateUser")
    public User updateUser(@RequestBody User user) {
        User user1 = userService.updateUser(user);
        return user1;
    }

    /**
     * 根据userId删除user
     * @param userId
     * @return
     */
    @GetMapping(path = "deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        String response = userService.deleteUserByUserId(userId);
        return response;
    }

}

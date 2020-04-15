package cn.zack.controller;

import cn.zack.pojo.User;
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
     * 新增user
     *
     * @param user
     * @return
     */
    @PostMapping(path = "addUser")
    public String addUser(@RequestBody User user) {
        String response = userService.addUser(user);
        return response;
    }

}

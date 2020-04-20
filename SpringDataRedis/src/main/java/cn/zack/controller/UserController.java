package cn.zack.controller;

import cn.zack.pojo.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack
 */
@RestController
@RequestMapping(path = "user")
public class UserController {

    /**
     * 由于value为object类型, 可直接以bean为value
     * 使用resources根据名称注入, 如果使用autoware根据类型注入需要先注入一个redistemplate
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(path = "setBean/{key}")
    public String set(@PathVariable("key") String key) {
        User user = new User(key, "password", "1");
        redisTemplate.opsForValue().set(key, user);
        return "OK";
    }

    @GetMapping(path = "getBean/{key}")
    public User getBean(@PathVariable("key") String key) {
        User user = (User) redisTemplate.opsForValue().get(key);
        return user;
    }

}

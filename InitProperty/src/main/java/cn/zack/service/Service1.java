package cn.zack.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 当ApplicationContext中存在 flag的值为1时 注入这个bean
 */
@Component
@ConditionalOnProperty(name = "flag",havingValue = "service1")
public class Service1 {

    {
        System.out.println("注入了service1");
    }
}

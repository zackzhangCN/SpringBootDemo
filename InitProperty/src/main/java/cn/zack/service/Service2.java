package cn.zack.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 当ApplicationContext中存在 flag的值为2时 配置生效, 注入这个bean
 */
@Component
@ConditionalOnProperty(name = "flag",havingValue = "service2")
public class Service2 {

    {
        System.out.println("注入了service2");
    }
}

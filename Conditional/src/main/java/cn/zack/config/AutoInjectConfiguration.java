package cn.zack.config;

import cn.zack.service.Service1;
import cn.zack.service.Service2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 批量注入配置类
 * @Conditional: 当条件全部成立时, 才会生效
 */
@Configuration
@Conditional({MyCondition1.class,MyCondition2.class})
public class AutoInjectConfiguration {
    @Bean
    public Service1 service1(){
        return new Service1();
    }

    @Bean
    public Service2 service2(){
        return new Service2();
    }
}

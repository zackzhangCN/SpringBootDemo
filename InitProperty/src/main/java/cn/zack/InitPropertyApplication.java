package cn.zack;

import cn.zack.config.InitPropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InitPropertyApplication {
    public static void main(String[] args) {
        // 创建一个springApplication, 在启动时添加加载自定义配置, 控制configuration是否生效
        SpringApplication application = new SpringApplication(InitPropertyApplication.class);
        application.addInitializers(new InitPropertyConfig());
        application.run(args);
    }
}

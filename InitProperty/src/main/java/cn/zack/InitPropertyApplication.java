package cn.zack;

import cn.zack.config.InitPropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InitPropertyApplication {
    public static void main(String[] args) {
        // 创建一个springApplication, 在启动时添加自定义配置
        SpringApplication application = new SpringApplication(InitPropertyApplication.class);
        application.addInitializers(new InitPropertyConfig());
        application.run(args);
    }
}

package cn.zack.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * 实现ApplicationContextInitializer接口, 重写其initialize方法
 * 此处在SpringBoot启动时根据选择的profile, 选择注入Service1或者Service2
 *
 * @Order(Integer.MIN_VALUE) 值越小, 在容器中bean的执行顺序越靠前
 */
@Order(Integer.MIN_VALUE)
public class InitPropertyConfig implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // 当前启动选择的spring profile
        String[] activeProfiles = configurableApplicationContext.getEnvironment().getActiveProfiles();
        String thisActiveProfile = activeProfiles[0];
        System.out.println("当前profile为: " + thisActiveProfile);

        HashMap<String, Object> map = new HashMap<>(8);
        // 当profile为dev时, 只注入service1, 当profile为pro时, 只注入service2
        if (thisActiveProfile.equals("dev")) {
            map.put("flag", "service1");
        } else if (thisActiveProfile.equals("pro")) {
            map.put("flag", "service2");
        } else {
            map.put("flag", "");
        }
        MapPropertySource propertySource = new MapPropertySource("myFlag", map);
        configurableApplicationContext.getEnvironment().getPropertySources().addLast(propertySource);
    }
}

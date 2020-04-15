package cn.zack.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack
 * <p>
 * 使用@EnableCaching开启缓存支持(默认关闭)
 * 允许通过redis缓存数据
 * </p>
 */
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {
}

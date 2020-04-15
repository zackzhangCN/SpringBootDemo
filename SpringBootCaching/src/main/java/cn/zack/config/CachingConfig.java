package cn.zack.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack
 * 开启缓存支持(默认关闭)
 */
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {
}

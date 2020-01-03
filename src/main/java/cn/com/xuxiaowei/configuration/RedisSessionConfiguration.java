package cn.com.xuxiaowei.configuration;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * 开启 Redis Session 缓存
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
@EnableRedisHttpSession
public class RedisSessionConfiguration {

    /**
     * Cookie Name
     * <p>
     * 默认为：SESSION
     *
     * @see DefaultCookieSerializer#setCookieName(String) 方法中使用的全局变量
     */
    public static final String COOKIE_NAME = "SESSION";

    /**
     * Cookie 有效时间，秒
     * <p>
     * 默认设置是在浏览器关闭时删除cookie。
     * <p>
     * 7 天
     *
     * @see DefaultCookieSerializer#setCookieMaxAge(int)
     */
    public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 7;

    /**
     * 在主域中储存Cookie，子域中共享Cookie
     */
    @Bean
    protected CookieSerializer cookieSerializer() {

        // 默认 Cookie 序列化
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();

        // Cookie名字，默认为 SESSION
        defaultCookieSerializer.setCookieName(COOKIE_NAME);

        // 域，这允许跨子域共享cookie，默认设置是使用当前域。
        defaultCookieSerializer.setDomainName("127.0.0.1");

        // Cookie的路径。
        defaultCookieSerializer.setCookiePath("/");

        // 设置 浏览器 Cookie（Session） 默认 过期时间
        defaultCookieSerializer.setCookieMaxAge(COOKIE_MAX_AGE);

        return defaultCookieSerializer;
    }

}

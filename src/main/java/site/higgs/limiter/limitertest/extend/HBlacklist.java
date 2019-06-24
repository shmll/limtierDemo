package site.higgs.limiter.limitertest.extend;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扩展一个黑名单组件
 */
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HBlacklist {
    String limiter() default "";

    String key() default "#userInfo.userId";

    String fallback() default "defaultFallbackResolver";

    String errorHandler() default "defaultErrorHandler";

    String[] argumentInjectors() default {};

    String serviceId() default "";
}

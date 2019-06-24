package site.higgs.limiter.limitertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.higgs.limiter.LimitedFallbackResolver;
import site.higgs.limiter.limitertest.vo.ResponseMessage;
import site.higgs.limiter.resource.LimitedResource;

import java.lang.reflect.Method;

/**
 * 怎样定义通用的降级方法
 */
@Configuration
public class FallbackConfig {

    @Bean
    LimitedFallbackResolver busyService() {
        return new LimitedFallbackResolver() {
            @Override
            public Object resolve(Method method, Class aClass, Object[] objects, LimitedResource limitedResource, Object o) {
                return ResponseMessage.error("服务繁忙，请稍后再试！");
            }
        };
    }

    @Bean
    LimitedFallbackResolver throwError() {
        return new LimitedFallbackResolver() {
            @Override
            public Object resolve(Method method, Class aClass, Object[] objects, LimitedResource limitedResource, Object o) {
                throw new RuntimeException("");
            }
        };
    }

    @Bean
    LimitedFallbackResolver sleepOnSecond() {
        return new LimitedFallbackResolver() {
            @Override
            public Object resolve(Method method, Class aClass, Object[] objects, LimitedResource limitedResource, Object o) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }

}

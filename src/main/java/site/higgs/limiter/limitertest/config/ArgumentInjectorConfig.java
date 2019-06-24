package site.higgs.limiter.limitertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.higgs.limiter.ArgumentInjector;

@Configuration
public class ArgumentInjectorConfig {

    @Bean
    ArgumentInjector userInfoInjector(){
        return new UserInfoArgumentInjector();
    }

}

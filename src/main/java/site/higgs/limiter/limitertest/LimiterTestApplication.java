package site.higgs.limiter.limitertest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.higgs.limiter.annotation.EnableLimiter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
// 使用前修改redis 和 zookeeper配置 要不然启动会失败的
@EnableLimiter(annotationParser = {"site.higgs.limiter.limitertest.extend.BlacklistAnnotationParser"})
public class LimiterTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LimiterTestApplication.class, args);
    }
}

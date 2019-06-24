package site.higgs.limiter.limitertest.config;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.higgs.limiter.lock.Lock;
import site.higgs.limiter.lock.jdk.JdkLock;
import site.higgs.limiter.lock.redis.RedisLock;
import site.higgs.limiter.lock.zookeeper.ZookeeperLock;

@Configuration
/**
 * 这个类展示如何注入Lock类限制器
 *
 */
public class LockConfig {


    @Bean
        /*一个jdklock
         */
    Lock jdklock() {
        return new JdkLock("myjdklock");
    }


    @Bean
    Lock redislock() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(1);
        return new RedisLock(Redisson.create(config), "myredisLock");
    }


    @Bean
    Lock zookeeperlock() {
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2182,127.0.0.1:2181,127.0.0.1:2183",
                5000, 10000, new RetryPolicy() {
                    @Override
                    public boolean allowRetry(int retryCount, long elapsedTimeMs, RetrySleeper sleeper) {
                        return false;
                    }
                });
        client.start();
        return new ZookeeperLock("myZookeeperLock", client);
    }

}

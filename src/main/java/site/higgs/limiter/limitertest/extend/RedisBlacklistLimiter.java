package site.higgs.limiter.limitertest.extend;

import org.redisson.client.RedisClient;

public class RedisBlacklistLimiter
        extends BlacklistLimiter
{
    String name;
    RedisClient redisClient;

    public RedisBlacklistLimiter(String name, RedisClient redisClient)
    {
        this.name = name;
        this.redisClient = redisClient;
    }

    public boolean checkExist(Object userId, String serviceId)
    {
        return false;
    }

    public String getLimiterName()
    {
        return this.name;
    }
}

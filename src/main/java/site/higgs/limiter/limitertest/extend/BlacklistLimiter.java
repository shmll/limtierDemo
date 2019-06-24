package site.higgs.limiter.limitertest.extend;

import java.util.Map;
import site.higgs.limiter.Limiter;

public abstract class BlacklistLimiter
        implements Limiter<HBlacklist>
{
    public abstract boolean checkExist(Object paramObject, String paramString);

    public boolean limit(Object key, Map<String, Object> args)
    {
        return !checkExist(key, (String)args.get("serviceId"));
    }

    public void release(Object key, Map<String, Object> args) {}
}

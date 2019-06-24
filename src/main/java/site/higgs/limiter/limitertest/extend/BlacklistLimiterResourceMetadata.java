package site.higgs.limiter.limitertest.extend;

import java.lang.reflect.Method;
import org.springframework.beans.factory.BeanFactory;
import site.higgs.limiter.metadata.AbstractLimitedResourceMetadata;

public class BlacklistLimiterResourceMetadata
        extends AbstractLimitedResourceMetadata<BlacklistResource>
{
    public BlacklistLimiterResourceMetadata(BlacklistResource limitedResource, Class<?> targetClass, Method targetMethod, BeanFactory beanFactory)
    {
        super(limitedResource, targetClass, targetMethod, beanFactory);
    }

    protected void parseInternal(BlacklistResource limitedResource) {}
}

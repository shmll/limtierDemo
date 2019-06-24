package site.higgs.limiter.limitertest.extend;

import java.lang.reflect.Method;
import java.util.Collection;
import org.springframework.beans.factory.BeanFactory;
import site.higgs.limiter.annotation.LimiterParameter;
import site.higgs.limiter.metadata.LimitedResourceMetadata;
import site.higgs.limiter.resource.AbstractLimitedResource;

public class BlacklistResource
        extends AbstractLimitedResource
{
    @LimiterParameter
    String serviceId;

    public BlacklistResource(String key, Collection<String> argumentInjectors, String fallback, String errorHandler, String limiter, String serviceId)
    {
        super(key, argumentInjectors, fallback, errorHandler, limiter);
        this.serviceId = serviceId;
    }

    public LimitedResourceMetadata createMetadata(BeanFactory beanFactory, Class targetClass, Method targetMethod)
    {
        return new BlacklistLimiterResourceMetadata(this, targetClass, targetMethod, beanFactory);
    }
}

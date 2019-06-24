package site.higgs.limiter.limitertest.extend;

import org.springframework.core.annotation.AnnotationAttributes;
import site.higgs.limiter.AbstractLimiterAnnotationParser;
import site.higgs.limiter.resource.LimitedResource;

public class BlacklistAnnotationParser
        extends AbstractLimiterAnnotationParser<BlacklistLimiter, HBlacklist>
{
    public LimitedResource<BlacklistLimiter> parseLimiterAnnotation(AnnotationAttributes attributes)
    {
        return new BlacklistResource(getKey(attributes),
                getArgumentInjectors(attributes),
                getFallback(attributes),
                getErrorHandler(attributes),
                getLimiter(attributes), attributes
                .getString("serviceId"));
    }
}

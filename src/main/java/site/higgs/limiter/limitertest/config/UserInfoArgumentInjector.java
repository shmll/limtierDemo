package site.higgs.limiter.limitertest.config;

import java.util.HashMap;
import java.util.Map;

import site.higgs.limiter.ArgumentInjector;

/**
 * 定义一个参数注入器，该注入器向运行上下文中注入了一个userInfo 参数
 * 可以使用 #userInfo 提取该参数
 */
public class UserInfoArgumentInjector
        implements ArgumentInjector {
    public Map<String, Object> inject(Object... args) {
        Map<String, Object> ret = new HashMap();
        ret.put("userInfo", ContextUtils.getCurrentUser());
        return ret;
    }
}

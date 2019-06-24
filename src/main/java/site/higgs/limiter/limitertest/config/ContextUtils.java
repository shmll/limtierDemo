package site.higgs.limiter.limitertest.config;

import site.higgs.limiter.limitertest.vo.UserInfo;

public class ContextUtils
{
    public static UserInfo getCurrentUser()
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(Integer.valueOf(2584956));
        return userInfo;
    }
}

package site.higgs.limiter.limitertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.higgs.limiter.limitertest.service.PTService;
import site.higgs.limiter.limitertest.vo.ResponseMessage;
import site.higgs.limiter.lock.HLock;

@RestController
@RequestMapping({"/pt"})
public class PTController {
    @Autowired
    PTService ptService;


    /**
     * 使用jdklock
     * 使用userInfoInjector注入UserInfo
     * 使用busyService降级
     *
     * @return
     */
    @RequestMapping(value = {"/jdklock"}, method = {RequestMethod.GET})
    @HLock(key = "#userInfo.userId", limiter = "jdklock", fallback = "busyService", argumentInjectors = {"userInfoInjector"})
    public ResponseMessage jdklock() {
        return this.ptService.sleep(1000L);
    }

    /**
     * 使用redisLock
     * 使用throwError 降级
     *
     * @return
     */
    @RequestMapping(value = {"/redislock"}, method = {RequestMethod.GET})
    @HLock(key = "#userInfo.userId", limiter = "redislock", fallback = "throwError", argumentInjectors = {"userInfoInjector"})
    public ResponseMessage redislock() {
        return this.ptService.sleep(1000L);
    }

    /**
     * 使用同类下的方法降级
     *
     * @return
     */
    @RequestMapping(value = {"/zookeeperlock"}, method = {RequestMethod.GET})
    @HLock(key = "#userInfo.userId", limiter = "zookeeperlock", fallback = "localMethodFallback", argumentInjectors = {"userInfoInjector"})
    public ResponseMessage zookeeperlock() {
        return this.ptService.sleep(1000L);
    }


    public ResponseMessage localMethodFallback() {
        return ResponseMessage.error("使用同类下的方法降级");
    }
}

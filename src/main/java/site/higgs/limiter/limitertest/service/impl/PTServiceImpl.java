package site.higgs.limiter.limitertest.service.impl;

import org.springframework.stereotype.Service;
import site.higgs.limiter.limitertest.service.PTService;
import site.higgs.limiter.limitertest.vo.ResponseMessage;

@Service
public class PTServiceImpl implements PTService {
    public ResponseMessage sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseMessage.ok();
    }
}

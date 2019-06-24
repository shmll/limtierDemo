package site.higgs.limiter.limitertest.vo;

import javax.validation.constraints.NotNull;

public class ExchangeVipRequest
        extends Request
{
    @NotNull(message="兑换码不能为空")
    String vipCode = "vipCode";

    public String getVipCode()
    {
        return this.vipCode;
    }

    public void setVipCode(String vipCode)
    {
        this.vipCode = vipCode;
    }
}

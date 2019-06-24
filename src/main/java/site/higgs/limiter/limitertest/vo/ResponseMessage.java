package site.higgs.limiter.limitertest.vo;

public class ResponseMessage<T>
{
    public int code;
    public String message;
    public boolean success;
    public T result;

    public static ResponseMessage ok()
    {
        return ok(null);
    }

    public static ResponseMessage ok(Object obj)
    {
        ResponseMessage ret = new ResponseMessage();
        ret.setCode(200);
        ret.setSuccess(true);
        ret.setResult(obj);
        ret.setMessage("����������");
        return ret;
    }

    public static ResponseMessage error(String message)
    {
        ResponseMessage ret = new ResponseMessage();
        ret.setCode(200);
        ret.setSuccess(false);
        ret.setMessage(message);
        return ret;
    }

    public int getCode()
    {
        return this.code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public T getResult()
    {
        return (T)this.result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

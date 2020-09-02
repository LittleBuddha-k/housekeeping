package com.littlebuddha.housekeeping.exception.shiro;

/**
 * @author ck
 * @date 2020/7/24 9:49
 */
public class CShiroException extends org.apache.shiro.ShiroException {

    public CShiroException() {
        super();
    }

    public CShiroException(String message) {
        super(message);
    }

    public CShiroException(Throwable cause) {
        super(cause);
    }

    public CShiroException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.msunsoft.spt.common.exceptions;


import com.msunsoft.spt.common.response.ResponseCode;

/**
 * @author zxl
 * @create 2020/8/24 0024 15:10
 * 全局业务异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4868842805385777275L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
        this.code = -1;
    }

    public BusinessException(ResponseCode status) {
        super(status.message());
        this.code = status.code();
    }
}

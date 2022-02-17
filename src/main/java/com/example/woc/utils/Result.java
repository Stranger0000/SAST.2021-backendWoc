package com.example.woc.utils;

import com.example.woc.exception.BaseErrorInfoInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xyx
 * @date: 2022/2/12 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Boolean success;
    private String errMsg;
    private Integer errCode;
    private Object data;

    public Result(BaseErrorInfoInterface errorInfo) {
        this.errCode = errorInfo.getErrCode();
        this.errMsg = errorInfo.getErrMsg();
    }



    /**
     * 成功
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result rb = new Result();
        rb.setSuccess(true);
        rb.setErrCode(RMsgEnum.SUCCESS.getErrCode());
        rb.setErrMsg(RMsgEnum.SUCCESS.getErrMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static Result error(BaseErrorInfoInterface errorInfo) {
        Result rb = new Result();
        rb.setSuccess(false);
        rb.setErrCode(errorInfo.getErrCode());
        rb.setErrMsg(errorInfo.getErrMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static Result error(Integer code, String message) {
        Result rb = new Result();
        rb.setSuccess(false);
        rb.setErrCode(code);
        rb.setErrMsg(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static Result error( String message) {
        Result rb = new Result();
        rb.setSuccess(false);
        rb.setErrCode(-1);
        rb.setErrMsg(message);
        rb.setData(null);
        return rb;
    }


}

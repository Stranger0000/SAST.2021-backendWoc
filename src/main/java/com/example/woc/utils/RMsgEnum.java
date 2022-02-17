package com.example.woc.utils;

import com.example.woc.exception.BaseErrorInfoInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xyx
 * @date 2022/2/16 14:07
 */

@AllArgsConstructor
@NoArgsConstructor
public enum RMsgEnum implements BaseErrorInfoInterface {
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");
    private Integer errCode;
    private String errMsg;

    @Autowired
    public Integer getErrCode() {
        return this.errCode;
    }

    @Autowired
    public String getErrMsg() {
        return this.errMsg;
    }


}

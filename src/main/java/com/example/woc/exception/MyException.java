package com.example.woc.exception;


/**
 * @author xyx
 * @date 2022/2/17 10:59
 */

public class MyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    protected Integer errorCode;
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getErrMsg());
        this.errorCode = errorInfoInterface.getErrCode();
        this.errorMsg = errorInfoInterface.getErrMsg();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getErrMsg(), cause);
        this.errorCode = errorInfoInterface.getErrCode();
        this.errorMsg = errorInfoInterface.getErrMsg();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

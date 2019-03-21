package com.yumi.mall.member.dto;

/**
 * 通用返回对象
 * Created by yumi on 2019/4/26.
 */
public class CommonResult {
    //操作成功
    public static final int SUCCESS = 200;
    //操作失败
    public static final int FAILED = 500;
    private int code;
    private String message;
    private Object data;

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     */
    public CommonResult success(Object data) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        return this;
    }

    /**
     * 普通成功返回
     */
    public CommonResult success(String message,Object data) {
        this.code = SUCCESS;
        this.message = message;
        this.data = data;
        return this;
    }

    /**
     * 普通失败提示信息
     */
    public CommonResult failed() {
        this.code = FAILED;
        this.message = "操作失败";
        return this;
    }

    public CommonResult failed(String message){
        this.code = FAILED;
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
